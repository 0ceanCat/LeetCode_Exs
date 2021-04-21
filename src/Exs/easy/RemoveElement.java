package Exs.easy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wy
 * @date 2021/4/18 21:42
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int i = 0;
        int c = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (i < nums.length){
           if (nums[i++] != val){
               nums[queue.poll()] = nums[i - 1];
               c++;
           }
           queue.offer(i);
        }
        return c;
    }
}
