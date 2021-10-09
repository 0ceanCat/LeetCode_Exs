package Exs.medium;

import java.util.*;

/**
 * @author Wei
 * @date 2020/8/27 10:42
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，
 * 所以该行程必须从 JFK 开始。
 *
 */
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();

        if (tickets == null || tickets.size() == 0)
            return ans;

        Map<String, Queue<String>> graph = new HashMap<>();

        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            Queue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }

        visit(ans, "JFK", graph);
        return ans;
    }

    private void visit(List<String> result, String key, Map<String, Queue<String>> graph) {
        Queue<String> nbr = graph.get(key);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.poll();
            visit(result, dest, graph);
        }
        result.add(0, key); // 逆序插入
    }
    public static void main(String[] args) {
      /*  List<Theory.String> list1 = Arrays.asList("JFK","SFO");
        List<Theory.String> list2 = Arrays.asList("JFK","ATL");
        List<Theory.String> list3 = Arrays.asList("SFO","ATL");
        List<Theory.String> list4 = Arrays.asList("ATL","JFK");
        List<Theory.String> list5 = Arrays.asList("ATL","SFO");*/
        List<String> list1 = Arrays.asList("MUC","LHR");
        List<String> list2 = Arrays.asList("JFK","MUC");
        List<String> list3 = Arrays.asList("SFO","SJC");
        List<String> list4 = Arrays.asList("LHR","SFO");
        List<List<String>> lists = Arrays.asList(list1, list2, list3, list4);
        ReconstructItinerary r = new ReconstructItinerary();
        System.out.println(r.findItinerary(lists));
    }
}
