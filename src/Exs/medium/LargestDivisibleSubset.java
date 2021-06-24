package Exs.medium;

import java.util.*;

/**
 * @author wy
 * @date 2021/4/22 19:51
 */
public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0) return new ArrayList<>();
        List<Integer>[] dp = new List[n];
        dp[0] = new ArrayList<>();
        dp[0].add(nums[0]);
        List<Integer> ans = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);

            for(int k = 0; k < i; k++){
                if(nums[i] % nums[k] == 0){
                    if(dp[i].size() < dp[k].size() + 1){
                        dp[i] = new ArrayList<>(dp[k]);
                        dp[i].add(nums[i]);
                    }
                }
            }
            if(ans.size() < dp[i].size())   ans = dp[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{4,8,10,240}));

        for (int i = 10; i >= 0; i--){
            System.out.println(i);
        }
    }
}
