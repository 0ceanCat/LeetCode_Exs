package Exs.easy;

/**
 * @author wy
 * @date 2021/8/18 17:02
 */
public class ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int l = 0, r = chars.length - 1;
        while (l <= r){
            if (isVowel(chars[l])){
                while (!isVowel(chars[r])) r--;
                char a = chars[l];
                chars[l] = chars[r];
                chars[r--] = a;
            }
            l++;
        }

        return new String(chars);
    }

    private static boolean isVowel(char c){
        return c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e'
                || c == 'A' || c == 'I' || c == 'O' || c == 'U' || c == 'E' ;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}
