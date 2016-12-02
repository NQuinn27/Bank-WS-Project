/*
 * Copyright 2016 Niall Quinn.
 */
package com.mycompany.GroupGBankApp;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niall Quinn
 */

@Entity
@Table
@XmlRootElement
public class Transaction implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    public enum TransactionType {
        LODGEMENT, WITHDRAWAL 
    }

    private TransactionType type;
    private int accountId;
    private String cardNumber;
    private int cardCVV;
    private String cardExpiry;
    private boolean processed;
    private Double amount;
    
    public Transaction () {}

    public Transaction(TransactionType type, int accountId, String cardNumber, int cardCVV, String cardExpiry, Double amount) {
        this.type = type;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.cardCVV = cardCVV;
        this.cardExpiry = cardExpiry;
        this.processed = false;
        this.amount = amount;
    }
    
    public int getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(int cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }
    
    public boolean isProcessed() {
        return processed;
    }
    
    public void setIsProcessed(boolean p) {
        this.processed = p;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
    
}
