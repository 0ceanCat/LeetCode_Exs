package Exs.medium;

/**
 * @author wy
 * @date 2021/9/29 21:51
 */
// 223. 矩形面积
// https://leetcode-cn.com/problems/rectangle-area/solution/jian-dan-de-kao-lu-by-powcai/
public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 调整两个矩形位置, 让第一个矩形靠最左边
        if (ax1 > bx1)
            return computeArea(bx1, by1, bx2, by2, ax1, ay1, ax2, ay2);
        // 没有重叠的情况
        if (ay1 >= by2 || ay2 <= by1 || ax2 <= bx1)
            return Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2) + Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        // 重叠情况
        // 左
        int left = Math.max(ax1, bx1);
        // 右
        int right = Math.min(ax2, bx2);
        // 下
        int down = Math.max(ay1, by1);
        // 上
        int up = Math.min(ay2, by2);
        return Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2) + Math.abs(bx1 - bx2) * Math.abs(by1 - by2)
                -
                Math.abs(up - down) * Math.abs(left - right);
    }
}
