package linkedlist.LinkedListCycle;

import linkedlist.LinkedListCycle.LinkedListCycle.ListNode;

public class LinkedListCycleV2 {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head.next;

        ListNode slow = head;


        while (fast != null) {

            if (fast == slow) {
                return true;
            }

            slow = slow.next;

            if (fast.next == null) {
                return false;
            }

            fast = fast.next.next;
        }

        return false;
    }
}
