package Exs.medium;

/**
 * @author Wei
 * @date 2020/8/19 10:15
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for(int i=0;i<n;++i){
            res = midextend(s,i,i,res,n);
            res = midextend(s,i,i+1,res,n);
        }
        return res;
    }
    public int midextend(String s,int i,int j,int res,int n){
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
            --i;
            ++j;
            ++res;
        }
        return res;
    }
}
