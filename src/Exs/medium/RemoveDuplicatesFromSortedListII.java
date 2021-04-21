package Exs.medium;

/**
 * @author wy
 * @date 2021/3/24 18:48
 */
// 82. 删除排序链表中的重复元素 II
public class RemoveDuplicatesFromSortedListII {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /*public ListNode deleteDuplicates(ListNode head) {
        ListNode h = new ListNode();
        ListNode ptr = h;
        ListNode last = null;
        ListNode temp = head;

        while (temp != null){
            if ( (last != null && temp.val == last.val) || (temp.next != null && temp.val == temp.next.val)){
                last = temp;
            }else{
                ptr.next = temp;
                ptr = temp;
            }
            temp = temp.next;
        }
        ptr.next = null;
        return h.next;
    }*/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while (cur != null) {
            int curRepeatNum = 0;
            ListNode difNode = cur;
            // 找到和cur指向的结点值不同的结点
            while (difNode != null && difNode.val == cur.val) {
                curRepeatNum++;
                difNode = difNode.next;
            }

            // 如果curRepeatNum的值大于1，则表示cur指向的结点重复出现了
            if (curRepeatNum > 1) {
                prev.next = difNode;
            }else {
                // cur指向的结点没有重复出现，则将变量prev指向cur所指向的结点
                prev = cur;
            }
            cur = difNode;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(3);

        h1.next = h2; h2.next = h3;

        r.deleteDuplicates(h1);
    }
}
