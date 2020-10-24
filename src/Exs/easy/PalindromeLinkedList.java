package Exs.easy;

/**
 * @author Wei
 * @date 2020/10/22 22:28
 */
public class PalindromeLinkedList {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondPart = reverseList(slow.next);
        ListNode firstPart = head;

        while(secondPart != null){
            if (firstPart.val != secondPart.val) return false;
            firstPart = firstPart.next;
            secondPart = secondPart.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    /*
    public boolean isPalindrome(ListNode head) {
            long hash1 = 0, hash2 = 0, h = 1;
            long seed = (long) (1e9 + 7);
            ListNode p = head;
            while (p != null) {
                hash1 = hash1 * seed + p.val;
                hash2 = hash2 + h * p.val;
                h *= seed;
                p = p.next;
            }
            return hash1 == hash2;
        }
     */
    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        p.isPalindrome(l1);
    }
}
