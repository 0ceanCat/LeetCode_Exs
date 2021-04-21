package Exs.medium;

/**
 * @author wy
 * @date 2021/4/7 17:32
 */
// 153. 寻找旋转排序数组中的最小值
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,1,2}));
    }
}
