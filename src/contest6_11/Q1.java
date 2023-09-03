package contest6_11;

import java.util.*;

public class Q1 {

    public boolean strongPasswordCheckerII(String password) {
        char[] temp=new char[]{'!','@','#','$','%','^','&','*','(',')','-','+'};
        Set<Character> set=new HashSet<>();
        if(password.length()<8){
            return false;
        }
        for(int i=0;i<temp.length;i++){
            set.add(temp[i]);
        }
        int flag1=0;
        int flag2=0;
        int flag3=0;
        int flag4=0;
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            if(i>0&&password.charAt(i-1)==c){
                return false;
            }
            if(c>='0'&&c<='9'){
                flag1=1;
            }else if(c>='a'&&c<='z'){
                flag2=1;
            }else if(c>='A'&&c<='Z'){
                flag3=1;
            }else if(set.contains(c)){
                flag4=1;
            }

        }
        return (flag1+flag2+flag3+flag4)==4;
    }

    public int[] successfulPairs1(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            for(int j=0;j<potions.length;j++){
                //long temp=(long)spells[i]*(long)potions[j];
                System.out.println();
                long temp= (long) Math.ceil(success/spells[i]);
                if(potions[j]>=temp){
                    res[i]=potions.length-j;
                    break;

                }
            }
        }
        return res;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[][] spells_temp=new int[spells.length][2];
        for(int i=0;i<spells.length;i++){
            spells_temp[i][0]=spells[i];
            spells_temp[i][1]=i;
        }

        Arrays.sort(spells_temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for(int i=0;i<spells.length;i++){
            System.out.println(spells_temp[i][0]+" "+spells_temp[i][1]);

        }

        int index=0;
        for(int i=0;i<spells.length;i++){
            if(index==potions.length){
                spells[spells_temp[i][1]]=0;
            }else{
                long temp=(long)spells_temp[i][0]*potions[index];
                if(temp<success){
                    index++;
                }else{
                    spells[spells_temp[i][1]]=potions.length-index;
                }
            }
        }
        return spells;
    }
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character,String> map=new HashMap<>();
        for(int i=0;i<mappings.length;i++){
            map.put(mappings[i][0],map.getOrDefault(mappings[i][0],"")+mappings[i][1]);
        }
        int length=sub.length();
        for(int i=0;i<s.length()-length;i++){
            String temp=s.substring(i,i+length);
            System.out.println();
            for(int j=0;j<length;j++){
                char a=temp.charAt(j);
                char b=sub.charAt(j);
                if(a!=b){
                    if(map.containsKey(b)){
                        String value=map.get(b);
                        if(value.contains(a+"")){
                            if(j==length-1){
                                return true;
                            }
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }

        }
        return false;

    }


    public long countSubarrays(int[] nums, long k) {
        long res=0;

        int left = 0;
        int right = 0;
        //创建一个变量记录路上的乘积
        long sum=0;
        long mul = 0;
        //记录连续数组的组合个数


        //用右指针遍历整个数组，每次循环右指针右移一次
        while(right<nums.length) {
            //记录乘积
            sum+=nums[right];
            mul= sum*(right-left+1);

            //当大于等于k，左指针右移并把之前左指针的数除掉
            while (mul >= k) {
                sum-=nums[left];
                mul= sum*(right-left+1);
                left++;
            }

            //每次右指针位移到一个新位置，应该加上 x 种数组组合：
            //  nums[right]
            //  nums[right-1], nums[right]
            //  nums[right-2], nums[right-1], nums[right]
            //  nums[left], ......, nums[right-2], nums[right-1], nums[right]
            //共有 right - left + 1 种
            System.out.println(res);
            res += right - left + 1;

            //右指针右移
            right++;
        }


        return res;
    }
    public double calculateTax(int[][] brackets, int income) {

        double res=0;
        int last=0;
        for(int i=0;i<brackets.length;i++){
            if(income>brackets[i][0]){
                res+=(double)(brackets[i][0]-last)*((double)brackets[i][1]/100);
                last=brackets[i][0];
            }else{
                res+=(double)(income-last)*((double)brackets[i][1]/100);
                break;
            }
        }
        return res;

    }


    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int s=0;s<n;s++){
                    //上面一行所有moveCost+dp的最小值
                    dp[i][j]=Math.min( dp[i][j],dp[i-1][s]+moveCost[grid[i-1][s]][j]+grid[i][j]);
                }
                System.out.println(dp[i][j]);
            }

        }
        int minValue=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minValue=Math.min(dp[m-1][i],minValue);
        }
        return minValue;


    }

    long min=Integer.MAX_VALUE;
    int n=0;
    int[] cookies;
    int[] get;
    public int distributeCookies(int[] cookies, int k) {
        get=new int[k];
        this.cookies=cookies;
        n=cookies.length;
        dfs(0);
        return (int)min;
    }
    public void dfs(int index){
        System.out.println(index);
        if(index==n){
            int max=0;
            for(int i=0;i<get.length;i++){
                max=Integer.max(max,get[i]);
            }
            min=Math.min(max,min);
            return;
        }
        for(int i=0;i<get.length;i++){
            get[i]+=cookies[i];
            dfs(index+1);
            get[i]-=cookies[i];
        }
    }


    public long distinctNames(String[] ideas) {
        HashSet<String> keys = new HashSet<>();
        for (String idea : ideas) {
            keys.add(idea);
        }
        StringBuilder[] builders = new StringBuilder[ideas.length];
        for (int i = 0; i < ideas.length; i++) {
            builders[i] = new StringBuilder(ideas[i]);
        }
        int[][] num = new int[26][26];
        for (int i = 0; i < ideas.length; i++) {
            int c = ideas[i].charAt(0) - 'a';
            for (int j = 0; j < 26; j++) {
                builders[i].setCharAt(0, (char) ('a' + j));
                if (!keys.contains(builders[i].toString())) {
                    num[c][j]++;
                }
            }
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                System.out.print(num[i][j]+" ");
            }
            System.out.println();
        }
        long sum = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                sum += num[i][j] * num[j][i];
            }
        }
        return sum*2;

    }

    int[] arr;
    boolean flag=false;
    int max=0;
    int[][] graph1=new int[101][101];//邻接矩阵
    public boolean hasCycle(String graph) {
        Set<Integer> set=new HashSet<>();

        String[] str=graph.split(",");
//        int[][] arr=new int[str.length][2];

        for(int i=1;i<=101;i++){
            for(int j=1;j<=101;j++){
                graph1[i][j] = 0;
            }
        }
        //Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<str.length;i++){
            String[] temp=str[i].split("->");
//            arr[i][0]=Integer.parseInt(temp[0]);
//            arr[i][1]=Integer.parseInt(temp[1]);
//            List list=map.getOrDefault(Integer.parseInt(temp[0]),new ArrayList<>());
//            list.add(Integer.parseInt(temp[1]));
//            map.put(Integer.parseInt(temp[0]),list);
            graph1[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 0;
            max=Math.max(Integer.parseInt(temp[0]),max);
            max=Math.max(Integer.parseInt(temp[1]),max);
        }
        arr=new int[max];
        for(int i=1;i<=max;i++){
            //该结点后边的结点都被访问过了，跳过它
            if(arr[i] == -1){
                continue;
            }
            dfs(i);
            if(!flag){
                return true;
            }
        }

        return false;


    }
    public void dfs2(int i){
        System.out.println("正在访问结点"+i);
        //结点i变为访问过的状态
        arr[i] = 1;
        for(int j=1;j<=max;j++){
            //如果当前结点有指向的结点
            if(graph1[i][j] != 0){
                //并且已经被访问过
                if(arr[j] == 1){
                    flag = false;//有环
                    break;
                }else if(arr[j] == -1){
                    //当前结点后边的结点都被访问过，直接跳至下一个结点
                    continue;
                }else{
                    dfs2(j);//否则递归访问
                }
            }
        }
        //遍历过所有相连的结点后，把本节点标记为-1
        arr[i] = -1;
    }


    public static void main(String[] args) {
        Q1 q1=new Q1();

    }
}
