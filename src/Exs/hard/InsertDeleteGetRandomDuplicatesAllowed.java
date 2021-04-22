package Exs.hard;

import java.util.*;

/**
 * @author Wei
 * @date 2020/10/30 19:03
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 */
public class InsertDeleteGetRandomDuplicatesAllowed {
    static class RandomizedCollection{
        Map<Integer, Set<Integer>> indices = new HashMap<>();
        List<Integer> datas = new ArrayList<>();

        /** Initialize your data structure here. */
        public RandomizedCollection() {
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            Set<Integer> set = indices.getOrDefault(val, new HashSet<Integer>());
            datas.add(val);
            set.add(datas.size() - 1);
            indices.put(val, set);
            return set.size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!indices.containsKey(val)) return false;

            Set<Integer> set = indices.get(val);

            int valIndex = set.iterator().next();

            int last = datas.get(datas.size() - 1);

            datas.set(valIndex, last);

            set.remove(valIndex);

            Set<Integer> lastSet = indices.get(last);

            lastSet.remove(datas.size() - 1);

            if (valIndex != datas.size() - 1) {
                lastSet.add(valIndex);
            }

            datas.remove(datas.size() - 1);

            if (set.size() == 0) {
                indices.remove(val);
            }

            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return datas.get(new Random().nextInt(datas.size()));
        }
    }
}
