package com.zeta;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.zeta.transcation.Transcation;


public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);


        Map<Integer, BankAccount> accounts = new HashMap<>();
        Map<Integer,List<Transcation>> transcationMap=new HashMap<>();

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
            System.out.println("9. Show Transcations");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
                continue;
            }
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter account ID:");
                        int accountID=scanner.nextInt();
                        System.out.println("Enter initial balance :");
                        int initialbalance=scanner.nextInt();
                        while(initialbalance<0){
                            System.out.println("enter valid balance");
                            initialbalance=scanner.nextInt();
                        }
                        BankAccount account=new BankAccount(initialbalance,accountID);
                        accounts.put(accountID, account);
                        transcationMap.put(accountID,Collections.synchronizedList(new ArrayList<>()));
                        break;

                    case 2:
                        System.out.println("Enter account ID");
                        int id=scanner.nextInt();
                        BankAccount acc = accounts.get(id);
                        if(acc==null){
                            System.out.println("Account not found\n Create your account now in our Bank");
                            break;
                        }
                        System.out.println("Balance: "+acc.getBalance());
                        break;

                    case 3:
                        System.out.println("Enter account ID");
                        int id3=scanner.nextInt();
                        BankAccount acc3 = accounts.get(id3);
                        if(acc3==null){
                            System.out.println("Account not found\n Create your account now in our Bank");
                            break;
                        }
                        System.out.println("Enter amount to deposit");
                        int amount = scanner.nextInt();
                        executor.execute(()->{
                            try {
                                acc3.deposit(amount);
                                transcationMap.get(id3).add(new Transcation(id3, "CREDIT", amount));
                            }catch(Exception exception){
                                System.out.println(exception.getMessage());
                            }
                        });
                        break;

                    case 4:
                        System.out.println("Enter account ID");
                        int id4=scanner.nextInt();
                        BankAccount acc4 = accounts.get(id4);
                        if(acc4==null){
                            System.out.println("Account not found\n Create your account now in our Bank");
                            break;
                        }
                        System.out.println("Enter amount to withdraw:");
                        int wamount = scanner.nextInt();
                        executor.execute(()->{
                            try {
                                acc4.withdraw(wamount);
                                transcationMap.get(id4).add(new Transcation(id4, "DEBIT", wamount));
                            }catch(Exception exception){
                                System.out.println(exception.getMessage());
                            }
                        });
                        break;

                    case 5:
                        System.out.println("Enter account ID");
                        int id5=scanner.nextInt();
                        BankAccount acc5 = accounts.get(id5);
                        if(acc5==null){
                            System.out.println("Account not found\n Create your account now in our Bank");
                            break;
                        }
                        System.out.println("Simulating two parallel withdrawals of ₹" + (acc5.getBalance() / 2));

                        executor.execute(new Withdrawtask(accounts.get(id5), acc5.getBalance() / 2));
                        executor.execute(new Withdrawtask(accounts.get(id5), acc5.getBalance()/ 2));
//                        executor.execute(()->account.withdraw(finalInitialbalance /2));
//                        executor.execute(()->account.withdraw(finalInitialbalance1 /2));
                        break;

                    case 6:
                        System.out.println("Enter account ID");
                        int id6=scanner.nextInt();
                        BankAccount acc6 = accounts.get(id6);
                        if(acc6==null){
                            System.out.println("Account not found\n Create your account now in our Bank");
                            break;
                        }
                        if (acc6.hasLoan()) {
                            System.out.println("Loan already exists");
                            break;
                        }

                        System.out.println("Enter loan amount:");
                        int loanAmount = scanner.nextInt();

                        System.out.println("Enter tenure in months :");
                        int tenure = scanner.nextInt();
                        acc6.availLoan(loanAmount,  tenure);
                        break;

                    case 7:
                        System.out.println("Enter account ID");
                        int id7=scanner.nextInt();
                        BankAccount acc7 = accounts.get(id7);
                        if(acc7==null){
                            System.out.println("Account not found\n Create your account now in our Bank");
                            break;
                        }
                        System.out.println("checking loan status");
                        acc7.checkLoanStatus();
                        break;


                    case 8:
                        System.out.println("The Bank accounts are:");
                        accounts.forEach((key, value) -> System.out.println("Account ID :" + key + "  Balance: " + value.getBalance()));
                        break;


                    case 9:
                        System.out.println("Enter account ID:");
                        int tid = scanner.nextInt();
                        List<Transcation> list = transcationMap.get(tid);
                        if (list == null) {
                            System.out.println("Account not found\n Create your account now in our Bank");
                            break;
                        }
                        if (list.isEmpty()) {
                            System.out.println("No transactions found");
                            break;
                        }
                        for (Transcation t : list) {
                            System.out.println(t);
                        }
                        break;


                    case 10:
                        System.out.println("Shutting down");
                        executor.shutdown();
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }catch(IllegalArgumentException illegalArgumentException){
                System.out.println(illegalArgumentException.getMessage());
            }catch (java.util.InputMismatchException e) {
                System.out.println("Please enter numbers only.");
                scanner.nextLine();
            }
        }

    }


}
