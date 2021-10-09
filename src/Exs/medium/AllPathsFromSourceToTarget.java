package Exs.medium;

import Exs.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wy
 * @date 2021/8/24 17:06
 */
public class AllPathsFromSourceToTarget {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list.add(0);
        dps(graph, 0, graph.length - 1);
        return res;
    }

    private void dps(int[][] graph, int x, int k) {
        if (x == k){
            res.add(new ArrayList<>(list));
            return;
        }
        int[] nexts = graph[x];
        for (int next : nexts) {
            list.addLast(next);
            dps(graph, next, k);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget a = new AllPathsFromSourceToTarget();
        a.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
    }
}
