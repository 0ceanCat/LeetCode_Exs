package Exs.medium;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wy
 * @date 2021/7/28 19:34
 */
// 1104. 二叉树寻路
public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list = new LinkedList<>();

        int level = (int) log2(label) + 1;
        int max = 1 << level;
        int min = 1 << (level - 1);
        int nodePosition = level % 2 == 0 ? max - label : label - min + 1;
        list.add(label);

        for (int i = level - 1; i > 0; i--) {
            max = 1 << i;
            min = 1 << (i - 1);
            nodePosition = (int) Math.ceil(nodePosition * 1.0 / 2);

            if (i % 2 == 0){
                list.addFirst(max - nodePosition);
            }else{
                list.addFirst(min + nodePosition - 1);
            }
        }

        return list;
    }

    public double log2(double N) {
        return Math.log(N)/Math.log(2);//Math.log的底为e
    }

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree p = new PathInZigzagLabelledBinaryTree();
        System.out.println(p.pathInZigZagTree(26));
    }
}
