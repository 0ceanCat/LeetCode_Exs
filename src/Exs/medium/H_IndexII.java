package Exs.medium;

/**
 * @author wy
 * @date 2021/7/11 17:10
 */
// 275. H 指数 II
public class H_IndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int l = 0, r = n - 1;
        int h = 0;
        while(l <= r){
            int mid = l + (r - l ) / 2;

            if (citations[mid] >= n - mid){
                h = Math.max(h, n - mid);
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return h;
    }

    public static void main(String[] args) {
        H_IndexII h = new H_IndexII();
        System.out.println(h.hIndex(new int[]{11, 15}));
    }
}
