package com.zeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;





public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        
        List<BankAccount> accounts=new ArrayList<>();


        ExecutorService executor= Executors.newFixedThreadPool(3);


        while(true){
            System.out.println("\n------MULTITHREADED BANKING SYSTEM------");
            System.out.println("1. Create Bank account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Simulate Parallel Withdrawals");
            System.out.println("6. Get loan");
            System.out.println("7. Check loan status");
            System.out.println("8. Show Accounts");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number 1–6.");
                sc.nextLine();
                continue;
            }
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter account ID:");
                        int accountID=sc.nextInt();
                        System.out.println("Enter initial balance :");
                        int initialbalance=sc.nextInt();
                        while(initialbalance<0){
                            System.out.println("enter valid balance");
                            initialbalance=sc.nextInt();
                        }
                        BankAccount account=new BankAccount(initialbalance,accountID);
                        accounts.add(account);
                        break;

                    case 2:
                        System.out.println("Enter account ID");
                        int id=sc.nextInt();
                        BankAccount acc=findAccount(accounts,id);
                        if(acc==null){
                            System.out.println("Account not found");
                        }
                        System.out.println("Balance: "+acc.getBalance());
                        break;

                    case 3:
                        System.out.println("Enter account ID");
                        int id3=sc.nextInt();
                        BankAccount acc3=findAccount(accounts,id3);
                        if(acc3==null){
                            System.out.println("Account not found");
                        }
                        System.out.println("Enter amount to deposit");
                        int amount = sc.nextInt();
                        executor.execute(new DepositTask(acc3, amount));
//                        executor.execute(()->account.deposit(amount));
                        break;

                    case 4:
                        System.out.println("Enter account ID");
                        int id4=sc.nextInt();
                        BankAccount acc4=findAccount(accounts,id4);
                        if(acc4==null){
                            System.out.println("Account not found");
                        }
                        System.out.println("Enter amount to withdraw:");
                        int wamount = sc.nextInt();
                        executor.execute(new Withdrawtask(acc4, wamount));
//                        executor.execute(()->account.withdraw(wamount));
                        break;

                    case 5:
                        System.out.println("Enter account ID");
                        int id5=sc.nextInt();
                        BankAccount acc5=findAccount(accounts,id5);
                        if(acc5==null){
                            System.out.println("Account not found");
                        }
                        System.out.println("Simulating two parallel withdrawals of ₹" + (acc5.getBalance() / 2));

                        executor.execute(new Withdrawtask(accounts.get(0), acc5.getBalance() / 2));
                        executor.execute(new Withdrawtask(accounts.get(0), acc5.getBalance()/ 2));
//                        executor.execute(()->account.withdraw(finalInitialbalance /2));
//                        executor.execute(()->account.withdraw(finalInitialbalance1 /2));
                        break;

                    case 6:
                        System.out.println("Enter account ID");
                        int id6=sc.nextInt();
                        BankAccount acc6=findAccount(accounts,id6);
                        if(acc6==null){
                            System.out.println("Account not found");
                        }
                        if (acc6.hasLoan()) {
                            System.out.println("Loan already exists");
                            break;
                        }

                        System.out.println("Enter loan amount:");
                        int loanAmount = sc.nextInt();

                        System.out.println("Enter tenure in months :");
                        int tenure = sc.nextInt();
                        acc6.availLoan(loanAmount,  tenure);
                        break;

                    case 7:
                        System.out.println("Enter account ID");
                        int id7=sc.nextInt();
                        BankAccount acc7=findAccount(accounts,id7);
                        if(acc7==null){
                            System.out.println("Account not found");
                        }
                        System.out.println("checking loan status");
                        acc7.checkLoanStatus();
                        break;


                    case 8:
                        System.out.println("The Bank accounts are:");
                        for (BankAccount a:accounts){
                            System.out.println(a.getAccountId());
                        }
                        break;


                    case 9:
                        System.out.println("Shutting down");
                        executor.shutdown();
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }catch(IllegalArgumentException illegalArgumentException){
                System.out.println(illegalArgumentException.getMessage());

            }
        }

    }
    private static BankAccount findAccount(List<BankAccount> accounts, int id) {

        for (BankAccount a : accounts) {
            if (a.getAccountId() == id) {
                return a;
            }
        }
        return null;
    }

}
