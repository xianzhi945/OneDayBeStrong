package contest5_28;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public boolean digitCount(String num) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<num.length();i++){
            map.put(num.charAt(i)-'0',map.getOrDefault(num.charAt(i)-'0',0)+1);
        }
        for(int i=0;i<num.length();i++){
            System.out.println(map.get(i));
            if(map.get(i)==null||map.get(i)!=num.charAt(i)-'0'){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {

    }
}
