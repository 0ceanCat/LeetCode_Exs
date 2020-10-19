package Exs.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wei
 * @date 2020/9/1 10:16
 * 486. 预测赢家
 */
public class PredictTheWinner {
    int[] nums;
    public boolean PredictTheWinner(int[] nums) {
        this.nums = nums;
        int left = 0, right = nums.length - 1;
        //false 玩家B， true 玩家A
        return dfs(left + 1 , right, nums[left], 0, false)
                || dfs(left, right - 1, nums[right], 0, false);
    }

    private boolean dfs(int left, int right, int sumA, int sumB ,boolean flag) {
        if (left == right){
            if (flag)
                return sumA + nums[left] > sumB;
            else
                return sumA > sumB + nums[left];
        }

        if (flag){
            return dfs(left + 1 , right, sumA + nums[left], sumB, false) ||
                    dfs(left , right - 1, sumA + nums[right], sumB, false);
        }
        else{
            return dfs(left + 1 , right, sumA, sumB + nums[left], true) ||
                    dfs(left , right - 1, sumA, sumB + nums[right], true);

        }
    }

    public static void main(String[] args) {
        PredictTheWinner p = new PredictTheWinner();
        System.out.println(p.PredictTheWinner(new int[]{1,5,2}));
    }
}
