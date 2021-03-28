package linkedlist.LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> visited = new HashSet<>();

        ListNode current = head;

        while (current != null) {

            if (visited.contains(current)) {
                return true;
            }

            visited.add(current);

            current = current.next;
        }

        return false;
    }
}
