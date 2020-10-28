package Exs.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wei
 * @date 2020/10/28 16:10
 * 1207. 独一无二的出现次数
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.compute(arr[i], (k,v)->{
                if (v == null) return 1;
                return v + 1;
            });
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
}
