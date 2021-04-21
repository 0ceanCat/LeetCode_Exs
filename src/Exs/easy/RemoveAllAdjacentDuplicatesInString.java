package Exs.easy;

import java.util.Stack;

/**
 * @author wy
 * @date 08/03/2021 16:03
 */
// 1047. 删除字符串中的所有相邻重复项
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString s = new RemoveAllAdjacentDuplicatesInString();
        s.removeDuplicates("abbaca");
    }
}
