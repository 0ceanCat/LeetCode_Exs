package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/3/2 17:09
 */
// 338. 比特位计数
public class CountingBits {
    /*static int lastPow = 0;
    public static int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        int[] counts = new int[num + 1];
        counts[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0){
                counts[i] = countBitEven(i, counts);
            }else{
                counts[i] = countBitEven(i - 1, counts) + 1;
            }
        }
        return counts;
    }

    public static int countBitEven(int even, int[] counts){
        if ((even & (even - 1)) == 0){
            lastPow = even;
            return 1;
        };
        return counts[lastPow] + counts[even - lastPow];
    }*/

    public static int[] countBits(int num) {
        int[] counts = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0){
                counts[i] = counts[i / 2];
            }else{
                counts[i] = counts[i - 1] + 1;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
