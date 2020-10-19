package Exs.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wei
 * @date 2020/9/24 11:06
 *  501. 二叉搜索树中的众数
 */
public class FindModeinBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int base, count, max;

    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);

        update(root.val);

        dfs(root.right);
    }

    private void update(int val) {
        if (base == val){
            count++;
        }else {
            count = 1;
            base = val;
        }

        if (count == max) {
            list.add(base);
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(base);
        }
    }

}
