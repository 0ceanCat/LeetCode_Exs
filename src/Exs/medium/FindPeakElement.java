package Exs.medium;

/**
 * @author wy
 * @date 2021/9/14 17:48
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums.length > 1 && nums[0] > nums[1]) return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && ( i == nums.length - 1 || nums[i] > nums[i + 1]) || i == nums.length - 1){
                return i;
            }

            if (nums[i] > nums[i + 1]){
                i++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(String[].class.getClassLoader());
    }
}
