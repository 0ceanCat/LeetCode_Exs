package Exs.medium;

import java.util.*;

/**
 * @author wy
 * @date 2021/7/9 17:49
 */
// 981. 基于时间的键值存储
public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        Map.Entry<Integer, String> entry = map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
