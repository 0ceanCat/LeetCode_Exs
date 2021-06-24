package Exs.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/5/1 18:07
 */
// 554. 砖墙
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> preFixSumCount = new HashMap<>();
        int maxCount = 0;
        for (List<Integer> list: wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                int count = preFixSumCount.getOrDefault(sum, 0) + 1;
                preFixSumCount.put(sum, count);
                maxCount = Math.max(maxCount, count);
            }
        }
        return wall.size() - maxCount;
    }
}
