package Exs.medium;

import java.util.*;

/**
 * @author wy
 * @date 06/03/2021 19:25
 */
// 131. 分割回文串
public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return res;
        dp = new boolean[s.length()][s.length() + 1];
        dfs(s, 0, new LinkedList<>());
        return res;
    }

    public void dfs(String s, int start,  LinkedList<String> list){
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; start + i <= s.length(); i++) {
            if (!check(0, 0, s.substring(start, start + i))) {
                continue;
            }
            list.addLast(s.substring(start, start + i));
            dfs(s, start + i, list);
            list.removeLast();
        }

    }

    public boolean check(int start, int end, String s){
        if (s.length() == 0 || dp[start][end]) return true;
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
       PalindromePartitioning partitioning = new PalindromePartitioning();
       System.out.println(partitioning.partition("abbab"));
    }
}
