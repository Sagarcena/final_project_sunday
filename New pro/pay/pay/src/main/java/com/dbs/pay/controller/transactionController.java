package com.dbs.pay.controller;

import com.dbs.pay.model.TransactionRequested;
import com.dbs.pay.model.bank;
import com.dbs.pay.model.currency;
import com.dbs.pay.model.customer;
import com.dbs.pay.model.message;
import com.dbs.pay.model.transaction;
import com.dbs.pay.model.transfertypes;
import com.dbs.pay.repository.bankRespository;
import com.dbs.pay.repository.currencyRespository;
import com.dbs.pay.repository.customerRespository;
import com.dbs.pay.repository.messageRespository;
import com.dbs.pay.repository.transactionRespository;
import com.dbs.pay.repository.transfertypesRespository;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

//import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@Controller
@ResponseBody
@RequestMapping("/tc")

public class transactionController 
{
    private final transactionRespository transactionrepository;
    @Autowired
    private final customerRespository customerrepository;
    private final bankRespository bankrepository;
    private final currencyRespository currencyrepository;
    private final messageRespository messagerepository;
    private final transfertypesRespository transfertypesrepository ;

	public transactionController(transactionRespository transactionrepository, customerRespository customerrepository,
			bankRespository bankrepository, currencyRespository currencyrepository,
			messageRespository messagerepository, transfertypesRespository transfertypesrepository) 
    {
		super();
		this.transactionrepository = transactionrepository;
		this.customerrepository = customerrepository;
		this.bankrepository = bankrepository;
		this.currencyrepository = currencyrepository;
		this.messagerepository = messagerepository;
		this.transfertypesrepository = transfertypesrepository;
	}

	@GetMapping
     public List<transaction> getTransaction()
     {
         return transactionrepository.findAll();
     }
     
    @GetMapping("/{transactionid}")
     public transaction getTransaction(@PathVariable Long transactionid)
    {
         return transactionrepository.findById(transactionid).orElseThrow();
    
    }
    
    public void bank_check(TransactionRequested request)
    {
        customer sender = customerrepository.findById((request.getSender_customerid())).get();
        
		customer receiver = customerrepository.findById((request.getReciever_accountholder_number())).get();
		
		StringTokenizer sendername = new StringTokenizer(sender.getAccountholdername());
		
		StringTokenizer receivername = new StringTokenizer(receiver.getAccountholdername());

		String f_sendername = sendername.nextToken();
		
		String f_receivername = receivername.nextToken();
		
		if(f_sendername.equals("HDFC") && f_receivername.equals("HDFC"))
		{
			ToProcesstransaction(request);
		}
		else if(!(f_sendername.equals("HDFC")) && !(f_receivername.equals("HDFC")))
		{
			ToProcesstransaction(request);
		}
		else
		{
			System.out.println("Transaction not possible");
		}
    }
    
    
    public transaction ToStoreTransaction(customer cust_id,currency curr,Double transferfees,Double inramount,Date transferdate,Double currencyamount,message messagecode,transfertypes transfercode,bank bic)
    {      	
    	transaction t = new transaction();
    	t.setCustomer(cust_id);
    	t.setCurr(curr);
    	t.setTransferfees(transferfees);
    	t.setInramount(inramount);
    	t.setTransferdate(transferdate);
    	t.setCurrencyamount(currencyamount);
    	t.setMesagecode(messagecode);
    	t.setTransfertype(transfercode);
    	t.setReceiverbank(bic);
    	
    	
			return transactionrepository.save(t);
  }
     
    public String ToProcesstransaction(TransactionRequested request)
	{ 
		customer sender = customerrepository.findById((request.getSender_customerid())).get();
        
		customer receiver = customerrepository.findById((request.getReciever_accountholder_number())).get();
		
		Double transferFee =0.0025 * request.getAmount();
		currency curr = currencyrepository.findById((request.getCur())).get();
		Double in_inr = request.getAmount()*(curr.getConversionrate());
		Double totalAmount = in_inr + transferFee;
		
		double clear_balance = Double.parseDouble(sender.getClearbalance());
		
		if((clear_balance>totalAmount)||(clear_balance < totalAmount && !sender.getoverdraftflag())) {
	           Date d1 = new Date();
	           message mc = messagerepository.findById((request.getMessagecode())).get();
	           transfertypes tt = transfertypesrepository.findById((request.getTransfercode())).get();
	           bank b = bankrepository.findById((request.getReciever_bic())).get();
	           
	           transaction t1 = ToStoreTransaction(sender,curr,transferFee,in_inr,d1,totalAmount,mc,tt,b);
	           
	           double cl_bal = Double.parseDouble(sender.getClearbalance())- Math.abs(totalAmount);
	           String cal_balance = Double.toString(cl_bal);
	           sender.setClearbalance(cal_balance);
	           
	           double cl_rec_bal = Double.parseDouble(sender.getClearbalance())+ Math.abs(totalAmount);
	           String cal_rec_balance = Double.toString(cl_rec_bal);
	           sender.setClearbalance(cal_rec_balance);

	           customerrepository.save(sender);
	            
	           return "Transaction Successfull!!!!";
	    }
		
		else
			return "Transaction  not Successfull";
		
	         
		
	}
     
}
