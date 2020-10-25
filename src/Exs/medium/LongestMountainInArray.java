package Exs.medium;

/**
 * @author Wei
 * @date 2020/10/24 23:05
 * 845. 数组中的最长山脉
 */
public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) return 0;
        return resolver(A, 0);
    }

    private int resolver(int[] a, int start) {
        if (a.length - start < 3) return 0;
        int mid = -1;
        int end = 0;
        for (int i = start; i < a.length - 1; i++) {
            if (a[i] >= a[i + 1]){
                mid = i;
                break;
            }
        }
        if (mid == -1) return 0;
        if (mid == start) return resolver(a, start + 1);

        for (int i = mid + 1; i < a.length; i++) {
            if (a[i] >= a[i - 1]){
                if (i - start >= 3){
                    return Math.max(i - start, resolver(a, i - 1));
                }
                return resolver(a, i);
            }
            end = i;
        }

        return end - start + 1;
    }

}
