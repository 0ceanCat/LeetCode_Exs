package Exs.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wei
 * @date 2020/8/22 13:34
 * 679. 24 点游戏
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 */
public class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }
    boolean solve(List<Double> nums){
        if(nums.size() == 1){
            return Math.abs(nums.get(0) - 24) <= 0.00001;
        }
        for(int i = 0; i < nums.size(); i++){
            for(int j = i + 1; j < nums.size(); j++){
                List<Double> copy = new ArrayList<>(nums);
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;
                copy.add(a + b);
                valid = solve(copy);
                copy.set(copy.size() - 1, a - b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a * b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, a / b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b - a);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b / a);
                valid |= solve(copy);
                if(valid) return true;
            }
        }
        return false;
    }
}
