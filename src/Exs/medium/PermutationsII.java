package Exs.medium;

import java.util.*;

/**
 * @author Wei
 * @date 2020/9/17 17:57
 * 47. 全排列 II
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums.length == 0) {
            return result;
        }

        Deque<Integer> deque = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        dfs(nums, result, deque, used);

        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, Deque<Integer> queue, boolean[] used) {
        if (queue.size() == nums.length){
            result.add(new ArrayList<>(queue));
            return;
        }

        for (int k = 0; k < nums.length; k++) {
            if (used[k])
                continue;
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (k > 0 && nums[k] == nums[k - 1] && !used[k - 1]) {
                continue;
            }
            queue.addLast(nums[k]);
            used[k] = true;
            dfs(nums,result,queue,used);
            queue.removeLast();
            used[k] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        System.out.println(p.permuteUnique(new int[]{1,1,2}));
    }

}
