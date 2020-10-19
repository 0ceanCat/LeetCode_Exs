package Exs.medium;

import java.util.*;

/**
 * @author Wei
 * @date 2020/9/7 9:50
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        int[] result = new int[k];
        int count = 0;
        while (!pq.isEmpty()){
            result[count++] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements k = new TopKFrequentElements();
        System.out.println(Arrays.toString(k.topKFrequent(new int[]{1,2},2)));
    }
}
