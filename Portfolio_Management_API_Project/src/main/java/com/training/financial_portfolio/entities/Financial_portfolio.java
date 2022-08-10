package com.training.financial_portfolio.entities;

import javax.persistence.*;

@Entity(name="portfolio")
public class Financial_portfolio {

    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long ID;
    @Column(name="UserName")
    private String userName;
    @Column(name="BankAccount")
    private String bankAccount;
    @Column(name="Portfolio")
    private String portfolio;

//    public Financial_portfolio(long id, String user_name, String bank_account, String portfolio){
//
//        this.id = id;
//        this.user_name = user_name;
//        this.bank_account = bank_account;
//        this.portfolio = portfolio;
//    }

    // setter and getter


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    // toString

    @Override
    public String toString() {
        return "Financial_portfolio{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", portfolio='" + portfolio + '\'' +
                '}';
    }
}
