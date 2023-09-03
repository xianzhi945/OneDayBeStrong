package zixishi;

import com.sun.javafx.binding.StringFormatter;

import java.util.TreeMap;

public class Salary {
    public static double dongBase=800;

    public static double yunyingCost=1800+300+500+100+250+600+200+500+1000;//房租+取暖+清洁+小程序+美团+水电+宽带话费+日常损耗+装修损耗
    public static double alpha=0.2;
    public static double alpha1=0.3;
    public static double yuzhi=15000;
    public static TreeMap<String,Double> map=new TreeMap<>();
    public static void main(String[] args) {
        System.out.println(yunyingCost);
        map.put(" Mock 1",5000.0);
        map.put(" Mock 2",6000.0);
        map.put(" Mock 3",7000.0);
        map.put(" Mock 4",8000.0);
        map.put(" Mock 5",9000.0);
        map.put(" Mock 6",10000.0);
        map.put(" Mock 7",11000.0);
        map.put(" Mock 8",12000.0);
        map.put(" Mock 9",13000.0);
        map.put(" Mock10",14000.0);
        map.put(" Mock11",15000.0);
        map.put(" Mock12",16000.0);
        map.put(" Mock13",17000.0);
        map.put(" Mock14",18000.0);
        map.put(" Mock15",19000.0);
        map.put("2022.5.1-2022.5.31",6932.2+9665-25-251-190);
        map.put("2022.6.1-2022.6.30",11641+8635.2);
        map.put("2022.7.1-2022.7.31",6387+6733-120-170.4-52.8-128-48-138);
        map.put("2022.8.1-2022.8.31",9030+8377.8-33.2-15);
        map.put("2023.4.1-2023.4.30",2521+748-192+6744.8-949);
        map.put("2023.5.1-2023.5.31",2346.6+3985-433-200);
        map.put("2023.6.1-2023.6.30",10561+1405.8+326.8);
        map.put("2023.7.1-2023.7.30",3234+9497+1793.07-180);
        map.put("2023.8.1-2023.8.31",8312.9+2259+192.77-25);
//        map.put("real",10561+1405.8+326.8);
        for(String str:map.keySet()){
            System.out.println(str+"   "+ StringFormatter.format("%.2f",map.get(str)).getValue()+"    "+StringFormatter.format("%.2f",calculate(map.get(str))).getValue());
        }
    }
    public static double calculate(double in){
        double salary=dongBase;
        if(in<yunyingCost)
            return salary;
        salary+=(Math.min(in,yuzhi)-yunyingCost)*alpha;
        if(in>yuzhi){
            salary+=(in-yuzhi)*alpha1;
        }
        return salary;
    }
}
