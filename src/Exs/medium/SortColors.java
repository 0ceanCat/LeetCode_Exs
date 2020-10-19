package Exs.medium;

/**
 * @author Wei
 * @date 2020/10/7 12:40
 * 75. 颜色分类
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int r = 0, w = 0, b =0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                r++;
            else if (nums[i] == 1)
                w++;
            else
                b++;
        }

        for (int i = 0; i < r; i++) {
            nums[i] = 0;
        }

        for (int i = r; i < w + r; i++) {
            nums[i] = 1;
        }

        for (int i = w + r; i < w + r + b; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
