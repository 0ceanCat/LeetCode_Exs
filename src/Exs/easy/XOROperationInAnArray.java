package Exs.easy;

/**
 * @author wy
 * @date 2021/5/6 18:14
 */
// 1486. 数组异或操作
public class XOROperationInAnArray {
    public int xorOperation(int n, int start) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            res ^= start + 2 * i;
        }

        return res;
    }
}
