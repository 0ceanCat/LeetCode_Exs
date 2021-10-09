package Exs.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wy
 * @date 2021/9/13 18:25
 */
// 524. 通过删除字母匹配到字典里最长单词
public class LongestWordInDictionaryThroughDeleting {
    public static String findLongestWord(String s, List<String> dictionary) {
        String res = null;
        for (String k : dictionary) {
            if (s.length() < k.length()) continue;

            for (int i = 0, j = 0; i < k.length() && j < s.length(); i++, j++) {
                while (j < s.length() && k.charAt(i) != s.charAt(j)) j++;
                if (i == k.length() - 1 && j < s.length()){
                    if (res == null || k.length() > res.length() || (k.length() == res.length() && k.compareTo(res) < 0)) res = k;
                }
            }
        }

        return res == null ? "" : res;
    }

    public static void main(String[] args) {
        findLongestWord("apple", Arrays.asList("zxc","vbn"));
    }
}
