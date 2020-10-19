package Exs.easy;

import com.sun.source.tree.Tree;

import java.util.LinkedList;

/**
 * @author Wei
 * @date 2020/9/16 9:48
 * 226. 翻转二叉树
 */
public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
      if (root == null)
          return null;

      dfs(root);

      return root;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);
        dfs(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
