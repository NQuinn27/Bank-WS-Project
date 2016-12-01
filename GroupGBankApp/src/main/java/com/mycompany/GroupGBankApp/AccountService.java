/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Eoin
 */
public class AccountService {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Customer");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();  
    
    public Account addCurrentAccount(Account a){
         Account test = em.find(Account.class, a.getId());
        if (test == null) {
            tx.begin();
            em.persist(a);
            tx.commit();
            
            em.close();
        }
        return a;
    }
    
    public Account addSavingsAccount(Account a){
         Account test = em.find(Account.class, a.getId());
        if (test == null) {
            tx.begin();
            em.persist(a);
            tx.commit();
            
            em.close();
        }
        return a;
    }
    
    public List<Account> retrieveAccounts() {
        return allEntries();
    }
    
    public List<Account> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
        Root<Account> rootEntry = cq.from(Account.class);
        CriteriaQuery<Account> all = cq.select(rootEntry);
        TypedQuery<Account> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
      public Account retrieveAccount(int id) {
        Account test = em.find(Account.class, id);
        em.close();
        return test;
    }      
    
}
