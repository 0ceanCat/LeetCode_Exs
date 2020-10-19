package Exs.easy;

import java.util.StringJoiner;

/**
 * @author Wei
 * @date 2020/8/30 14:01
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.length; i++){
            String str = strs[i];
            for (int k = str.length() - 1; k >= 0; k--) {
                sb.append(str.charAt(k));
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
