package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/8/3 17:50
 */

// 611. 有效三角形的个数
public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;

        int c = 0;

        Arrays.sort(nums);

        for(int k = nums.length - 1; k > 1; k--){
            int i = 0, j = k - 1;
            while(i < j){
                if(nums[i] + nums[j] > nums[k]){
                    c += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return c;
    }
}
