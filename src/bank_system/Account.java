package bank_system;

import java.io.Serializable;

public class Account implements Serializable {
   private static final long serialVersionUID = 1L; // Version control for the serialization
    private long accountnumber;
    private String accountType;
    protected double balance;
    protected int password;
    private String name;

    public Account() {
    }

    public Account(String name,long accountnumber,double balance ,String accountType, int password ) {
        this.accountnumber = accountnumber;
        this.accountType = accountType;
        this.balance = balance;
        this.name = name;
        this.password = password;
    }
    

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    
    

    public String getName() {
        return name;
    }
    
    

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void tranaction(int amount , String type){
        if (type == "withdraw")
         balance -= amount;
        
        if (type == "deposit")
         balance += amount;
    }

    @Override
    public String toString() {
    
            return "Account Name: " + name + "\nAccount Type: " +accountType+ "\nAccount Number: "+ accountnumber + "\nBalance: "+balance + "\nPassword: "+password;
       
    }
   
    
    

}
