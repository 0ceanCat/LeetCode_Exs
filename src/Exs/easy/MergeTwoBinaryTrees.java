package Exs.easy;

/**
 * @author Wei
 * @date 2020/9/23 9:44
 * 617. 合并二叉树
 */
public class MergeTwoBinaryTrees {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        System.out.println(new Integer(10) == new Integer(10));
    }
}
