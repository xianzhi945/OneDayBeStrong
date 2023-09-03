import java.util.*;

public class Test1 {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int i=0;i<matchsticks.length;i++){
            sum+=matchsticks[i];
        }
        if(sum%4!=0){
            return false;
        }
        Arrays.sort(matchsticks);
        for(int i=0,j=matchsticks.length-1;i<j;i++,j--){
            int temp=matchsticks[i];
            matchsticks[i]=matchsticks[j];
            matchsticks[j]=temp;
        }
        for(int i=0;i<matchsticks.length;i++){
            System.out.println(matchsticks[i]);
        }
        return dfs(0,matchsticks,new int[4],sum/4);

    }
    public boolean dfs(int index,int[] matchsticks,int[] bian,int length){
        if(index==matchsticks.length){
            return true;
        }
        for(int i=0;i<4;i++){
            bian[i]+=matchsticks[index];
            System.out.println();
            if(bian[i]<=length&&dfs(index+1,matchsticks,bian,length)){
                System.out.println(bian[i]+" "+i);
                continue;
            }
            bian[i]-=matchsticks[index];
        }

        return false;
    }


    public int minMaxGame(int[] nums) {
        if(nums.length<=1){
            return 1;
        }
        int length= nums.length;
        List<Integer> list=new ArrayList<Integer>();
        while(length>1){
            int[] temp=new int[length/2];
            for(int i=0;i<length/2;i++){
                if(i%2==0){
                    temp[i]=Math.min(nums[2*i],nums[2*i+1]);
                    System.out.println(i+" "+temp[i]);
                }else{
                    temp[i]=Math.max(nums[2*i],nums[2*i+1]);
                    System.out.println(i+" "+temp[i]);
                }
            }
            nums=temp;
            length/=2;
        }
        return nums[0];

    }
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        int index=0;
        int temp=nums[0];
        while(index<nums.length){
            temp=nums[index]+k;
            res++;
            System.out.println(temp);
            while(index<nums.length&&nums[index]<=temp){
                index++;
            }
            index++;
        }
        return res;
    }
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<operations.length;i++){
            map.put(operations[i][1],map.get(operations[i][0]));
            map.remove(operations[i][0]);
        }
        for(Integer a:map.keySet()){
            nums[map.get(a)]=a;
        }

        return nums;
    }
    String sb;
    int cur;


    public void addText(String text) {
        sb=sb.substring(0,cur)+text+sb.substring(cur,sb.length());
        cur=cur+text.length();

    }

    public int deleteText(int k) {

        int res=Math.min(cur,k);
        sb=sb.substring(0,cur-res)+sb.substring(cur,sb.length());
        cur-=res;
        return res;
    }

    public String cursorLeft(int k) {
        cur-=Math.min(cur,k);
        return sb.substring(Math.max(0,cur-10),cur);

    }

    public String cursorRight(int k) {
        cur+=Math.min(sb.length()-cur,k);
        return sb.substring(Math.max(0,cur-10),cur);
    }
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 2};
        Test1 test1=new Test1();
        System.out.println(test1.makesquare(arr));
    }
    // 运行后是从大到小排好序的

}
