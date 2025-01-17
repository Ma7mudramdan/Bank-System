/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_system;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Bank {

    protected List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
        loadAccounts();
    }


    public void createAccount(Account account) {
        accounts.add(account);
        saveAccounts();
    }

    public void deposit(long accountNumber, double amount) {
        for (Account account : accounts) {
            if (account.getAccountnumber() == accountNumber) {
                new Transaction(amount, account, "depsit");
                System.out.println("Deposit successful.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void withdraw(int accountNumber, double amount) {
        for (Account account : accounts) {
            if (account.getAccountnumber() == accountNumber) {
                new Transaction(amount, account, "withdraw");
                System.out.println("Withdrawal successful.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void displayAccounts() {
        for (Account account : accounts) {
            System.out.println(account.toString());   
            System.out.println("------------------------------------------------");
        }
    }

    public Account getAccounts(int index) {
        return accounts.get(index);
    }
    
    public int getsize(){
            return accounts.size();
    }
    
     public void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accounts.dat"))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

     public void loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("accounts.dat"))) {
            accounts = (List<Account>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No saved accounts found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }

    
    

}
