package Exs.easy;

import java.util.Stack;

/**
 * @author Wei
 * @date 2020/10/18 22:20
 * 844. 比较含退格的字符串
 */
public class BackspaceStringCompare {
   /* public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = build(S);
        Stack<Character> s2 = build(T);
        if (s1.size() != s2.size()) return false;
        int size = s1.size();
        for (int i = 0; i < size; i++) {
            if (s1.pop() != s2.pop()) return false;
        }

        return true;
    }

    private Stack<Character> build(String T) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#'){
                stack.push(T.charAt(i));
            }else{
                if (!stack.isEmpty())
                    stack.pop();
            }
        }
        return stack;
    }*/

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String T) {
        StringBuilder sb = new StringBuilder();
        int cardinal = 0;
        for (int i = T.length() - 1; i >= 0; i--) {
            if (T.charAt(i) != '#' && cardinal == 0) {
                sb.append(T.charAt(i));
            } else if (T.charAt(i) == '#') {
                cardinal++;
            } else if (T.charAt(i) != '#' && cardinal > 0) {
                cardinal--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        System.out.println(b.backspaceCompare("a#c", "b"));
    }
}
