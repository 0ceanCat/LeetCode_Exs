package Exs.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wei
 * @date 01/11/2020 19:41
 * 349. 两个数组的交集
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        for (int value : nums1) {
            set.add(value);
        }

        List<Integer> list = new ArrayList<>();

        for (int value : nums2){
            if (set.contains(value)){
                list.add(value);
                set.remove(value);
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
