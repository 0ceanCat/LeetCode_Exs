package Exs.medium;

/**
 * @author Wei
 * @date 2020/10/23 23:27
 * 1024. 视频拼接
 */
public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[101];
        int mx = 0, ans = 0, pre = 0;
        for (int[] clip: clips) {
            dp[clip[0]] = Math.max(dp[clip[0]], clip[1]);
        }
        for (int i = 0; i < T; i++) {
            mx = Math.max(mx, dp[i]);
            if (i == pre) {
                ans++;
                pre = mx;
            }
            if (i == mx) return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        VideoStitching v = new VideoStitching();
        int[][] ints = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        v.videoStitching(ints, 10);
    }
}
