package com.zeta;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;


//class SumTask extends RecursiveTask<Integer> {
//    private static final int Threshold=3;
//    private BankAccount[] account;
//    private int start,end;
//
//    SumTask(BankAccount[] account,int start,int end){
//        this.account =account;
//        this.start=start;
//        this.end=end;
//    }
//
//
//    @Override
//    protected Integer compute() {
//        if(end-start<=Threshold){
//            int sum=0;
//            for(int i=start;i<end;i++){
//                sum+= account[i].getBalance();
//            }
//            return sum;
//        }else{
//            int mid = (start + end) / 2;
//            SumTask left = new SumTask(account, start, mid);
//            SumTask right = new SumTask(account, mid, end);
//            left.fork();
//            int Rightresult=right.compute();
//            int leftresult=left.join();
//            return leftresult+Rightresult;
//        }
//
//    }
//}

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter initial balance :");
        int initialbalance=sc.nextInt();
        while(initialbalance<0){
            System.out.println("enter valid balance");
            initialbalance=sc.nextInt();
        }

//        BankAccount[] account=new BankAccount[20];
//        for(int i=0;i<20;i++){
//            int initialbalance=(int)(Math.random()*1000);
//            account[i]= new BankAccount(initialbalance);
//        }
//        ForkJoinPool pool=new ForkJoinPool();
//        int result=pool.invoke(new SumTask(account,0, account.length));
//        System.out.println("sum "+result);


        ExecutorService executor= Executors.newFixedThreadPool(3);
        BankAccount account=new BankAccount(initialbalance);
        while(true){
            System.out.println("\nMULTITHREADED BANKING SYSTEM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Simulate Parallel Withdrawals");
            System.out.println("5. Get loan");
            System.out.println("6  Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number (1–6).");
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
                        System.out.println("Simulating two parallel withdrawals of ₹" + (initialbalance / 2));

                        executor.execute(new Withdrawtask(account, initialbalance / 2));
                        executor.execute(new Withdrawtask(account, initialbalance / 2));
//                        int finalInitialbalance = initialbalance;
//                        executor.execute(()->account.withdraw(finalInitialbalance /2));
//                        int finalInitialbalance1 = initialbalance;
//                        executor.execute(()->account.withdraw(finalInitialbalance1 /2));

                        break;

                    case 5:
                        if (account.hasLoan()) {
                            System.out.println("Loan already exists");
                            break;
                        }
                        int money=account.getBalance();
                        if(money<100000){
                            System.out.println("Insufficient balance");
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
