import java.util.Comparator;
import java.util.PriorityQueue;

public class Account {
    private long id;
    private String custom;
    private double balance;

    public Account(){

    }
    public Account(long id,String custom,double balance){
        this.id=id;
        this.custom=custom;
        this.balance=balance;
    }


    @Override
    public String toString() {
       return custom+"("+id+"),Balance=$"+balance;
    }

    public void deposit(double price){
        this.balance+=price;
    }
    public boolean withdraw(double price){
        if(this.balance<price){
            return false;
        }
        this.balance-=price;
        return true;
    }


    public static void main(String[] args) {
        Account account=new Account(1,"Test",0);
        System.out.println(account);

        account.deposit(100.00);
        System.out.println(account);

        if(account.withdraw(200)){
            System.out.println("取款成功 "+account);
        }else{
            System.out.println("取款失败 "+account);
        }

        if(account.withdraw(80)){
            System.out.println("取款成功 "+account);
        }else{
            System.out.println("取款失败 "+account);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(1, (o1, o2) -> 0);

    }


}
