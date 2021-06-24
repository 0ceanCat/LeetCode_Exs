package Exs.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/4/27 19:38
 */
// 633. 平方数之和
public class SumOfSquareNumbers {
    public  boolean judgeSquareSum(int c) {
        if (check(c)) return true;

        for (int i = 1; i <= Math.sqrt(c); i ++) {
            int l = i * i;
            if (check(c - l)) return true;
        }
        return false;
    }


    private boolean check(int num){
        double sqrt = Math.sqrt(num);
        return ((int) sqrt) == sqrt;
    }
}
