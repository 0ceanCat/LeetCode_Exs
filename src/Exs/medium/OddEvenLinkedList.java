package Exs.medium;

/**
 * @author Wei
 * @date 2020/11/12 18:28
 */
public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;

        ListNode p=head;
        int flag=1;
        ListNode q=head;
        ListNode t;
        while(p.next != null)
        {
            if(flag==0)
            {
                t=p.next;
                p.next=t.next;
                t.next=q.next;
                q.next=t;
                q=t;
                flag++;
            }
            else
            {
                p=p.next;
                flag--;
            }
        }
        return head;
    }
}
