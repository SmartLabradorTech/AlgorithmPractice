package linkedlist.LinkedListCycleII;


import linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode current = head;

        Set<ListNode> visited = new HashSet<>();

        while (current != null) {

            if (visited.contains(current)) {
                return current;
            }

            visited.add(current);

            current = current.next;

        }

        return null;
    }
}
