package Exs.easy;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wy
 * @date 2021/5/9 21:45
 */
public class Leaf_SimilarTrees {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        s1.push(root1);
        s2.push(root2);
        while(!s1.isEmpty() && !s2.isEmpty())
        {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();
            while(node1.left != null || node1.right != null)
            {
                if(node1.left != null)
                {
                    if(node1.right != null) s1.push(node1.right);
                    node1 = node1.left;
                }
                else
                    node1 = node1.right;
            }
            //同样的操作对树2进行一遍
            while(node2.left != null || node2.right != null)
            {
                if(node2.left != null)
                {
                    if(node2.right != null) s2.push(node2.right);
                    node2 = node2.left;
                }
                else
                    node2 = node2.right;
            }
            //此时node1与node2分别指向树1与树2的叶子节点
            if(node1.val != node2.val) return false;
        }
        //到此两种情况：
        //1. 两个栈都空了，并且叶子节点都相等，因此返回true
        //2. 只有一颗树空了，证明另一棵树一定还有别的叶子节点, 返回false;
        return s1.isEmpty() && s2.isEmpty();
    }
}
