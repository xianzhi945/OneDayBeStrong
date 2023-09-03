package MeiTuan;
import java.util.*;

public class Test1{
    static int min;
    static void traverse(ArrayList<Integer> inList, ArrayList<Integer> auxList) {
        if (inList.size() > 0) { // inList 中有元素，元素递归没有结束，继续递归。
            for (int i = 0; i < inList.size(); i++) {
                auxList.add(inList.remove(i)); // 将 inList 中第 i 个元素添加至 auxList 末尾
                traverse(inList, auxList); // 递归调用变化后的数组情况
                inList.add(i, auxList.remove(auxList.size() - 1)); // 再将这个元素归还给 inList.
            }
        } else { // inList 中元素为空，表示已经全部排列，输出结果。
            System.out.println(Arrays.toString(auxList.toArray()));
            int temp=0;
            for(int i=0;i<auxList.size();i++){
                temp+= auxList.get(i)/(i+1);
            }
            min=Math.min(temp,min);
        }
    }
    public static void main(String args[]){
        Scanner reader=new Scanner(System.in);
        while(reader.hasNextInt()){
            int m=reader.nextInt();
            int[] a=new int[m];
            for(int i=0;i<m;i++){
                a[i]=reader.nextInt();
            }
            int res=0;
            Test1.min=Integer.MAX_VALUE;
            System.out.println(res);

            Map<Integer, List<Integer>> map=new HashMap<>();
        }
    }
}
