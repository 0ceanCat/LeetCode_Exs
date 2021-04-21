package Exs.medium;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/3/27 17:56
 */
// 173. 二叉搜索树迭代器
public class BinarySearchTreeIterator {

    public static class TreeNode {
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

    public static class BSTIterator{
        Stack<TreeNode> s = new Stack<>();
        public BSTIterator(TreeNode root) {
            s.push(root);
            help(root);
        }

        public int next() {
            TreeNode cur = s.pop();
            if (cur.right != null){
                TreeNode right = cur.right;
                s.push(cur.right);
                help(right);
            }
            return cur.val;
        }

        private void help(TreeNode right) {
            while (right.left != null) {
                s.push(right.left);
                right = right.left;
            }
        }

        public boolean hasNext() {
            return !s.empty();
        }
    }
}
