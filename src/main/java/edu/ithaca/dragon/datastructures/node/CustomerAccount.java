package edu.ithaca.dragon.datastructures.node;

import java.util.HashMap;

public class CustomerAccount {
    private Customer customer;
    private HashMap< Integer, Customer> AllCustomerAccounts;

    public CustomerAccount(Customer customer){
        this.customer = customer;
        this.AllCustomerAccounts = new HashMap<>();

    }
    
    /**
     * creates an account for the customer and addds it to the collection of all accounts within the system
     * @param customerID
     * @param customer
     */
    public void createAccount(int customerID, Customer customer){
        AllCustomerAccounts.put(customerID, customer);
    }

    /**
     * gets a specific customer given their customer ID
     * @param customerID
     * @param customer
     * @return
     */
    public Customer getCustomer(int customerID, Customer customer) {
        if(AllCustomerAccounts.get(customerID) == customer){
            return customer;
        }
        else{
            return null;
        }
    }   

    /**
     * deletes an account by setting it to null
     * @param customer
     * @return
     */
    public Customer deleteAccount(Customer customer){
        this.customer = null;
        return null;
    }

   
    
}


