package Exs.hard;

/**
 * @author wy
 * @date 2021/4/8 21:05
 */
public class FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 3, 3}));
    }
}
