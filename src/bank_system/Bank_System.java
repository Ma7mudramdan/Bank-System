
package bank_system;

import java.util.Scanner;

public class Bank_System {

    public static void main(String[] args) {
               
        Bank w = new Bank(); 
        w.displayAccounts(); // accounts ware stored,you can use it to tranform , withdraw ,deposit or inquire
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the process you want");
        System.out.println("1.Create Account \t2.Transaction \n3.Transfer \t4.Inquiry\n------------------------------------------------");
        Account account;
        int in = input.nextInt();
        if (in == 1)
        {
            Scanner input2=  new Scanner(System.in);
            String name;
            System.out.println("Enter Account Name");
            name = input2.nextLine();
            
            System.out.println("Enter Account Number");
            int AccountNumber = input.nextInt();
            
            System.out.println("Enter Account Type");
            String accountType = input2.nextLine();
            
            System.out.println("Enter Account Balance");
            double Balance = input.nextDouble();
            
            System.out.println("Enter Account Password");
            int  password = input.nextInt();
            account = new Account(name,AccountNumber,Balance,accountType,password);
            w.createAccount(account);
            System.out.println("Account created successfuly");
            
        }
        else if (in == 2)
        {
             new Transaction(w); 
        }
        else if (in == 4)
        {
            new Inquiry(w);
        }
        else if (in == 3)
        {
            try{
                
            new Transfer(w);
            }
            catch(NullPointerException e){
               
                System.out.println("<<Please, Re_enter the data correctly>>\n------------------------------------------------");
                 new Transfer(w);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                new Transfer(w);
            }
           
        }

    }
    
}
