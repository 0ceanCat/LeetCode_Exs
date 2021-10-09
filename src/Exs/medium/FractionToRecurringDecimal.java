package Exs.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/10/2 17:13
 */
// 166. 分数到小数
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        boolean negative = (numerator > 0) ^ (denominator > 0);
        if (negative) res.append("-");

        long num = numerator;
        long de = denominator;
        num = Math.abs(num);
        de = Math.abs(de);

        long in = num / de;
        res.append(in);

        long re = num % de;
        if (re == 0) return res.toString();
        else res.append(".");

        Map<Long, Integer> map = new HashMap<>();
        int idx = res.length() - 1;
        while (re > 0) {
            idx++;
            re *= 10;
            if (map.get(re) != null) {
                res.insert(map.get(re), "(");
                res.append(")");
                break;
            } else map.put(re, idx);
            res.append(re / de);
            re = re % de;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(2.0 /3);
    }
}
