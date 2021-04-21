package Exs.easy;

/**
 * @author wy
 * @date 2021/4/19 17:03
 */
// 28. 实现 strStr()
public class ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        int[] next = getNextArray3(needle.toCharArray());
        int i = 0, j = 0;
        while (i < haystack.length() && j < next.length) {
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
               if (j == 0){
                   i++;
               }else {
                   j = next[j - 1];
               }
            }

            if (j == needle.length()) return i - j;
        }
        return -1;
    }
    // A B A B C A B A A
    // 0 0 1 2 0 1 2 3 1

    // m i s s i s s i p s s i
    // i s s i p
    // 0 0 0 1 0

    // h e l l o
    // l l
    // 0 1

    // a a b a a a b a a a c
    // a a b a a a c
    // 0 1 0 1 2 1 0
    private static int[] getNextArray(char[] chars) {
        int n = chars.length;
        int[] next = new int[n];
        for (int i = 1; i < n; i++){
            if (chars[i] == chars[next[i - 1]])      {
                next[i] = next[i - 1] + 1;
            }else if (i > 2 && chars[i] == chars[next[i - 2]]){
                next[i] = next[i - 1];
            }else if (chars[i] == chars[0]){
                next[i] = 1;
            }
        }

        return next;
    }

    private static int[] getNextArray2(char[] chars){
        int[] next = new int[chars.length];
        int len = 0;
        int i = 1;

        while (i < chars.length){
            if (chars[i] == chars[len]){
                next[i++] = ++len;
            }else {
                if (len > 0 ){
                    len = next[len - 1];
                }else {
                    next[i++] = len;
                }
            }
        }
        return next;
    }

    private static int[] getNextArray3(char[] chars){
        int[] next = new int[chars.length];

        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == chars[next[i - 1]])
                next[i] = next[i - 1] + 1;
            else {
                int j = i - 1;
                while (next[j] > 0 && chars[next[j]] != chars[i])
                    j = next[j] - 1;
                if (next[j] > 0)
                    next[i] = next[j] + 1;
                else {
                    next[i] = (chars[i] == chars[0]) ? 1 : 0;
                }
            }
        }
        return next;
    }
    // adcadde
    public static void main(String[] args) {
        System.out.println(strStr("adcadcaddcadde", "adcadde"));
    }
}