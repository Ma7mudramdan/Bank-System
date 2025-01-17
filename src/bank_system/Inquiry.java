/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_system;

import java.util.Scanner;

public class Inquiry {

    Bank bank;
    Account account;

    Scanner input = new Scanner(System.in);

    public Inquiry() {
    }

    public Inquiry(Account account) {
        this.account = account;
        System.out.println("------------------------------------------------\n" + account.toString());
    }

    public Inquiry(Bank bank) {
        this.bank = bank;
        System.out.println("Enter Account Number");
        int num = input.nextInt();
        boolean flag = true;
        for (Account A : bank.accounts) {
            if (A.getAccountnumber() == num) {
                flag = false;
                System.out.println("Enter Account password");
                int pass = input.nextInt();
                int i = 3;
                while (A.getPassword() != pass) {
                    System.out.println("Please, Enter the correct password you hava " + i + " attempts");
                    pass = input.nextInt();
                    if (i == 1) {
                        System.out.println("You have exhausted your attempts. Try again later.");
                        return;
                    }
                    i--;
                }

                new Inquiry(A);

            }

        }
        if (flag) {
            System.out.println("Account doesn't exist, please Enter data correctly");
            new Inquiry(bank);
        }

    }

    public double getBalance() {
        return account.getBalance();
    }
}
