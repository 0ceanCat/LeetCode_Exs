package Exs.medium;

import java.util.*;

/**
 * @author Wei
 * @date 2020/10/7 12:53
 *  18 四数之和
 */
public class FourSum {
    LinkedList<Integer> dequeue = new LinkedList<>();
    List<List<Integer>> list = new ArrayList<>();
    int res = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null)
            return list;
        Arrays.sort(nums);
        dfs(nums, target, 0);

        return list;
    }

    private void dfs(int[] nums, int target, int start) {

        if (dequeue.size() == 4){
            if (res == target)
                list.add(new ArrayList<>(dequeue));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if(nums.length - i  < 4 - dequeue.size())
                return;

            if(start != i && nums[i - 1] == nums[i])
                continue;

            if(i < nums.length - 1 && res + nums[i] + (3 - dequeue.size()) * nums[i + 1] > target)return;
            if(i < nums.length - 1 && res + nums[i] + (3 - dequeue.size()) * nums[nums.length - 1] < target)continue;

            dequeue.addLast(nums[i]);
            res += nums[i];
            dfs(nums, target, i + 1);
            dequeue.removeLast();
            res -= nums[i];
        }
    }
}
