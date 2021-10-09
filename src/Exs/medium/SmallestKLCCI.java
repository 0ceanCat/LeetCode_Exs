package Exs.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2021/9/2 17:58
 */
public class SmallestKLCCI {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> - (a - b));

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++){
            if (arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestKLCCI s = new SmallestKLCCI();

        s.smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
    }
}
