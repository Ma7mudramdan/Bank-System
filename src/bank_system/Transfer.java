package bank_system;

import java.util.Scanner;

public class Transfer {

    private Account From;
    private Account To;
    private Bank bank;

    Scanner input = new Scanner(System.in);

    public Transfer(Bank bank) {
        this.bank = bank;

        System.out.println("Enter your Account Number");
        int num = input.nextInt();

        if (search(num) != null) {

            System.out.println("Enter your password");
            int pass = input.nextInt();
            int i = 3;
            while (pass != search(num).getPassword()) {
                System.out.println("Please enter the correct password, You hava " + i + " attempts");
                pass = input.nextInt();

                if (i==1)
                    {
                        System.out.println("You have exhausted your attempts. Try again later.");
                        return;
                    }
                    i--;
            }
            System.out.println("Enter account number you want to send money to ");
            int to = input.nextInt();
            System.out.println("Enter the amount do you want send ");
            double amount = input.nextDouble();
            this.Transfer(search(num), search(to), amount);
            bank.saveAccounts();

        } 
        else {
            System.out.println("Please, Re_enter the data correctly\n------------------------------------------------");
            new Transfer(bank);
        }
    }

    public Account search(int AccountNumber) {

        for (Account A : bank.accounts) {
            if (AccountNumber == A.getAccountnumber()) {
                return A;
            }
        }
        System.out.println("------------------------------------------------\nThe Account that has number <" + AccountNumber + "> does not exist!!");
        return null;
    }

    public Transfer(Account From, Account To) {
        this.From = From;
        this.To = To;
    }

    public void Transfer(Account from, Account to, double amount) {
        if (amount > from.balance) {
            System.out.println("The amount do you want to send is bigger than your balance, your balance = " + from.getBalance() + "\n------------------------------------------------");
            new Transfer(bank);
            return;
        }
        from.balance -= amount;
        to.balance += amount;
        System.out.println("<Successful Money Transfer>");
    }

}
