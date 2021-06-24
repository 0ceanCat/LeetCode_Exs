package Exs.easy;

import com.sun.source.tree.Tree;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/4/24 17:10
 */
// 897. 递增顺序搜索树
public class IncreasingOrderSearchTree {
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
    static TreeNode dummyHead = new TreeNode(0);
    static TreeNode pre = dummyHead;

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        increasingBST(root.left); // 遍历左子树

        pre.right = new TreeNode(root.val);
        pre = pre.right;

        increasingBST(root.right); // 遍历右子树

        return dummyHead.right;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n5.left = n3;
        n5.right = n6;

        n3.left = n2;
        n3.right = n4;

        n2.left = n1;

        n6.right = n8;

        n8.left = n7;
        n8.right = n9;

        increasingBST(n5);
    }
}
