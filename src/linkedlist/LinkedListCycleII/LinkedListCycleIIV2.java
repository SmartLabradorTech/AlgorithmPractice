package linkedlist.LinkedListCycleII;

import linkedlist.ListNode;

public class LinkedListCycleIIV2 {


    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }


        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {

            slow = slow.next;

            if (fast.next == null) {
                return null;
            }

            fast = fast.next.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null) {
            return null;
        }

        ListNode newHead = head;

        while (newHead != slow) {

            newHead = newHead.next;

            slow = slow.next;
        }

        return slow;
    }
}
