package Exs.easy;

/**
 * @author Wei
 * @date 2020/8/14 10:47
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses s = new ValidParentheses();
        System.out.println(s.isValid("(}{"));
    }
    public boolean isValid(String s) {
        if (s.length()%2!=0)
            return false;

        char[] lasts = new char[s.length()/2];
        int pointer = 0 ;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{'){
                if (pointer == lasts.length)
                    return false;
                lasts[pointer++] = ch;
                continue;
            }
            if (pointer == 0)
                return false;
            if (ch == ')'){
                if (lasts[pointer-1] != '(')
                    return false;
                pointer--;
            }else if (ch == '}'){
                if (lasts[pointer-1] != '{')
                    return false;
                pointer--;
            }else if (ch == ']'){
                if (lasts[pointer-1] != '[')
                    return false;
                pointer--;
            }
        }
        return pointer == 0;
    }

}
