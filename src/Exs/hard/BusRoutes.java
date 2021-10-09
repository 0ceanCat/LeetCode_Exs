package Exs.hard;

import java.util.*;

/**
 * @author wy
 * @date 2021/6/27 23:31
 */
// 815. 公交路线
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        //<station,{bus}>-每个站都被哪些公交车经过
        Map<Integer,List<Integer>> s2b = new HashMap<>();
        for(int b = 0; b < routes.length; b++){
            for(int s : routes[b]){
                List<Integer> list = s2b.computeIfAbsent(s, x -> new ArrayList<>());
                list.add(b);
            }
        }
        //记录已经坐了哪些公交车
        int[] memory2b = new int[routes.length];  //知道多长
        //bfs-收集当前station辐射到的station
        Queue<Integer> q = new LinkedList<>();
        q.offer(source); //先压入起始车站
        int count = 0; //坐过多少公交车

        //bfs
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            //每次q收集cur辐射到的所有station，都是cur可以不用换乘到达的车站
            //while(size--)结束，没有找到target说明需要换乘一次，count++
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                //经过cur的所有车
                for(int car : s2b.get(cur)){
                    if(memory2b[car] == 1) continue;
                    memory2b[car] = 1;  //标记已经访问过的car

                    for(int s : routes[car]){
                        if(s == target) return count;
                        if(s == cur) continue;
                        q.offer(s);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BusRoutes busRoutes = new BusRoutes();
        System.out.println(busRoutes.numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}},
                15, 12));
    }
}
