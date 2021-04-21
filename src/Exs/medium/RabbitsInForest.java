package Exs.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/4/3 20:15
 */
// 781. 森林中的兔子
public class RabbitsInForest {
    public static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.compute(answer, (k, v) -> v == null ? 1 : v + 1);
        }

        int res = 0;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getKey() == 0) res += e.getValue();
            else
            res += e.getValue() > e.getKey() + 1 ? Math.ceil(e.getValue() / 1.0 / (e.getKey() + 1)) * (e.getKey() + 1) : e.getKey() + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{3,3,3,3,3,3}));
    }
}
