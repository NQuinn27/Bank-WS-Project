/*
 * Copyright 2016 Niall Quinn.
 */
package com.mycompany.GroupGBankApp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Niall Quinn
 */
public class TransactionService {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transaction");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    public List<Transaction> retrieveTransactions() {
        return allEntries();
    }
    
    public List<Transaction> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
        Root<Transaction> rootEntry = cq.from(Transaction.class);
        CriteriaQuery<Transaction> all = cq.select(rootEntry);
        TypedQuery<Transaction> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public Transaction retrieveTransaction(int id) {
        Transaction test = em.find(Transaction.class, id);
        em.close();
        return test;
    } 
    
    public Transaction createTransaction(Transaction t){
        Transaction transaction = em.find(Transaction.class, t.getId());
        if (transaction == null) {
            tx.begin();
            em.persist(t);
            tx.commit();
            em.close();
        }
        return t;
    }
    
    public boolean processTransaction(int id) {
        Transaction t = em.find(Transaction.class, id);
        if (t == null) return false;
        if (t.isProcessed() == true) {
            return false;
        }
        AccountService as = new AccountService();
        switch (t.getType()) {
            case LODGEMENT:
                as.addBalance(t.getAmount(), t.getAccountId());
                break;
            case WITHDRAWAL:
                as.deductBalance(t.getAmount(), t.getAccountId());
                break;
        }
        t.setIsProcessed(true);
        tx.begin();
        em.persist(t);
        tx.commit();
        em.close();
        return true;
    }
      
}
