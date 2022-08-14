package com.dbs.pay.model;

import java.util.Objects;

public class TransactionRequested {
	
	private  String sender_customerid;
    private  String sender_accountholder_name;
    private  String cur;
    private  String reciever_bic;
    private  String reciever_institution_name;
    private  String reciever_accountholder_name;
    private  String reciever_accountholder_number;
    private  String messagecode;
    private  double amount;
    private String transfercode;
    
    public String getTransfercode() {
        return transfercode;
    }
    
   public void setTransfercode(String transfercode) {
        this.transfercode = transfercode;
    }
    
	public String getSender_customerid() {
		return sender_customerid;
	}
	
	public void setSender_customerid(String sender_customerid) {
		this.sender_customerid = sender_customerid;
	}
	
	public String getSender_accountholder_name() {
		return sender_accountholder_name;
	}
	
	public void setSender_accountholder_name(String sender_accountholder_name) {
		this.sender_accountholder_name = sender_accountholder_name;
	}
	
	public String getCur() {
		return cur;
	}
	
	public void setCur(String cur) {
		this.cur = cur;
	}
	
	public String getReciever_bic() {
		return reciever_bic;
	}
	
	public void setReciever_bic(String reciever_bic) {
		this.reciever_bic = reciever_bic;
	}
	
	public String getReciever_institution_name() {
		return reciever_institution_name;
	}
	
	public void setReciever_institution_name(String reciever_institution_name) {
		this.reciever_institution_name = reciever_institution_name;
	}
	
	public String getReciever_accountholder_name() {
		return reciever_accountholder_name;
	}
	
	public void setReciever_accountholder_name(String reciever_accountholder_name) {
		this.reciever_accountholder_name = reciever_accountholder_name;
	}
	
	public String getReciever_accountholder_number() {
		return reciever_accountholder_number;
	}
	
	public void setReciever_accountholder_number(String reciever_accountholder_number) {
		this.reciever_accountholder_number = reciever_accountholder_number;
	}
	
	public String getMessagecode() {
		return messagecode;
	}
	
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount, cur, messagecode, reciever_accountholder_name, reciever_accountholder_number,
				reciever_bic, reciever_institution_name, sender_accountholder_name, sender_customerid);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionRequested other = (TransactionRequested) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(cur, other.cur) && Objects.equals(messagecode, other.messagecode)
				&& Objects.equals(reciever_accountholder_name, other.reciever_accountholder_name)
				&& Objects.equals(reciever_accountholder_number, other.reciever_accountholder_number)
				&& Objects.equals(reciever_bic, other.reciever_bic)
				&& Objects.equals(reciever_institution_name, other.reciever_institution_name)
				&& Objects.equals(sender_accountholder_name, other.sender_accountholder_name)
				&& Objects.equals(sender_customerid, other.sender_customerid);
	}
	
	@Override
	public String toString() 
	{
		return "TransactionRequested [sender_customerid=" + sender_customerid + ", sender_accountholder_name="
				+ sender_accountholder_name + ", cur=" + cur + ", reciever_bic=" + reciever_bic
				+ ", reciever_institution_name=" + reciever_institution_name + ", reciever_accountholder_name="
				+ reciever_accountholder_name + ", reciever_accountholder_number=" + reciever_accountholder_number
				+ ", messagecode=" + messagecode + ", amount=" + amount + "]";
	}
    
}
