package Exs.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/9/27 18:18
 */
// 437. 路径总和 III
public class PathSumIII {

     class TreeNode {
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

    Map<Integer, Integer> prefixMap;
    int target;

    public int pathSum(TreeNode root, int sum) {
        prefixMap = new HashMap<>();
        target = sum;

        prefixMap.put(0, 1);
        return recur(root, 0);
    }

    private int recur(TreeNode node, int curSum) {
        if(node == null) {
            return 0;
        }

        curSum += node.val;

        int res = prefixMap.getOrDefault(curSum - target, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

        int left = recur(node.left, curSum);
        int right = recur(node.right, curSum);

        res = res + left + right;

        prefixMap.put(curSum, prefixMap.get(curSum) - 1);

        return res;
    }

}
