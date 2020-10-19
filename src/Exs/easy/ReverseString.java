package Exs.easy;

/**
 * @author Wei
 * @date 2020/10/8 13:45
 * 344. 反转字符串
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int start = 0;
        int last = s.length - 1;

        while (start < last){
            char temp = s[start];
            s[start] = s[last];
            s[last] = temp;
            start++;
            last--;
        }
    }
}
