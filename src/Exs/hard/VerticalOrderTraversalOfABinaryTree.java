package Exs.hard;

import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

/**
 * @author wy
 * @date 2021/7/30 17:07
 */
// 987. 二叉树的垂序遍历
public class VerticalOrderTraversalOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> map = new TreeMap<>();

        dfs(map, root,0, 0);

        List<List<Integer>> res = new ArrayList<>();
        map.forEach((x,y)->{
            Collections.sort(y, (o1, o2) -> {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            });
            List<Integer> l = new ArrayList<>();
            for (int[] ints : y) {
                l.add(ints[1]);
            }
        });

        return res;
    }

    private void dfs(Map<Integer, List<int[]>> map, TreeNode curr, int line, int column) {
        if (curr == null) return;

        map.computeIfAbsent(column, k -> new ArrayList<>()).add(new int[]{line, curr.val});

        dfs(map, curr.left, line + 1, column - 1);
        dfs(map, curr.right, line + 1, column + 1);
    }

    private static BigDecimal t(BigDecimal W){
        BigDecimal a = new BigDecimal("60").divide(e(W), new MathContext(100));
        BigDecimal b = new BigDecimal("2.032")
                        .divide(W, new MathContext(100))
                        .add(W.multiply(new BigDecimal("0.25")
                                .divide(new BigDecimal("0.254"), new MathContext(100))));
        BigDecimal c = a.multiply(b);
        return BigDecimal.valueOf(Math.log(c.doubleValue()));
    }

    private static BigDecimal e(BigDecimal W){

        BigDecimal a = new BigDecimal("1.6");

        BigDecimal b = new BigDecimal("3.048")
                .divide(W, new MathContext(100))
                .add(new BigDecimal(1))
                .sqrt(new MathContext(100));

        return a.add(new BigDecimal("0.6").divide(b, new MathContext(100))).sqrt(new MathContext(100));
    }

    private static BigDecimal calculateW(){
        BigDecimal target = new BigDecimal(50);
        BigDecimal W = new BigDecimal(0.7);
        BigDecimal res = t(W);
        int c = 0;
         while (res.compareTo(target) != 0
                ||
                res.subtract(target).abs().compareTo(new BigDecimal("0.00000000001"))  < 0){
            if (res.compareTo(target) > 0){
                W = W.multiply(new BigDecimal("0.9999"), new MathContext(100));
            }else if (res.compareTo(target) < 0){
                W = W.multiply(new BigDecimal("1.0001"), new MathContext(100));
            }

            res = t(W);
            c++;
            if (c % 1000 == 0)
                System.out.println(res + "," + W);
        }


       return W;
    }

    public static void main(String[] args) {
        System.out.println(calculateW());
    }
}
