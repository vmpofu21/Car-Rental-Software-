package edu.ithaca.dragon.datastructures.node;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class CustomerAccountTest {

    @Test
    void createAccountTest(){
        Customer customer1 = new Customer("Vanessa", "veempofu@gmail.com", "password2");
        Customer customer2 = new Customer("Vascoh", "vbmpofu@gmail.com", "mando2");
        CustomerAccount account = new CustomerAccount(customer1);
        account.createAccount(210701, customer1);
        //equivalence case - returns the correct customer object when given a customerID
        assertEquals(customer1, account.getCustomer(210701, customer1));
        //boundary and equivalence case - because it checks if the customerID corresponds the correct customer object
        assertNull(account.getCustomer(210701, customer2));
    }
    

    @Test
    void deleteAccountTest(){
        Customer customer1 = new Customer("Vanessa", "veempofu@gmail.com", "password2");
        CustomerAccount account = new CustomerAccount(customer1);
        assertNull(account.deleteAccount(customer1));
    }

    
   
}
