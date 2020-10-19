package Exs.medium;

import java.util.Arrays;

/**
 * @author Wei
 * @date 2020/10/11 9:35
 * 416. 分割等和子集
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        int partition=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }
        partition=sum/2;

        if(nums[nums.length-1]>partition){
            return false;
        }else if(nums[nums.length-1]==partition){
            return true;
        }

        partition=partition-nums[nums.length-1];

        for (int i = nums.length-1; i >= 0 ; i--) {
            if(nums[i]<=partition){
                int copy=partition;
                copy-=nums[i];
                if(copy==0){
                    return true;
                }
                for (int j = i-1; j >= 0; j--) {
                    if(nums[j]<=copy) {
                        copy -= nums[j];
                        if (copy == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(new int[]{2,2,3,5}));
    }
}
