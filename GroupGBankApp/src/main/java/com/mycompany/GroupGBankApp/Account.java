/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Eoin
 */
@Entity
@Table
@XmlRootElement
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String sortCode;
    private int accountNum;
    private Double currentBalance;
    private String accountType;
    private int customerId;
    
    public Account(){
        
    }
    
    public Account ( String sortCode, int accountNum, Double currentBalance, String accountType, int customerId){
        this.sortCode = sortCode;
        this.accountNum = accountNum;
        this.currentBalance = currentBalance;
        this.accountType = accountType;
        this.customerId = customerId;
    
    }
    
    public Account(Double currentBalance){
        this.currentBalance = currentBalance;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getId() {
        return id;
    }

    public String getSortCode() {
        return sortCode;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }
        
}
