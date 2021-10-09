package Exs.easy;

import Exs.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author wy
 * @date 2021/7/22 17:01
 */
// 1893. 检查是否区域内所有整数都被覆盖
public class CheckIfAllTheIntegersInARangeAreCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {// 计算查分数组diff：每个数字相对于前一个数字被多覆盖的区间数量
        int[] diff = new int[52];
        for(int[] range: ranges){
            diff[range[0]] ++;
            diff[range[1] + 1] --;
        }
        // 通过累加和可知各个数字被覆盖的区间数量
        // 此处遍历范围之所以不是[left, right]，是因为求各数字被覆盖区间数必须从头累加
        // 含义：若当前数字在[left, right]区间内，且覆盖区间数量为0则返回false
        int curr = 0;
        for(int i = 1; i <= 50; i ++){
            curr += diff[i];
            if(i >= left && i <= right && curr <= 0){   // 实际上curr最多等于0，不会小于0
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfAllTheIntegersInARangeAreCovered c = new CheckIfAllTheIntegersInARangeAreCovered();
        c.isCovered(new int[][]{{0,1},{2,3},{4,5},{6,7}}, 35, 40);
    }
}
