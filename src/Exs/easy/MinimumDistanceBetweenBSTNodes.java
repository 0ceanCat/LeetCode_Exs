package Exs.easy;

/**
 * @author wy
 * @date 2021/4/12 17:02
 */
// 783. 二叉搜索树节点最小距离
public class MinimumDistanceBetweenBSTNodes {
    static class TreeNode {
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

    private TreeNode pre = null;   //pre记录前一节点
    private int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(pre != null){
            res = Math.min(root.val-pre.val,res);   //记录最小
        }
        pre = root;
        dfs(root.right);
    }

}
