package com.dbs.pay.model;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class transaction {
	@GeneratedValue
    @Id
    private Long transactionid;
    private Double currencyamount;
    private Double transferfees;
    private Double inramount;
    private Date transferdate;

    @ManyToOne()
    @JoinColumn()
    private customer Customer;
    @ManyToOne()
    @JoinColumn()
	private currency curr;
	@ManyToOne()
    @JoinColumn()
	private bank receiverbank;
    @ManyToOne()
    @JoinColumn()
    private transfertypes transfertype;
    @ManyToOne()
    @JoinColumn()
    private message mesagecode;

    public Long getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Long transactionid) {
        this.transactionid = transactionid;
    }

    public Double getCurrencyamount() {
        return currencyamount;
    }

    public void setCurrencyamount(Double currencyamount) {
        this.currencyamount = currencyamount;
    }

    public Double getTransferfees() {
        return transferfees;
    }

    public void setTransferfees(Double transferfees) {
        this.transferfees = transferfees;
    }

    public Double getInramount() {
        return inramount;
    }

    public void setInramount(Double inramount) {
        this.inramount = inramount;
    }

    public Date getTransferdate() {
        return transferdate;
    }

    public void setTransferdate(Date transferdate) {
        this.transferdate = transferdate;
    }

    public customer getCustomer() {
        return Customer;
    }

    public void setCustomer(customer customer) {
        Customer = customer;
    }

    public currency getCurr() {
        return curr;
    }

    public void setCurr(currency curr) {
        this.curr = curr;
    }

    public bank getReceiverbank() {
        return receiverbank;
    }

    public void setReceiverbank(bank receiverbank) {
        this.receiverbank = receiverbank;
    }

    public transfertypes getTransfertype() {
        return transfertype;
    }

    public void setTransfertype(transfertypes transfertype) {
        this.transfertype = transfertype;
    }

    public message getMesagecode() {
        return mesagecode;
    }

    public void setMesagecode(message mesagecode) {
        this.mesagecode = mesagecode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        transaction that = (transaction) o;
        return transactionid.equals(that.transactionid) && currencyamount.equals(that.currencyamount) && transferfees.equals(that.transferfees) && inramount.equals(that.inramount) && transferdate.equals(that.transferdate) && Customer.equals(that.Customer) && curr.equals(that.curr) && receiverbank.equals(that.receiverbank) && transfertype.equals(that.transfertype) && mesagecode.equals(that.mesagecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionid, currencyamount, transferfees, inramount, transferdate, Customer, curr, receiverbank, transfertype, mesagecode);
    }

    @Override
    public String toString() {
        return "transaction{" +
                "transactionid=" + transactionid +
                ", currencyamount=" + currencyamount +
                ", transferfees=" + transferfees +
                ", inramount=" + inramount +
                ", transferdate=" + transferdate +
                ", Customer=" + Customer +
                ", curr=" + curr +
                ", receiverbank=" + receiverbank +
                ", transfertype=" + transfertype +
                ", mesagecode=" + mesagecode +
                '}';
    }
}
