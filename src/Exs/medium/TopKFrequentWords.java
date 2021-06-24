package Exs.medium;

import java.util.*;

/**
 * @author wy
 * @date 2021/5/19 21:16
 */
// 692. 前K个高频单词
public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.compute(word, (key,value)->{
                if (value == null) return 1;
                return value + 1;
            });
        }

        PriorityQueue<Map.Entry> queue = new PriorityQueue<>((o1, o2) -> {
            int v1 = (int) o1.getValue();
            int v2 = (int) o2.getValue();
            if (v1 == v2)
                return ((String)o1.getKey()).compareTo((String) o2.getKey());
            return -Integer.compare(v1, v2);
        });

        for (Map.Entry<String, Integer> set : map.entrySet()) {
            queue.add(set);
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            list.add((String)queue.poll().getKey());
        }

        return list;
    }

    public static void main(String[] args) {
        topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }
}
