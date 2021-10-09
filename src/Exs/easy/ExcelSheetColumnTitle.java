package Exs.easy;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/6/28 17:40
 */
// 168. Excel表列名称
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        StringBuffer sb=new StringBuffer();
        Stack<Character> s=new Stack<>();

        for(; n>0; n /= 26) {
            s.push((char)((--n) % 26 + 'A'));
        }
        while(!s.empty())sb.append(s.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }
}
