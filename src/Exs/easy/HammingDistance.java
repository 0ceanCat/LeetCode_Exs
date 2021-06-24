package Exs.easy;

/**
 * @author wy
 * @date 2021/5/26 17:12
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int c = x ^ y;
        int countx = 0;
        while(c != 0) {
            countx++;
            c = c & (c-1);
        }
        return countx;
        //return Integer.bitCount(x ^ y);
    }


}
