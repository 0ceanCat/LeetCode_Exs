package Exs.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/9/21 17:36
 */

// 725. 分隔链表
public class SplitLinkedListInParts {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        List<ListNode> list = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            list.add(t);
            t = t.next;
        }
        int quotient = list.size() / k, remainder = list.size() % k;
        int size;
        int index = 0;
        for (int i = 0; i < k && index < list.size(); i++) {
            size = quotient + (i < remainder ? 1 : 0);
            res[i] = list.get(index);
            list.get(index + size - 1).next = null;
            index += size;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);
        ListNode a8 = new ListNode(8);
        ListNode a9 = new ListNode(9);
        ListNode a10 = new ListNode(10);
        a1.next = a2; a2.next = a3;
        a3.next = a4; a4.next = a5;
        a5.next = a6; a6.next = a7;
        a7.next = a8; a8.next = a9;
        a9.next = a10;
        splitListToParts(a1, 3);
    }
}
