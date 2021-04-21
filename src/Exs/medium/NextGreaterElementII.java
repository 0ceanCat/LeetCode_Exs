package Exs.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wy
 * @date 05/03/2021 16:15
 */
// 503. 下一个更大元素 II
public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        Arrays.fill(res, -1);
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < n*2; i++){
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peek()]){
                res[stack.pop()] = num;
            }
            if(i < n) stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{2,1,2,4,3,5,6})));

    }
}
