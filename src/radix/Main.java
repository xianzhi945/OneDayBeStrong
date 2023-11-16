package radix;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 创建 Radix Tree
        RadixTree tree = new RadixTree();
        tree.insert("192.168.2.0/24");
        tree.insert("192.168.0.0/16");

        int mask = tree.match("192.168.2.3");
        System.out.println(Integer.toBinaryString(mask));
    }
}
