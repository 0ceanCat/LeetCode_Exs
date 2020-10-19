package Exs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Wei
 * @date 2020/9/20 9:54
 * 78. 子集
 */
public class Subsets {
    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        LinkedList<Integer> queue = new LinkedList<>();
        dfs(0, nums, res, queue);
        return res;
    }

    private void dfs(int index, int[] nums, List<List<Integer>> res, LinkedList<Integer> queue) {

        for (int i = index; i < nums.length; i++) {
            queue.addLast(nums[i]);
            res.add(new ArrayList<>(queue));
            dfs(i + 1, nums, res, queue);
            queue.removeLast();
        }
    }*/
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }
    public static void main(String[] args) {
        Subsets s = new Subsets();
        s.subsets(new int[]{5,2,9});
    }
}