package linkedlist.LinkedListCycle;

import linkedlist.LinkedListCycle.LinkedListCycle.ListNode;

public class LinkedListCycleV4 {

    // Fast tries to move 3 steps instead of 2 steps. what about 4 steps?
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

            if (fast.next.next == null) {
                return false;
            }

            if (fast.next.next.next == null) {
                return false;
            }

            fast = fast.next.next.next.next;

            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
