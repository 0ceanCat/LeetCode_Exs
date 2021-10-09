package Exs.easy;

/**
 * @author wy
 * @date 2021/7/23 17:49
 */
public class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        LatestTimeByReplacingHiddenDigits l = new LatestTimeByReplacingHiddenDigits();
        l.maximumTime("25:50");
    }
}
