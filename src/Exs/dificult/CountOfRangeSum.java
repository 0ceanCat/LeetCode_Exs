package Exs.dificult;

/**
 * @author Wei
 * @date 2020/11/6 22:12
 * 327. 区间和的个数
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        long sum = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= lower && nums[i] <= upper){
                count++;
            }

            sum += nums[i];

            for (int k = i + 1; k < nums.length; k++){
                sum += nums[k];
                if (sum >= lower && sum <= upper){
                    count++;
                }
            }

            sum = 0;
        }

        return count;
    }

    public static void main(String[] args) {
        CountOfRangeSum c = new CountOfRangeSum();
        //System.out.println(c.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864));
        System.out.println(Long.MAX_VALUE);
    }

}
