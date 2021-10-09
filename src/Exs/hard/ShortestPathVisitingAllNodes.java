package Exs.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wy
 * @date 2021/8/5 17:30
 */
// 847. 访问所有节点的最短路径
public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int len=graph.length;
        if(graph.length==0){
            return 0;
        }
        boolean[][] visited = new boolean[len][1 << len]; // 标记是否访问过,用于避免重复访问
        int finishState = ( 1 << len) -1;  // 用于检查是否访问完所有的节点,每个位代表一个节点的状态,形如1111
        Queue<int[]> queue = new LinkedList<>(); // 队列里的数组,第一个记录的是标号,第二个是状态
        for(int i = 0; i < len; i++){
            queue.offer(new int[]{i, 1 << i});
        }
        int step = 0;
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                int[] node = queue.poll();
                if(finishState == node[1]){ // 如果标记的节点访问状态是结束,那么返回步长
                    return step;
                }
                for(int next : graph[node[0]]){
                    int nextState = node[1]|(1<<next); // 2个节点相或,标记着访问了这条边的2个点
                    if(visited[next][nextState]){
                        continue;
                    }
                    visited[next][nextState] = true;
                    queue.offer(new int[]{next,nextState}); // 将该节点和边的信息加入bfs对列
                }
            }
            step++;
        }
        return step;
    }


    public static void main(String[] args) {

    }
}
