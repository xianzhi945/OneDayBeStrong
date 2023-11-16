package zixishi;

public class JiaoZiYu {
    private static double jiaoIn;
    private static double zhouIn;
    private static double jiaoOut;
    private static double zhouOut;

    private static double xiaochengxu;
    private static double shouxufei=0.006;

    public static void calculate(){
        jiaoIn=7544.5;;
        jiaoOut=2918.7;
        zhouIn=7546.6;
        zhouOut=1439.8;
        

        double totalIn=jiaoIn+zhouIn;

        double totalOut=jiaoOut+zhouOut;

        double averageIn=(totalIn-totalOut)/2;

        System.out.println("本月你们每人赚了："+averageIn);

        double getMoney=averageIn-zhouIn+zhouOut;
        if(getMoney>0){
            System.out.println("公主需要给我   :"+getMoney);
        }else{
            System.out.println("我需要给公主   :"+getMoney*-1);
        }
    }

    public static void main(String[] args) {
        JiaoZiYu.calculate();
    }
}
