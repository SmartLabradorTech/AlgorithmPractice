package linkedlist.LinkedListCycle;

import linkedlist.LinkedListCycle.LinkedListCycle.ListNode;

public class LinkedListCycleV3 {

    // start from the same point which is the head.
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head;

        ListNode slow = head;

        while (fast != null) {

            if (fast.next == null) {
                return false;
            }

            fast = fast.next.next;

            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
