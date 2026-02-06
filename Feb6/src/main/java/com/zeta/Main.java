package com.zeta;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter initial balance :");
        int initialbalance=sc.nextInt();
        while(initialbalance<0){
            System.out.println("enter valid balance");
            initialbalance=sc.nextInt();
        }
        BankAccount account=new BankAccount(initialbalance);
        ExecutorService executor=Executors.newFixedThreadPool(3);
        while(true){
            System.out.println("\nMULTITHREADED BANKING SYSTEM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Simulate Parallel Withdrawals");
            System.out.println("5. Get loan");
            System.out.println("6  Exit");
            System.out.print("Enter your choice: ");

            int choice=sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Current balance :" + account.getBalance());
                        break;

                    case 2:
                        System.out.println("Enter amount to deposit");
                        int amount = sc.nextInt();
                        executor.execute(new DepositTask(account, amount));
                        break;

                    case 3:
                        System.out.println("Enter amount to withdraw:");
                        int wamount = sc.nextInt();
                        executor.execute(new Withdrawtask(account, wamount));
                        break;

                    case 4:
                        System.out.println("Simulating two parallel withdrawals of ₹" + (initialbalance / 2));

                        executor.execute(new Withdrawtask(account, initialbalance / 2));
                        executor.execute(new Withdrawtask(account, initialbalance / 2));
                        break;

                    case 5:
                        if (account.hasLoan()) {
                            System.out.println("Loan already exists");
                            break;
                        }
                        System.out.println("Enter loan amount:");
                        int loanAmount = sc.nextInt();
                        System.out.println("Enter interest rate:");
                        float interest = sc.nextFloat();
                        System.out.println("Enter tenure :");
                        int tenure = sc.nextInt();
                        account.availLoan(loanAmount, interest, tenure);
                        break;
                    case 6:
                        System.out.println("Shutting down");
                        executor.shutdown();
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }catch(IllegalArgumentException e){

            }
        }

    }
}
