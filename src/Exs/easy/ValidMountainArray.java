package Exs.easy;

/**
 * @author Wei
 * @date 2020/11/2 22:50
 * 941. 有效的山脉数组
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int p1 = 0;
        int p2 = 1;

        while (A[p2] - A[p1] > 0) {
            p1++;
            p2++;
            if (p2 == A.length) {
                return false;
            }
        }

        while (p2 != A.length && A[p2] - A[p1] < 0) {
            if (p1 == 0) {
                return false;
            }
            p1++;
            p2++;
        }

        return p2 == A.length;

    }
}
