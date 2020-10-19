package Exs.medium;

import java.util.Arrays;

/**
 * @author Wei
 * @date 2020/9/30 13:58
 * 701. 二叉搜索树中的插入操作
 */
public class InsertintoaBinarySearchTree {
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
     
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val >= root.val){
            root.right = insertIntoBST(root.right, val);
        }
        else{
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

}
