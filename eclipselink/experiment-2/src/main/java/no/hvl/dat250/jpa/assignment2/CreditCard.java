package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int balance;
    private int limit;

    @OneToOne(cascade = {CascadeType.PERSIST})
    public Pincode pincode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank")
    private Bank bank;


    public CreditCard() {}

    public int getNumber() {
        return number;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getBalance() {
        return balance;
    }

    public int getLimit() {
        return limit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Bank getOwningBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
