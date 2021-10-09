package Exs.easy;

/**
 * @author wy
 * @date 2021/8/19 17:12
 */
// 541. 反转字符串 II
public class ReverseStringII {
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        int l = 0, n = chars.length - 1;
        while (l <= n){
            if (n - l + 1 >= 2 * k){
                swap(l,  l + k - 1, chars);
                l += 2 * k;
            }else if (n - l + 1 >= k){
                swap(l, l + k - 1, chars);
                break;
            }else {
                swap(l, n, chars);
                break;
            }
        }

        return new String(chars);
    }

    private static void swap(int l, int r, char[] chars){
        while (l < r){
            char a = chars[l];
            chars[l++] = chars[r];
            chars[r--] = a;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 4));
    }
}
