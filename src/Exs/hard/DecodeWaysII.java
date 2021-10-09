package Exs.hard;

/**
 * @author wy
 * @date 2021/9/26 17:24
 */
// 639. 解码方法 II
public class DecodeWaysII {
    public int numDecodings(String s) {
        char last = s.charAt(0);
        int res = last == '*' ? 9 : 1;

        for (int i = 1; i < s.length(); i++) {
            if (i == 0){

            }
        }

        return res;
    }
}
