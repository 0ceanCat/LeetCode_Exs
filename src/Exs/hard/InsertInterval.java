package Exs.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wei
 * @date 2020/11/3 17:17
 * 57. 插入区间
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }
        int[] tmp = new int[]{newInterval[0], newInterval[1]};
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            tmp[0] = Math.min(tmp[0], intervals[i][0]);
            tmp[1] = Math.max(tmp[1], intervals[i][1]);
            i++;
        }
        res.add(tmp);
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        int[][] newintervals = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            newintervals[k] = res.get(k);
        }
        return newintervals;
    }

    public static void main(String[] args) {
        InsertInterval i = new InsertInterval();
        int[][] a = new int[][]{{1,3},{6,9}};
        int[] b = new int[]{2,5};
        i.insert(a, b);
    }
}
