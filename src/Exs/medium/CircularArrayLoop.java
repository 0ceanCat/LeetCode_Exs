package Exs.medium;

import Exs.Utils;

/**
 * @author wy
 * @date 2021/8/6 18:46
 */
// 457. Circular Array Loop
public class CircularArrayLoop {
    public static int getNext(int[] nums, int index) {
        int N = nums.length;
        return ((index + nums[index]) % N + N) % N;
    }

    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length; //数组长度
        for(int i = 0; i < n; ++i) //遍历每一个节点
        {
            if(nums[i] == 0) continue;
            //慢指针定义为当前节点index，快指针先走一步到下一个index
            int slow = i, fast = getNext(nums, slow);
            // 相当于解析中的 a，之后任何数与 sign 相乘都必须大于 0
            int sign = nums[slow];
            // 如果有不同的方向则为 true，初始为 false
            boolean diff = false;
            while(slow != fast)
            {
                //慢指针走一步
                slow = getNext(nums, slow);

                //检测最开始的快指针是否与 sign 相乘小于0 （也检测上一个循环)
                if(nums[fast] * sign < 0)
                {
                    diff = true;
                    break;
                }
                fast = getNext(nums, fast);
                //检测刚才那一步的快指针是否方向与 a 相同
                if(nums[fast] * sign < 0)
                {
                    diff = true;
                    break;
                }
                fast = getNext(nums, fast);
            }

            //如果方向不同那么检测下一个节点
            //这一步是防止一个节点的单循环，案例 [1]，必须要有两个以上的节点！
            if(diff || slow == getNext(nums, slow)){
                int val = i;
                while (nums[val] * nums[getNext(nums, val)] > 0) {
                    int temp = val;
                    val = getNext(nums, val);
                    nums[temp] = 0;
                }
                continue;
            }
            //以上两个都不满足则说明有环，返回true
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        circularArrayLoop(new int[]{1,1,2});
    }
}
