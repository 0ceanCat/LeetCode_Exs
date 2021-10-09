package Exs.hard;

import Exs.Utils;

import java.util.*;

/**
 * @author wy
 * @date 2021/7/12 19:07
 */
// 218. 天际线问题
// https://www.bilibili.com/video/BV1yq4y1J73s?from=search&seid=10404826950806563984
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Queue<int[]> points = new PriorityQueue<>((a, b)->{
            int x1 = a[0], y1 = a[1];
            int x2 = b[0], y2 = b[1];
            if (x1 != x2) return x1 - x2;

            return y1- y2;
        });
        //求出左上角和右上角的坐标， 左上角坐标的y存负数
        for(int[] b : buildings){
            points.add(new int[]{b[0], -b[2]});
            points.add(new int[]{b[1], b[2]});
        }

        // 默认的优先队列是小顶堆， 我们需要大顶堆， 每次需要得到队列中最大的元素
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(0);
        int preMax = 0;
        List<List<Integer>> res = new ArrayList<>();

        while (!points.isEmpty()) {
            int[] point = points.poll();
            int x = point[0], y = point[1];

            // 左上角坐标
            if (y < 0) queue.offer(-y);
            // 右上角坐标
            else queue.remove(y);

            int curMax = queue.peek();

            // 最大值更新了，将当前结果加入
            if (curMax != preMax){
                res.add(Arrays.asList(x, curMax));
                preMax = curMax;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TheSkylineProblem t = new TheSkylineProblem();
        t.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});
    }
}
