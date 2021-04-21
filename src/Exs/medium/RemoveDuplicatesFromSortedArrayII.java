package Exs.medium;

/**
 * @author wy
 * @date 2021/4/5 20:55
 */
// 80. 删除有序数组中的重复项 II
public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int last = 1, i = 1;

        while (i < nums.length){
            int v = nums[last - 1];
            nums[last] = nums[i];
            last++;

            if (v == nums[i++]){
                while(i < nums.length){
                    if (v != nums[i]) break;
                    i++;
                }
            }
        }

        return last;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }
}
