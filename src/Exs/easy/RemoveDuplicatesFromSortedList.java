package Exs.easy;

import Exs.medium.RemoveDuplicatesFromSortedListII;

/**
 * @author wy
 * @date 2021/3/25 17:34
 */
// 83. 删除排序链表中的重复元素
public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
