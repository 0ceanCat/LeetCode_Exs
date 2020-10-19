package Exs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Wei
 * @date 2020/9/8 10:59
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combinations {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {

        result = new ArrayList<>();

        LinkedList<Integer> queue = new LinkedList<>();

        dfs(1, n, k, queue);

        return result;
    }

    private void dfs(int start, int n, int k, LinkedList<Integer> queue) {
        if (queue.size() == k){
            result.add(new ArrayList<>(queue));
            return;
        }

        for (int j = start; j <= n - (k - queue.size()) + 1; j++) {
            queue.addLast(j);
            dfs(j + 1, n, k, queue);
            queue.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> combine = c.combine(6,4);
        System.out.println(combine);
    }
}
