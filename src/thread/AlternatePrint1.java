package thread;

//使用synchronized打印
public class AlternatePrint1 {
    private static int i=0;
    private static final Integer mtx=0;
    private static  final Integer end=10;
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (mtx){
                while(i<end){
                        System.out.println(Thread.currentThread().getName()+" 打印 "+i);
                        i++;
                    mtx.notify();
                    try{
                        if(i!=end) {
                            mtx.wait();
                        }
                       // Thread.sleep(1000);
                    }catch (InterruptedException e){
                    }
                }
            }
        }).start();

        new Thread(()->{
            synchronized (mtx){
                while(i<end){

                    System.out.println(Thread.currentThread().getName()+" 打印 "+i);
                    i++;

                    mtx.notify();
                    try{
                        if(i!=end) {
                            mtx.wait();
                        }
                        //Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }

                }
            }
        }).start();
    }
}
