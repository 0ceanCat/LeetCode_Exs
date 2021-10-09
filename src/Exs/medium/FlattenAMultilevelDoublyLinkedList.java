package Exs.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wy
 * @date 2021/9/23 18:05
 */
// 430. 扁平化多级双向链表
public class FlattenAMultilevelDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int vl){
            this.val = vl;
        }

        public Node(){
        }
    };

    public Node flatten(Node head) {
        if (head == null) return null;
        Node t = new Node();
        dfs(t, head);
        head.prev = null;
        return t.next;
    }

    private Node dfs(Node p, Node curr) {
        if (curr == null) return p;
        p.next = curr;
        curr.prev = p;
        Node next = curr.next;
        Node node = dfs(curr, curr.child);
        curr.child = null;
        return dfs(node, next);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
        n3.child = n7; n7.next = n8; n8.next = n9; n9.next = n10;
        n8.child = n11; n11.next = n12;

        FlattenAMultilevelDoublyLinkedList f = new FlattenAMultilevelDoublyLinkedList();
        Node flatten = f.flatten(n1);
        System.out.println();
    }
}
