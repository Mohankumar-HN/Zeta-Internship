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




        ExecutorService executor= Executors.newFixedThreadPool(3);
        BankAccount account=new BankAccount(initialbalance);
        while(true){
            System.out.println("\nMULTITHREADED BANKING SYSTEM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Simulate Parallel Withdrawals");
            System.out.println("5. Get loan");
            System.out.println("6. Check loan status");
            System.out.println("7. Calculate EMI");
            System.out.println("8. Exit");
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
                        System.out.println("Current balance :" + account.getBalance());
                        break;

                    case 2:
                        System.out.println("Enter amount to deposit");
                        int amount = sc.nextInt();
                        executor.execute(new DepositTask(account, amount));
//                        executor.execute(()->account.deposit(amount));
                        break;

                    case 3:
                        System.out.println("Enter amount to withdraw:");
                        int wamount = sc.nextInt();
                        executor.execute(new Withdrawtask(account, wamount));
//                        executor.execute(()->account.withdraw(wamount));
                        break;

                    case 4:
                        System.out.println("Simulating two parallel withdrawals of ₹" + (account.getBalance() / 2));

                        executor.execute(new Withdrawtask(account, account.getBalance() / 2));
                        executor.execute(new Withdrawtask(account, account.getBalance()/ 2));
//                        executor.execute(()->account.withdraw(finalInitialbalance /2));
//                        executor.execute(()->account.withdraw(finalInitialbalance1 /2));

                        break;

                    case 5:
                        if (account.hasLoan()) {
                            System.out.println("Loan already exists");
                            break;
                        }

                        System.out.println("Enter loan amount:");
                        int loanAmount = sc.nextInt();

                        System.out.println("Enter tenure in months :");
                        int tenure = sc.nextInt();
                        account.availLoan(loanAmount,  tenure);
                        break;

                    case 6:
                        System.out.println("checking loan status");
                        account.checkLoanStatus();
                        break;

                    case 7:
                        System.out.println("Enter loan amount:");
                        int emiAmount = sc.nextInt();

                        System.out.println("Enter tenure in months :");
                        int emiTenure = sc.nextInt();
                        float emi= (float) account.calculateMonthlyEMI(emiTenure,emiAmount);
                        System.out.println("EMI per month: "+emi);
                        break;

                    case 8:
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
}
