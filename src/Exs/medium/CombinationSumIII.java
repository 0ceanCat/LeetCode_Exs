package Exs.medium;

import java.util.*;

/**
 * @author Wei
 * @date 2020/9/10 10:01
 *  216. 组合总和III
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }

        // 排序是剪枝的前提
        Deque<Integer> path = new ArrayDeque<>();
        dfs(1, k, n, path, res);
        return res;
    }

    private void dfs(int begin, int size, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() >= size || target <= 0) {
            if (target == 0 && path.size() == size) {
                res.add(new ArrayList<>(path));
                return;
            }
        }

        for (int i = begin; i <= 9; i++) {
            path.addLast(i);
            dfs(i + 1, size, target - i, path, res);
            path.removeLast();
        }
    }

    public static  void main(String[] args) {
        CombinationSumIII c = new CombinationSumIII();
        System.out.println(c.combinationSum3(3,18));
    }
}
