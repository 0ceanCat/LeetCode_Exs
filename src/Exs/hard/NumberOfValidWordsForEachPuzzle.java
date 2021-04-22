package Exs.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WY 2021/2/25
 */
// 1178. 猜字谜
public class NumberOfValidWordsForEachPuzzle {
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();

        // 2^26的数组会爆内存。因此用HashMap，存放每种状态的个数
        Map<Integer, Integer> state = new HashMap<>();
        for (String s : words) {
            int temp = 0;
            for (int j = 0; j < s.length(); j++) {
                temp = temp | (1 << s.charAt(j) - 'a');
            }
            state.put(temp, state.getOrDefault(temp, 0) + 1);
        }

        for (String s : puzzles) {
            int temp = 0;
            for (int j = 0; j < s.length(); j++) {
                temp = temp | (1 << s.charAt(j) - 'a');
            }
            int cnt = 0;
            // 枚举子集
            for (int k = temp; k != 0; k = (k - 1) & temp) {
                // 还得满足条件一
                if ((1 << (s.charAt(0) - 'a') & k) != 0) cnt += state.getOrDefault(k, 0);
            }
            res.add(cnt);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        System.out.println(findNumOfValidWords(words, puzzles));
    }
}
