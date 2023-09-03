import java.awt.*;

public class MyTest implements Runnable {
    private int first,end;
    public MyTest(int first,int end){
        this.first=first;
        this.end=end;

    }

    @Override
    public void run() {
        for(int i=first;i<end;i++){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        Runnable target=new MyTest(1,5);
       Thread thread_odd=new Thread(target,"奇数进程");
       thread_odd.run();
       new Thread(new MyTest(2,5),"偶数进程").run();
    }

}
