package thread;

public class AlternatePrint3 {
    private static volatile int i=0;
    private static int max=100;

    public static void main(String[] args) {
        new Thread(()->{
            while(i<max){
                if(i%2==0){
                    System.out.println(Thread.currentThread().getName()+" 打印 "+i);
                    i++;
                }
            }
        }).start();


        new Thread(()->{
            while(i<max){
                if(i%2==1){
                    System.out.println(Thread.currentThread().getName()+" 打印 "+i);
                    i++;
                }
            }
        }).start();


    }
}
