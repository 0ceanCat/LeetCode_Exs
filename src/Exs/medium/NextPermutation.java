package Exs.medium;

/**
 * @author Wei
 * @date 2020/11/10 10:35
 * 31. 下一个排列
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int len = nums.length;

        int i = len - 2, j = len - 1, k = len - 1;

        while (i >= 0 && nums[i] >= nums[j]){
            i--;
            j--;
        }

        if (i >= 0){
            while (nums[i] >= nums[k]){
                k--;
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }

        for (i = j, j = len - 1; i < j; i++ ,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        n.nextPermutation(new int[]{1,2,4,5,3});
    }
}
