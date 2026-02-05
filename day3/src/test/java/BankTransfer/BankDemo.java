package BankTransfer;

class BankAccount{
    int balance;

    BankAccount(int balance){
        this.balance=balance;
    }

    synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" withdrawing");
        if(balance>=amount){
            System.out.println("approved for "+ Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance-=amount;
            System.out.println("withdraw completed and remaining balance :"+getBalance());
        }else{
            System.out.println("insufficient balance");
        }
    }
    int getBalance(){
        return balance;
    }
}


public class BankDemo {
    public  static void main(String[] args) throws InterruptedException {
            BankAccount acc=new BankAccount(2000);
            Thread t1=new Thread(()->acc.withdraw(100),"T1");
            Thread t2=new Thread(()->acc.withdraw(100),"T2");

            t1.start();
            t2.start();
            t1.join();
            t2.join();
    }
}
