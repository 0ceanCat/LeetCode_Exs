package Exs.easy;

/**
 * @author Wei
 * @date 2020/10/9 10:54
 * 141. 环形链表
 */
public class LinkedListCycle {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public boolean hasCycle(ListNode head) {
        while(head != null){
            if (head.val == Integer.MAX_VALUE)
                return true;
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return false;
    }

}
