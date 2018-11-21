package section1_2;

/*
Using our implementation of Date as a model (page 91), develop an implementation
of Transaction.

A transaction is a customer, a date, and an amount.
 */
import edu.princeton.cs.algs4.Date;

public class Transaction {
    private String who;
    private Date date;
    private Double amount;

    public Transaction(String who, Date date, Double amount) {
        this.who = who;
        this.date = date;
        this.amount = amount;
    }

    public String getWho() {
        return who;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }
}
