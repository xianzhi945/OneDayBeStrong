import java.awt.geom.Point2D;
import java.util.*;

public class Test3 {
    public boolean isPointInPolygon(double x, double y, double[] coords) {
        Point2D.Double p1=new Point2D.Double();
        p1.x=x;
        p1.y=y;
        List<Point2D.Double> pts=new ArrayList<>();
        for(int i=0;i<coords.length;i+=2){
            Point2D.Double p=new Point2D.Double();
            p.x=coords[i];
            p.y=coords[i+1];
            pts.add(p);
        }
        return isPtInPoly(p1,pts);
    }
    /**
     * 判断点是否在多边形内
     * <p>
     * 整个算法的思路为：作点平行于y轴的射线，这样就可以直接比较交点是否大于点(x,y)中y的值，可以简化判断。
     *
     * @param point 检测点
     * @param pts   多边形的顶点
     * @return 点在多边形内返回true, 否则返回false
     */
    public  boolean isPtInPoly(Point2D.Double point, List<Point2D.Double> pts) {
        int polygonSidesCount = pts.size();
        //如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
        boolean boundOrVertex = true;
        // 射线与多边形相交的次数
        int intersectCount = 0;
        //浮点类型计算时候与0比较时候的容差
        double precision = 2e-10;
        // 相邻两点
        Point2D.Double p1, p2;
        // 当前点
        Point2D.Double p = point;
        // 线段起点
        p1 = pts.get(0);
        for (int i = 1; i <= polygonSidesCount; ++i) {
            //按照点录入的顺序依次检查相邻两点组成的线段和当前的点的关系。
            if (p.equals(p1)) {
                //如果当前点就是多边形的顶点之一，直接返回。
                return boundOrVertex;
            }
            // 线段终点
            p2 = pts.get(i % polygonSidesCount);
            if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)) {
                //点在x轴上的映射，明显超出了线段在x轴上的投影。此时冲着上做射线，肯定没有交点，直接跳过。
                p1 = p2;
                continue;
            }
            if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)) {
                // 当前点在线段于x轴上的投影内
                if (p.y <= Math.max(p1.y, p2.y)) {
                    //当前点的 y 坐标小于 线段对y轴投影的最大值
                    if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {
                        // 若线段同样是平行于y轴，则可以断定，当前点，在多边形的这条垂直于x轴的边上。
                        return boundOrVertex;
                    }
                    if (p1.y == p2.y) {
                        // 若线段为平行于x轴的水平线
                        if (p1.y == p.y) {
                            //当前点正好位于该水平线上，直接返回该点位于多边形的一条边上。
                            return boundOrVertex;
                        } else {
                            //如果当前点在水平线以下，增加一个交点。
                            ++intersectCount;
                        }
                    } else {
                        // 如果不是水平线，则用两点式求当前点的x带入多边形线段的直线方程后，对应的y的坐标
                        double xInSideLineFormulaResultY = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;
                        if (Math.abs(p.y - xInSideLineFormulaResultY) < precision) {
                            // 误差允许范围内，改点就在线段上，则表明，该点位于多边形的一个边上。
                            return boundOrVertex;
                        }

                        if (p.y < xInSideLineFormulaResultY) {
                            // 如果线段上取得的y比当前点的y要大，当前做向上的射线，肯定交于上方的一个点。
                            ++intersectCount;
                        }
                    }
                }
            } else {
                // 当前点不在线段投影到x轴的区间中
                if (p.x == p2.x && p.y <= p2.y) {
                    // 但恰好位于线段终点的x坐标对应的平行于y轴上的线上的低于终点y的一点
                    // 此时检查下一点能否将其x边界包含。
                    Point2D.Double p3 = pts.get((i + 1) % polygonSidesCount);
                    if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)) {
                        // 若当前点的x坐标位于 p1和p3组成的线段关于x轴的投影中，则记为该点的射线只穿过端点一次。
                        ++intersectCount;
                    } else {
                        // 若当前点的x坐标不能包含在p1和p3组成的线段关于x轴的投影中，则点射线通过的两条线段组成了一个弯折的部分，
                        // 此时我们记射线穿过该端点两次
                        intersectCount += 2;
                    }
                    // 此判断的核心思路是由点在两条线段的内部还是外部去思考得出的
                }
            }
            // 进行下一个线段的判断
            p1 = p2;
        }
        if (intersectCount % 2 == 0) {
            //偶数在多边形外
            return false;
        } else {
            //奇数在多边形内
            return true;
        }
    }
    public boolean isCompliance(int[][] distance, int n) {
        int temp=0;
        int[] arr=new int[distance.length];
        int time=0;

        for(int i=0;i<distance.length;i++){
            if(arr[i]==0){
                arr[i]=1;
                time++;
                List<Integer> list=new ArrayList<>();
                list.add(i);

                while(!list.isEmpty()){
                    List<Integer> list1=new ArrayList<>();
                    for(int ii:list){
                        for(int j=0;j<distance[0].length;j++){
                            if(arr[j]==0&&distance[ii][j]<2){
                                list.add(j);
                                arr[j]=1;
                            }
                        }
                        System.out.print(ii+" ");
                    }
                   list=list1;
                }

            }
            System.out.println();
        }
        return time<=n;

    }

    int[] arr;
    boolean flag=false;
    int max=0;
    int[][] graph1=new int[101][101];//邻接矩阵

    Map<Integer,List<Integer>> map;
    Set<Integer> set;
    public boolean hasCycle(String graph) {

        String[] str=graph.split(",");
        map=new HashMap();
        set=new HashSet<>();

        for(int i=0;i<str.length;i++){
            String[] temp=str[i].split("->");

            max=Math.max(Integer.parseInt(temp[0]),max);
            max=Math.max(Integer.parseInt(temp[1]),max);
            List<Integer> ll=map.getOrDefault(Integer.parseInt(temp[0]),new ArrayList<>());
            ll.add(Integer.parseInt(temp[1]));
            set.add(Integer.parseInt(temp[0]));
            set.add(Integer.parseInt(temp[1]));
        }

        arr=new int[set.size()+1];
        for(int i=1;i<=max;i++){
            //该结点后边的结点都被访问过了，跳过它
            if(arr[i] == -1){
                continue;
            }
            dfs(i);
            if(flag){
                return true;
            }
        }

        return false;


    }
    public void dfs(int i){
        //System.out.println("正在访问结点"+i);
        //结点i变为访问过的状态
        arr[i] = 1;
//        for(int j=1;j<=max;j++){
//            //如果当前结点有指向的结点
//            if(graph1[i][j] != 0){
//                //并且已经被访问过
//
//                if(arr[j] == 1){
//                    //System.out.println("忧患"+j);
//                    flag = true;//有环
//                    break;
//                }else if(arr[j] == -1){
//                    //当前结点后边的结点都被访问过，直接跳至下一个结点
//                    continue;
//                }else{
//                    dfs(j);//否则递归访问
//                }
//            }
//        }
        List<Integer> list=map.get(i);
        for(int j:list){
            if(arr[j] == 1){
                //System.out.println("忧患"+j);
                flag = true;//有环
                break;
            }else if(arr[j] == -1){
                //当前结点后边的结点都被访问过，直接跳至下一个结点
                continue;
            }else{
                dfs(j);//否则递归访问
            }
        }
        //遍历过所有相连的结点后，把本节点标记为-1
        arr[i] = -1;
    }


}
//[[0,3,1,4],[3,0,1,3],[1,1,0,5],[4,3,5,0]]
//2
//[[0,1,3], [1,0,3], [3,3,0]]
//2
//[[0,3,3], [3,0,3], [3,3,0]]
//2
