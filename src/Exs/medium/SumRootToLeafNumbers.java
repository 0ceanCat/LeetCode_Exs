package Exs.medium;

/**
 * @author Wei
 * @date 2020/10/28 16:24
 * 129. 求根到叶子节点数字之和
 */
public class SumRootToLeafNumbers {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int parentVal){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return parentVal * 10 + root.val;
        int sum = parentVal * 10 + root.val;
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

}
