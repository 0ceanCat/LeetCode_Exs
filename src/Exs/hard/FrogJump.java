package Exs.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author wy
 * @date 2021/4/28 17:45
 */
// 403. 青蛙过河
public class FrogJump {
    public static boolean canCross(int[] stones) {
        for (int stone : stones) {
            crossed.put(stone, new HashSet<>());
        }
        return dfs(stones,0, 0);
    }

    static Map<Integer,HashSet<Integer>> crossed = new HashMap<>();
    static boolean finish = false;
    private static boolean dfs(int[] stones, int k, int index) {
        if (index == stones.length - 1){
            finish = true;
            return true;
        }

        if (crossed.get(stones[index]).contains(k)) return false;

        crossed.get(stones[index]).add(k);
        int ns = stones[index] + k;

        boolean r = false;

        for(int i = index; i < stones.length; i++){
            if (finish) return true;
            if (stones[i] == ns - 1
                    || stones[i] == ns
                    || stones[i] == ns + 1){
                r |= dfs(stones, stones[i] - ns + k, i);
            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0,1,2,3,6,7,8,11}));
    }
}
