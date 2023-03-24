package edu.ithaca.dragon.datastructures.node;


public class Customer {

    private String name;
    private String email;
    private String password;


    public Customer(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;

    }

    /**
     * updates customer's paasword when they want to change it
     * @param password
     */
    public void updatePassword(String newPassword){
       this.password = newPassword;
    }

    public String getName(){
        return name;
    }
   
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }


}
