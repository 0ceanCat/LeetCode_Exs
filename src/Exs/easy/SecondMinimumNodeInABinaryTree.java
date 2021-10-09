package Exs.easy;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wy
 * @date 2021/7/26 17:35
 */
// 671. 二叉树中第二小的节点
public class SecondMinimumNodeInABinaryTree {
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

    public int findSecondMinimumValue(TreeNode root) {
        int dfs = dfs(root.val, root);
        return dfs == root.val ? -1 : dfs;
    }

    private int dfs(int target, TreeNode root){
        if (root.left != null){
            int left = dfs(target, root.left);
            int right = dfs(target, root.right);

            if (left != target && right != target) return Math.min(left, right);
            return Math.max(left, right);
        }
        return root.val;
    }

    public static void main(String[] args) {
        System.out.println(16& 2);
    }
}
