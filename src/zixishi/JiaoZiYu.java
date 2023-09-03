package zixishi;

public class JiaoZiYu {
    private static double jiaoIn;
    private static double zhouIn;
    private static double jiaoOut;
    private static double zhouOut;

    private static double xiaochengxu;
    private static double shouxufei=0.006;

    public static void calculate(){
        jiaoIn=11536.9;;
        jiaoOut=4016.5;
        zhouIn=8312.9;
        zhouOut=406.1+3784.2;
        

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
