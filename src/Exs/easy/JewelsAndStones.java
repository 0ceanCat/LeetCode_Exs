package Exs.easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wei
 * @date 2020/10/2 9:29
 * 771. 宝石与石头
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i)))
                res++;
        }

        return res;
    }
}
