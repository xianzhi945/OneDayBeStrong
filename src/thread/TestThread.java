package thread;

//A线程类
 class ThreadA extends Thread {
    private TestThread testThread;
    public ThreadA(TestThread testThread){
        this.testThread=testThread;
    }

    @Override
    public void run(){
        int count=0;
        for(int i=0;i<5;i++){
            count++;
            testThread.printStr(count,"A");
        }
        System.out.println("a线程打印完了");
    }
}
//B线程类
 class ThreadB extends Thread {
    private TestThread testThread;
    public ThreadB(TestThread testThread){
        this.testThread=testThread;
    }
    @Override
    public void run(){
        int count=0;
        for(int i=0;i<5;i++){
            count++;
            testThread.printStr(count,"B");
        }
        System.out.println("b线程打印完了");
    }
}
//测试类
public class TestThread {
    public static  void main(String[] args){
        TestThread testThread=new TestThread();
        ThreadA threadA = new ThreadA(testThread);
        ThreadB threadB = new ThreadB(testThread);
        threadB.setPriority(1);
        threadA.setName("threadA");
        threadB.setName("threadB");
        threadB.start();
        threadA.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("交替打印完成");
    }

    public synchronized void printStr(int count,String str){
        String name = Thread.currentThread().getName();
        if("A".equals(str)){
            System.out.println(name+"-----"+"A");

        }else if("B".equals(str)){
            System.out.println(name+"-----"+"B");
        }
        try {
            notify();
            if(count!=5){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}