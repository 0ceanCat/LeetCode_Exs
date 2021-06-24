package Exs.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2021/6/20 18:28
 */
// 401. 二进制手表
public class BinaryWatch {
    List<String> ans=new ArrayList<>();
    int[] a=new int[]{1,2,4,8,1,2,4,8,16,32};

    public List<String> readBinaryWatch(int num) {
        dfs(num,0,0,0);
        return ans;
    }

    void dfs(int cnt, int h, int m, int idx){
        if(cnt == 0) ans.add(h + ":" + ( m > 9 ? m : "0" + m ));

        for(int i = idx; i < a.length && cnt > 0; i++){
            if( i < 4 && h + a[i] < 12) dfs(cnt - 1,h + a[i], m,i + 1);

            if(i >= 4 && m + a[i] < 60) dfs(cnt - 1, h,m + a[i],i + 1 );
        }
    }
    public static void main(String[] args) {
        BinaryWatch binaryWatch = new BinaryWatch();
        binaryWatch.readBinaryWatch(1);
        System.out.println(binaryWatch.ans);
    }
}
