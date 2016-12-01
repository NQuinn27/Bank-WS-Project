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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eoin
 */
public class CustomerService {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Customer");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();  
    
     public List<Customer> retrieveCustomers() {
        return allEntries();
    }
    
    public List<Customer> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        CriteriaQuery<Customer> all = cq.select(rootEntry);
        TypedQuery<Customer> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
      public Customer retrieveCustomer(int id) {
        Customer test = em.find(Customer.class, id);
        em.close();
        return test;
    }      
    
    
    public Customer createCustomer(Customer c){
        Customer test = em.find(Customer.class, c.getId());
        if (test == null) {
            tx.begin();
            em.persist(c);
            tx.commit();
            
            em.close();
        }
        return c;
    }
    
}
