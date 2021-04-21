package Exs.medium;

import java.util.LinkedList;

/**
 * @author wy
 * @date 2021/3/17 17:02
 */
// 92. 反转链表 II
public class ReverseLinkedListII {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (right == 0) {
            return head.next;
        }
        ListNode h = head;
        ListNode temp = new ListNode(-1);
        temp.next = h;
        for (int i = 1; i < left - 1; i++) {
            head = head.next;
        }
        dfs(left == 1 ? h : head.next, right - left, left == 1 ? temp : head);
        return temp.next;
    }

    public static ListNode dfs(ListNode head, int right, ListNode first){
        if (right == 0) {
            first.next.next = head.next;
            first.next = head;
            return head;
        }
        ListNode temp = dfs(head.next, right - 1, first);
        temp.next = head;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        //n5.next = n6;

        ListNode listNode = reverseBetween(n1, 1, 4);
        System.out.println(listNode);
    }
}
