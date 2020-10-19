package Exs.easy;

/**
 * @author Wei
 * @date 2020/8/24 9:54
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        RepeatedSubstringPattern r = new RepeatedSubstringPattern();
        System.out.println(r.repeatedSubstringPattern("abc"));

    }
    public boolean repeatedSubstringPattern(String s) {
        if (s == null)
            return false;

        int len = s.length();

        for (int i = 1; i <= len; i++){
            if (len % i == 0 && check(s,i))
                return true;
        }
        return false;
    }

    private boolean check(String s, int i) {

        String str = s.substring(0,i);
        int len = s.length();

        for (int k = i; k <= len - i; k += i){
            if (!str.equals(s.substring(k,k + i)))
                return false;
        }
        return true;
    }
}
