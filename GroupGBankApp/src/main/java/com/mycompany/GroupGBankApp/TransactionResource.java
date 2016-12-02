/*
 * Copyright 2016 Niall Quinn.
 */
package com.mycompany.GroupGBankApp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.mycompany.GroupGBankApp.Transaction.TransactionType;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Niall Quinn
 */
@Path("/transaction")
public class TransactionResource {
    
    Gson gson = new Gson();
    
    TransactionService transactionService = new TransactionService();
    
    public TransactionResource(){
        
    }
    
    @POST
    @Path("/lodgement")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createCust(String t) {
        System.out.println(t);
        GsonBuilder builder = new GsonBuilder();
        Transaction o = builder.create().fromJson(t, Transaction.class); 
//        int accountId = o.get("accountId").getAsInt();
//        String cardNumber = o.get("cardNumber").getAsString();
//        int cvv = o.get("cardCVV").getAsInt();
//        String expiry = o.get("cardExpiryDate").getAsString();
//        Double amount = o.get("amount").getAsDouble();
        
        Transaction transaction = new Transaction(TransactionType.LODGEMENT, o.getAccountId(), o.getCardNumber(), o.getCardCVV(), o.getCardExpiry(), o.getAmount());
        System.out.println(transaction.toString());
        Transaction c = new TransactionService().createTransaction(transaction);
        transactionService.processTransaction(c.getId());
        return Response
                .status(200)
                .entity(transaction).build();
        
    }
}
