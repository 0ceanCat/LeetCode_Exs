package Exs.easy;

/**
 * @author Wei
 * @date 2020/9/19 15:47
 */
public class SumOfLeftLeaves {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        return dfs(root, sum, 0);
    }

    private int dfs(TreeNode root, int sum , int mark) {
        if (root == null) return sum;

        if (mark == 1 && root.left == null && root.right == null)
            return sum + root.val;

        sum = dfs(root.left, sum ,1);
        return dfs(root.right, sum, 0);
    }
}
