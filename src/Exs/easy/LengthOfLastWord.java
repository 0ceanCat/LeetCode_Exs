package Exs.easy;

/**
 * @author wy
 * @date 2021/9/20 17:32
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') i++;
        int c = 0;
        for (; i >= 0; i--){
            if (s.charAt(i) != ' ') c++;
            else break;
        }

        return c;
    }

    public static void main(String[] args) {
      //  System.out.println(lengthOfLastWord("   a"));
        int i = 0;
        int j = i + i + i + (++i * 2);
        System.out.println(j);
    }
}
