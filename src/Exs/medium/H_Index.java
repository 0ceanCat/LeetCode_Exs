package Exs.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author wy
 * @date 2021/7/10 17:42
 */
// 274. H 指数
public class H_Index {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int l = 0, r = n;

        while(l < r){
            int mid = (l + r + 1) / 2;  //+1是为了避免当n=1时，程序陷入死循环
            int t = 0;
            for(int x : citations){
                if(x >= mid) t++;
            }
            if(t < mid) r = mid - 1;  //此时答案不满足，收缩右边界
            else l = mid;    //此时满足，扩大左边界
        }
        return l;

    }

    public static void main(String[] args) {
        H_Index h = new H_Index();
        System.out.println(h.hIndex(new int[]{3,0,6,7,7,1,5}));
    }
}
