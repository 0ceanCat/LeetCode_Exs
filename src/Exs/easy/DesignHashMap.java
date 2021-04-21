package Exs.easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author wy
 * @date 2021/3/13 17:34
 */
public class DesignHashMap {
    static class MyHashMap {
        private static final int BASE = 769;
        LinkedList[] map;

        /** Initialize your data structure here. */
        public MyHashMap() {
            map = new LinkedList[BASE];
            Arrays.fill(map, new LinkedList<>());
        }

        public void put(int key, int value) {
            int h = hash(key);
            for (Node k : (Iterable<Node>) map[h]) {
                if (k.key == key) {
                    k.value = value;
                    return;
                }
            }
            map[h].add(new Node(key, value));
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int h = hash(key);
            for (Node k : (Iterable<Node>) map[h]) {
                if (k.key == key) {
                    return k.value;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int h = hash(key);
            Iterator<Node> iterator = map[h].iterator();
            while (iterator.hasNext()){
                if (iterator.next().key == key){
                    iterator.remove();
                    return;
                }
            }
        }

        int hash(int key){
            return key % 769;
        }

        private class Node{
            int key;
            int value;
            Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
    }
}

