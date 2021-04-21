package Exs.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wy
 * @date 2021/4/11 17:46
 */
// 179. 最大数
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsToWord = new String[n];
        for(int i=0;i<n;i++){
            numsToWord[i] = String.valueOf(nums[i]);
        }
        //[233，23333]排序后变为[23333，233]
        Arrays.sort(numsToWord,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(numsToWord[i]);
        }
        String res = sb.toString();
        return res.charAt(0)=='0'?"0":res;
    }

}
