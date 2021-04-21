package Exs.dificult;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/4/1 21:34
 */
// 面试题 17.21. 直方图的水量
public class VolumeOfHistogramLCCI {
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int water = 0;
        //特殊情况
        if(height.length <3){
            return 0;
        }
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                //栈顶元素
                int popnum = stack.pop();
                //相同元素的情况例1，1
                while(!stack.isEmpty()&&height[popnum] == height[stack.peek()]){
                    stack.pop();
                }
                //计算该层的水的单位
                if(!stack.isEmpty()){
                    int temp = height[stack.peek()];//栈顶元素值
                    //高
                    int hig = Math.min(temp-height[popnum],height[i]-height[popnum]);
                    //宽
                    int wid = i-stack.peek()-1;
                    water +=hig * wid;
                }

            }
            //这里入栈的是索引
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
