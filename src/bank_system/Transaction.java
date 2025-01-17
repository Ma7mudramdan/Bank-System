package bank_system;

import java.util.List;

import java.util.Scanner;

public class Transaction {

    private double amount;
    private Account account;
    private String type;
    private Bank bank;

    Scanner input = new Scanner(System.in);

    public Transaction(Bank bank) {
        this.bank = bank;
        System.out.println("Enter Account Number");
        long num = input.nextInt();
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
                System.out.println("To withdraw Enter 1 and To deposit Enter 2");
                if (input.nextInt() == 1) {
                    System.out.println("Enter The Amount");
                    double money = input.nextDouble();
                    if (A.balance > 0 && A.balance >= money) {
                        A.balance -= money;
                        bank.saveAccounts();
                        System.out.println("=====================\n|Successful Withdraw|\n=====================");

                    } else {
                        System.out.println("------------------------------------------------\n"
                                + "Your balance is smallar than the amount do you want to withdraw");
                        System.out.println("Your balance = " + A.getBalance() + "\n------------------------------------------------");
                        return;
                    }

                    System.out.println("Do you want to inquire about you account after withdraw?\n1.YES\n2.NO");
                    if (input.nextInt() == 1) {
                        new Inquiry(A);
                    } else {
                        return;
                    }

                } else {
                    System.out.println("Enter The Amount");
                    A.balance += input.nextDouble();
                    System.out.println("====================\n<Successful Deposit>\n====================");
                    bank.saveAccounts();

                    System.out.println("Do you want to inquire about you account after deposit?\n1.YES\n2.NO");
                    if (input.nextInt() == 1) {
                        new Inquiry(A);
                    } else {
                        return;
                    }
                }

            }
            //throw new IllegalArgumentException("Account isn't exist");
        }
        if (flag) {
            System.out.println("Account doesn't exist");
        }

    }

    public Transaction(double amount, Account account, String type) {
        this.amount = amount;
        this.account = account;
        this.type = type;
        if (type == "withdraw") {
            account.balance -= amount;
        } else if (type == "deposit") {
            account.balance += amount;
        }
    }

    public void withdraw(int amount) {
        account.balance -= amount;
    }

    public void deposit(int amount) {
        account.balance += amount;
    }

}
