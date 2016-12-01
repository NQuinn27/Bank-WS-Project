/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.GroupGBankApp;

import com.google.gson.Gson;
import java.util.List;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Eoin
 */
@Path("/account")
public class AccountResource {
    
    Gson gson;
    
    AccountService acc = new AccountService();
    
    public AccountResource(){
        gson = new Gson();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> listCustomer() {
        return acc.retrieveAccounts();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/user/{id}")
    public Account getCustomer(@PathParam("id") int id) {
        return acc.retrieveAccount(id);
    }
    
    @POST
    @Path("/createCurrentAccount")
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Account createCurrAccount(String input) {
        System.out.println(input);
        //Account jobj = new Gson().fromJson(a, Account.class);
        String sortCode = "IEBICXX";
        Random rand = new Random();
        int accNum = rand.nextInt(10);
        Double currBal = 0.0;
        String accType = "Current";
        int custId = Integer.parseInt(input);
        Account account = new Account(sortCode,accNum,currBal,accType, custId);
        
        return acc.addCurrentAccount(account);
    }
    
    @POST
    @Path("/createSavingsAccount")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Account createSavingsAccount(String input) {
        System.out.println(input);
        //Account jobj = new Gson().fromJson(a, Account.class);
        String sortCode = "IEBICXX";
        Random rand = new Random();
        int accNum = rand.nextInt(10);
        Double currBal = 0.0;
        String accType = "Savings";
        int custId = Integer.parseInt(input);
        Account account = new Account(sortCode,accNum,currBal,accType, custId);
        
        return acc.addCurrentAccount(account);
    }
    
}
