import java.util.Arrays;
import java.util.Comparator;

public class Sort {

    //冒泡排序，将最大的换到最后一位，然后把第二大的换到倒数第二位     O(n2) 稳定排序
    public static void bubbleSort(int[] arr){
        for(int i=arr.length;i>0;i--){
            for(int j=0;j<i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    //快速排序 分治的思想 随机选取一个值，默认取最左边的 将比这个值大的放到它右边，比这个值小的放到它左边  O(nlogn) 不稳定排序  空间复杂度 O(logn) 因为递归需要创建logn个target变量
    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int target=arr[left];
        int l=left;
        int r=right;
        while(l<r){
            while(arr[r]>=target&&l<r){
                r--;
            }
            arr[l]=arr[r];
            while(arr[l]<=target&&l<r){
                l++;
            }
            arr[r]=arr[l];
        }
        arr[l]=target;
        quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);
    }

    //选择排序 也是交换的思想 先找最大的然后找最第二大的
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {// 选择length-1次
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
                if (minIndex != i) {     //交换
                    arr[minIndex] = arr[i];
                    arr[i] = min;
                }
            }
        }
    }
    //堆排序  堆是一颗完全二叉树  某个节点的值总是不大于或者不小于他父节点的值  大顶堆 小顶堆 堆的内部不一定有序
    //堆是完全二叉树  所以可以用数组表示 第i个节点的父节点下标位(i-1)/2   第i个节点左孩子位 2i+1  右孩子为2i+2   叶子节点是从n/2 开始的
    // 构建堆  第一次构建堆 对所有非叶子节点从后往前依次调整    这个是O(n)   增加/删除一个元素都是O(logn)
    // 构建堆后，将堆顶元素放到最后再重新建堆 这次不需要都建了
    public static void heapSort(int[] arr){
       //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {

            //将堆顶元素与末尾元素进行交换
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }
    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点 取左右节点的最大值
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i]=temp;
    }
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i)
            person[i] = new int[]{height[i], weight[i]};
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0)
                i = -(i + 1);
            dp[i] = pair[1];
            if (i == res)
                ++res;
        }
        return res;
    }

    public static void print(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr=new int[5];
        arr[0]=3;
        arr[1]=1;
        arr[2]=6;
        arr[3]=5;
        arr[4]=2;
        //bubbleSort(arr);
        quickSort(arr,0,arr.length-1);
        print(arr);
    }
}
