package Exs.medium;

/**
 * @author wy
 * @date 2021/8/30 17:14
 */
// 1109. 航班预订统计
public class CorporateFlightBookings {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for (int[] booking : bookings) {
            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) res[booking[1]] -= booking[2];
        }

        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        corpFlightBookings(new int[][]{{1,2,10}, {2,3,20},{2,5,25} }, 5);
    }
}
