package Exs;

/**
 * @author Wei
 * @date 2020/4/21 19:02
 * 10 正则表达式匹配
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String a = "a*b";
        System.out.println(isMatchSolution("ab",a));
    }
    public static boolean isMatch(String s, String p) {
        if (s.isBlank()&&p.isBlank())
            return true;

        if (p.equals(".*"))
            return true;

        if (p.startsWith(".*")){
            return s.endsWith(p.substring(2));
        }

        char[] str = s.toCharArray();
        char[] chars = p.toCharArray();
        int strPointer=0;
        int charsPointer=0;
        boolean flag=false;
        while (strPointer<=str.length){
            if (charsPointer==chars.length)
                return false;
            while (strPointer==str.length&&charsPointer<chars.length){
                if (chars[charsPointer]!='*'){
                    if (charsPointer+1<chars.length&&chars[charsPointer+1]=='*'){
                        flag=true;
                        charsPointer=charsPointer+2;
                    }else if (chars[charsPointer]=='.'){
                        return false;
                    }else if (str[str.length-1]==chars[charsPointer]){
                        return charsPointer + 1 == chars.length&&flag&&str.length>1;
                    }
                }
                if (charsPointer==chars.length)
                    return true;
            }

            if (chars[charsPointer]=='.'){
                if (charsPointer+1<chars.length&&chars[charsPointer+1]=='*'){
                    return s.endsWith(p.substring(2));
                }
                charsPointer++;
                strPointer++;
                if (strPointer==str.length&&charsPointer==chars.length)
                    return true;
                flag=false;
                continue;
            }
            if (chars[charsPointer]!='*'){
                if (charsPointer+1<chars.length&&chars[charsPointer+1]=='*'){
                    char temp = chars[charsPointer];
                    while (strPointer<str.length&&str[strPointer]==temp){
                        strPointer++;
                    }
                    charsPointer=charsPointer+2;
                    if (strPointer==str.length&&charsPointer==chars.length)
                        return true;
                    flag=true;
                }else {
                    if (strPointer==str.length)
                        return false;
                    if(chars[charsPointer]==str[strPointer]){
                        strPointer++;
                        charsPointer++;
                        if (charsPointer==chars.length&&strPointer==str.length)
                            return true;
                        flag=false;
                    }else
                        return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isMatchSolution(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatchSolution(text,pattern.substring(2)) ||
                    (first_match && isMatchSolution(text.substring(1),pattern)));
        } else {
            return first_match && isMatchSolution(text.substring(1), pattern.substring(1));
        }
    }

}
