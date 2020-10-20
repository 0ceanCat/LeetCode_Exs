package Exs.medium;

import java.util.Stack;

/**
 * @author Wei
 * @date 2020/10/19 22:33
 * 143. 重排链表
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
   public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode slow = head.next;
        ListNode fast = head.next;

        while (fast != null){
            if (fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }else{
                fast = null;
            }
        }
        Stack<ListNode> stack = new Stack<>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }

        int size = stack.size();
        ListNode node = head;
        for (int i = 0; i < size; i++) {
            ListNode pop = stack.pop();
            ListNode temp = node.next;
            node.next = pop;
            pop.next = temp;
            node = pop.next;
        }
        node.next = null;
    }

}
