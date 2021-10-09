package Exs.easy;

/**
 * @author wy
 * @date 2021/7/20 18:27
 */
// 剑指 Offer 52. 两个链表的第一个公共节点
public class Offer52 {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
