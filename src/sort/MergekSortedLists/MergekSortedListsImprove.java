package sort.MergekSortedLists;

import java.util.PriorityQueue;

/**
 * Created by tianle on 12/28/17.
 */
public class MergekSortedListsImprove {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class NodeIndexPair implements Comparable {
        int sourceListIndex;
        ListNode node;

        NodeIndexPair(int index, ListNode aNode) {
            sourceListIndex = index;
            node = aNode;
        }

        @Override
        public int compareTo(Object o) {
            NodeIndexPair anotherNode = (NodeIndexPair) o;
            return node.val - anotherNode.node.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<NodeIndexPair> queue = new PriorityQueue<>();

        // initial setup
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];

            if (list != null) {
                queue.add(new NodeIndexPair(i, list));
            }
        }

        ListNode head = null;
        ListNode tail = null;

        while (!queue.isEmpty()) {
            NodeIndexPair minPair = queue.poll();

            ListNode node = minPair.node;
            int index = minPair.sourceListIndex;

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

            lists[index] = node.next;

            if (lists[index] != null) {
                queue.add(new NodeIndexPair(index, lists[index]));
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

        MergekSortedListsImprove m = new MergekSortedListsImprove();

        ListNode[] input = {n2, n1};

        ListNode listNode = m.mergeKLists(input);

        int a = 1;
    }
}
