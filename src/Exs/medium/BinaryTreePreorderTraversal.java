package Exs.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Wei
 * @date 2020/10/26 19:36
 * 144. 二叉树的前序遍历
 */
public class BinaryTreePreorderTraversal {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

    private void resolver(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        resolver(root.left, list);
        resolver(root.right, list);
    }
}
