package Exs.medium;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author Wei
 * @date 2020/9/10 10:01
 *  40. 组合总和
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return new ArrayList<>();
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i + 1, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        System.out.println(c.combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
