package Exs.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author wy
 * @date 2021/7/21 17:50
 */
public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node n = new Node(-1);
        Node list = n;
        Node temp = head;

        while (temp != null){
            Node tempF = temp;
            Node copy = map.computeIfAbsent(temp, (x)->new Node(tempF.val));
            if (temp.random != null){
                Node tempRF = temp.random;
                copy.random = map.computeIfAbsent(tempRF,
                        (x)-> new Node(tempRF.val));
            }

            list.next = copy;
            temp = temp.next;
            list = list.next;
        }

        return n.next;
    }

    /*
    private HashMap<Node, Node> MyMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (MyMap.containsKey(head)) return MyMap.get(head);
        Node root = new Node(head.val);
        MyMap.put(head, root);
        root.next = copyRandomList(head.next);
        root.random = copyRandomList(head.random);
        return root;
    }
     */
    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        CopyListWithRandomPointer cr = new CopyListWithRandomPointer();
        cr.copyRandomList(a);


        int[][] arr = new int[1][3];
        int[][] ints = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.deepToString(ints));
    }
}
