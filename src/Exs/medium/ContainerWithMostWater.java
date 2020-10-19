package Exs.medium;

/**
 * @author Wei
 * @date 2020/8/28 18:58
 * 11. 盛最多水的容器
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

}
