package Exs.medium;

import java.util.*;

/**
 * @author wy
 * @date 2021/10/7 19:55
 */

// https://leetcode-cn.com/problems/repeated-dna-sequences/solution/zhong-fu-de-dnaxu-lie-by-leetcode-soluti-z8zn/
public class RepeatedDnaSequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> bin = new HashMap<>() {{
            put('A', 0);  // 用二进制00表示A
            put('C', 1); // 用二进制01表示C
            put('G', 2); // 用二进制10表示G
            put('T', 3); // 用二进制11表示T
        }};
        Set<Integer> strings = new HashSet<>();
        Set<String> duplicated = new HashSet<>();
        int x = 0;
        for (int i = 0; i < 9; ++i) {
            x = (x << 2) | bin.get(s.charAt(i)); //左移来空出2位给新的字符
        }

        int i = 0 ;
        while (i + 10 <= s.length()){
            x = ((x << 2) | bin.get(s.charAt(i + 9))) & ((1 << 20) - 1); // x & ((1 << 20) - 1) 可以只保留低20位的数据，剩下的全部置0
            if (!strings.add(x)) {
                duplicated.add(s.substring(i, i + 10));
            }
            i++;
        }

        return new ArrayList<>(duplicated);
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));

        System.out.println(Integer.toBinaryString(256 + 512 - 1));
    }
}
