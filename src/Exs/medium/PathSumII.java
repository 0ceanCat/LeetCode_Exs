package Exs.medium;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wei
 * @date 2020/9/26 9:08
 * 113. 路径总和 II
 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> dequeue  = new LinkedList<>();

        dfs(sum, root, res, dequeue);

        return res;
    }

    private void dfs(int sum, TreeNode root, List<List<Integer>> res, LinkedList<Integer> dequeue) {
        if (root == null){
            return;
        }

        int val = root.val;
        sum = sum - val;

        dequeue.addLast(val);

        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(dequeue));
        } else{
            dfs(sum, root.left, res, dequeue);
            dfs(sum, root.right, res, dequeue);
        }

        dequeue.removeLast();

    }
}
