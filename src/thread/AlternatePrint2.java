package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrint2 {
    private static int i=0;
    private static int end=10;

    private    static   Lock lock1=new ReentrantLock();
    private    static Condition condition1=lock1.newCondition();
    private static Condition condition2=lock1.newCondition();
    public static void main(String[] args) {
        new Thread(()->{

            while(i<10){
                try {
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName()+" 打印 "+i);
                    i++;
                    condition2.signal();
                    condition1.await();

                }catch (Exception  e){

                }finally {
                    lock1.unlock();
                }
            }

        }).start();
        new Thread(()->{
            while(i<10){
                try {
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName()+" 打印 "+i);
                    i++;
                    condition1.signal();
                    condition2.await();
                }catch (Exception  e){

                }finally {
                    lock1.unlock();
                }
            }
        }).start();
        System.out.println("123");
    }
}
