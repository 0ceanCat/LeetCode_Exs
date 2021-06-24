package Exs.hard;

import java.util.*;

/**
 * @author wy
 * @date 2021/6/23 19:57
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        Map<String, Set<String>> map = new HashMap<>();
        var max = 0;

        for (var i = 0; i < n; i++) {
            if (max >= n - i || max > n / 2) {
                break;
            }

            for (int j = i + 1; j < n; j++){
                String formula = getFormula(points[i], points[j]);
                if (formula.equals("")) continue;

                Set<String> set = map.get(formula);
                if (set != null){
                    map.get(formula).add(points[j][0] + "," + points[j][1]);
                }else{
                    set = new HashSet<>();
                    set.add(points[i][0] + "," + points[i][1]);
                    set.add(points[j][0] + "," + points[j][1]);
                    map.put(formula, set);
                }

                max = Math.max(max, map.get(formula).size());
            }
        }
        return max;
    }

    private String getFormula(int[] p1, int[] p2){
        if (p1[0] == p2[0]){
            return "$" + p1[0];
        }
        double m = (p2[1] - p1[1]) * 1.0 / (p2[0] - p1[0]);

        if (m == -0.0) m = 0.0;

        double b = p1[1] - m * p1[0];
        if (b == -0.0) b = 0.0;

        return m + "," + b;
    }
}
