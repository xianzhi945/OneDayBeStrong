import java.io.FileInputStream;
import java.io.FileOutputStream;

class A{
    A(){
        System.out.println("A");
    }
}
class B extends A{
    B(){
        System.out.println("B");
    }
}
public class Cat {

    public static void main(String[] args) {
        int n=10;
        try {
            n++;
            n=n/0;
            n++;
        }catch (Exception e){
            n++;
        }
        finally {
            n--;
        }
        System.out.println(n);
    }
}