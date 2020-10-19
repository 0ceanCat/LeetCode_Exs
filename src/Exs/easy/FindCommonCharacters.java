package Exs.easy;

import java.util.*;

/**
 * @author Wei
 * @date 2020/10/14 9:31
 * 1002. 查找常用字符
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] hash = new int[26];

        for (int i = 0; i < A[0].length(); i++) {
            hash[A[0].charAt(i) - 'a']++;
        }

        int[] hashOtherStr = new int[26];
        for (int i = 1; i < A.length; i++) {
            Arrays.fill(hashOtherStr,0);
            for (int j = 0; j < A[i].length(); j++) {
                hashOtherStr[A[i].charAt(j) - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], hashOtherStr[k]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0){
                res.add(String.valueOf((char)(i + 'a')));
                hash[i]--;
            }
        }
        return res;
    }
}
