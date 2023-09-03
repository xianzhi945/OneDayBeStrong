import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class contest5_22 {
    public static void maxSubProduct(int arr[])
    {
        if(arr==null||arr.length==0)
            return ;
        int max=arr[0],min=arr[0],maxend,result=0;
        for(int i=1;i<arr.length;i++)
        {
            //最大值的来源有三种，如果arr[i]是正数，肯定与前面的最大值相乘得到最大值，
            //如果arr[i]是负数就会与前面的最小值相乘产生最大值。如果前面的为0或者负数，
            //arr[i]本身可能是最大值。
            maxend=Max(max*arr[i],min*arr[i],arr[i]);
            //maxend 保存最大值
            min=Min(max*arr[i], min*arr[i], arr[i]);
            //用于保存最小的负值，为下一个最大值最准备
            max=maxend;
            result=Math.max(result, max);
        }
        System.out.println(result);
    }

    public static int Max(int a,int b,int c)
    {
        //返回 a b c 中的最大值
        a=Math.max(a, b);
        a=Math.max(a, c);
        return a;
    }
    public static int Min(int a,int b,int c)
    {
        //返回  a b c 中的最小值
        a=Math.min(a, b);
        a=Math.min(a, c);
        return a;
    }

    public static void main(String[] args){
        int[] arr={5,4,6};

        List<Integer> aList=new ArrayList<Integer>();
        List<Integer> bList=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            aList.add(arr[i]);
        }
//        getSonSet1(0,aList,bList); //方法1，递归法
//
//        System.out.println("----数组arr公用，分割线-----");
//
//        getSonSet2(arr,arr.length); //方法2，按位对应法
        getSonSet3(arr,arr.length); //方法2，按位对应法
        maxSubProduct(arr);
    }

    /*
     * 递归法
     */
    public static void getSonSet1(int i,List<Integer> aList,List<Integer> bList){
        if(i>aList.size()-1){
            if(bList.size()<=0){
                System.out.print("@");
            }else {
				/*for(int v:bList){
					System.out.print(v+",");//可以直接用这种方法输出bList数组里所有值，但是每个子数组最后就会带逗号
				}*/
                System.out.print(bList.get(0));
                for(int m=1;m<bList.size();m++){
                    System.out.print(","+bList.get(m));
                }
            }
            System.out.println();
        }else {
            bList.add(aList.get(i));
            getSonSet1(i+1, aList, bList);
            int bLen=bList.size();
            bList.remove(bLen-1);
            getSonSet1(i+1, aList, bList);
        }
    }


    /*
     *按位对应法。
     */
    private static void getSonSet2(int[] arr, int length) {
        int mark=0;
        int nEnd=1<<length;
        boolean bNullSet=false;
        for(mark=0;mark<nEnd;mark++){
            bNullSet=true;
            for(int i=0;i<length;i++){
                if(((1<<i)&mark)!=0){//该位有元素输出
                    bNullSet=false;
                    System.out.print(arr[i]+",");
                }
            }
            if(bNullSet){//空集合
                System.out.print("@");
            }
            System.out.println();
        }
    }
    private static void getSonSet3(int[] arr, int length) {

        PriorityQueue<Integer> pq=new PriorityQueue<>();


        int min=Integer.MAX_VALUE;
        int sum=0;
        int res=0;
        for(int i=0;i<length;i++){
            min=Integer.MAX_VALUE;
            sum=0;
            for(int j=i;j<length;j++){
                min=Math.min(min,arr[j]);
                sum=(sum+arr[j])%1000000007;
                res+=(sum*min)%1000000007;
                System.out.println(min+" "+sum);
            }
            System.out.println(" ");

        }

    }
}
