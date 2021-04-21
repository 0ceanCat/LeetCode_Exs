package Exs.medium;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/3/26 18:14
 */

// 61. 旋转链表
public class RotateList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        Stack<ListNode> s = new Stack<>();
        ListNode cur = head;

        while(cur != null){
            s.push(cur);
            cur = cur.next;
        }

        k = k % s.size();

        for (int i = 0; i < k; i++) {
            cur = s.pop();
            cur.next = head;
            head = cur;
        }
        s.peek().next = null;

        return head;
    }
}
