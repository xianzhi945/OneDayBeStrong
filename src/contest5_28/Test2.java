package contest5_28;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public String largestWordCount(String[] messages, String[] senders) {
        int n=messages.length;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int temp=messages[i].split(" ").length;
            map.put(senders[i],map.getOrDefault(senders[i],0)+temp);
        }
        int max=0;
        String res="";
        for(String key:map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
                res=key;
            }else if(map.get(key)==max){
                if(key.compareTo(res)>0){
                    res=key;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
