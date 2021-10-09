package Exs.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2021/8/15 17:53
 */
// 526. 优美的排列
public class BeautifulArrangement {
    public int countArrangement(int n) {
        return dfs(n, 1, 0);
    }

    private int dfs(int n, int curr, int visited){
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (curr % i == 0 || i % curr == 0){
                int temp = visited;
                visited |= 1 << i;
                if (temp == visited) continue;

                if (curr == n) {
                    return 1;
                }

                res += dfs(n, curr + 1, visited);
                visited = temp;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BeautifulArrangement b = new BeautifulArrangement();
        b.countArrangement(2);
        // 1 2 3, 2 1 3, 3 2 1
    }
}
