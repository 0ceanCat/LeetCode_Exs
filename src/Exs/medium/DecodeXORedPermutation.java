package Exs.medium;

/**
 * @author wy
 * @date 2021/5/10 17:03
 */
// 1734. 解码异或后的排列
public class DecodeXORedPermutation {

    public int[] decode(int[] encoded) {
        /*
         * 因为是小于等于n的数，且不会重复，即所有数字在[1,n]中且不重复
         * 设n=5
           则perm=[a,b,c,d,e]
               enco=[f,g,h,i]
           因为n确定，所以可以知道所有数的异或结果
           即a^b^c^d^e的结果是知道的
         * 我们知道的是enco的值，只需要找到perm的随意一个位置的值就可以构造答案
         * 可以发现
           f=a^b
           g=b^c
           h=c^d
           i=d^e
         * 现在知道a^b^c^d^e，可以用g=b^c和i=d^e去消除，只剩下一个a，这样perm就构造出来一个元素，即答案
         */
        int size = encoded.length;
        int n = size + 1;
        int a = 0;
        for (int i = 1; i <= n; i++) {
            a ^= i;
        }
        for (int i = 1; i < n - 1; i += 2 ) {
            a ^= encoded[i];
        }

        int[] ans = new int[n];
        ans[0] = a;
        for (int i = 0; i < size; i++) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(2^4);
        System.out.println(4^1);
        System.out.println(6^5);
    }
}
