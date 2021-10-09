package Exs.easy;

/**
 * @author wy
 * @date 2021/9/6 22:58
 */
// 1221. 分割平衡字符串
public class SplitAstringInBalancedStrings {
    public static int balancedStringSplit(String s) {
        int res = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                count++;
            } else {
                count--;
            }
            if (count == 0) res++;
        }
        return res;
    }

}
