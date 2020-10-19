package Exs.medium;

/**
 * @author Wei
 * @date 2020/10/4 9:54
 * 2. 两数相加
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;

        ListNode head = null, tail = null;

        while (l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            if (head == null){
                head = tail = new ListNode(sum);
            }else{
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0){
            tail.next = new ListNode(carry);
        }

        return head;
    }
}
