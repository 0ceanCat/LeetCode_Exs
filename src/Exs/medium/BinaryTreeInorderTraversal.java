package Exs.medium;

import java.util.*;

/**
 * @author Wei
 * @date 2020/9/14 11:10
 * 94. 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

  /*  递归算法
  public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        dfs(root,result);

        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        dfs(root.left,result);

        result.add(root.val);

        dfs(root.right,result);
    }*/


    //迭代算法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
