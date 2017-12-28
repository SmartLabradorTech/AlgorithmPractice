package sort.MergekSortedLists;

import java.util.PriorityQueue;

/**
 * Created by tianle on 12/28/17.
 */
public class MergekSortedListsClean {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // initial setup
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];

            if (list != null) {
                queue.add(list);
            }
        }

        ListNode head = null;
        ListNode tail = null;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);

//        n1.next = n2;
//        n2.next = n3;

        MergekSortedListsClean m = new MergekSortedListsClean();

        ListNode[] input = {n2, n1};

        ListNode listNode = m.mergeKLists(input);

        int a = 1;
    }
}
