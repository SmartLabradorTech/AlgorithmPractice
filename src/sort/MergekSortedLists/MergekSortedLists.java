package sort.MergekSortedLists;

/**
 * Created by tianle on 12/28/17.
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergekSortedLists {
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

        int numberOfLists = lists.length;

        boolean shouldFinish = false;

        ListNode head = null;
        ListNode lastNode = null;

        while (!shouldFinish) {

            int minIndex = -1;
            ListNode minNode = null;

            int countOfFinishedList = 0;

            for (int i = 0; i < numberOfLists; i++) {
                ListNode currentList = lists[i];

                if (currentList == null) {
                    countOfFinishedList++;
                    continue;
                }

                if (minNode == null || currentList.val < minNode.val) {
                    minNode = currentList;
                    minIndex = i;
                }
            }

            if (countOfFinishedList == numberOfLists) {
                shouldFinish = true;
                continue;
            }

            // now we know the smallest of first round.
            lists[minIndex] = minNode.next;

            if (head == null) {
                head = minNode;
                lastNode = minNode;
            } else {
                lastNode.next = minNode;
                lastNode = lastNode.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;

        MergekSortedLists m = new MergekSortedLists();

        ListNode[] input = {n1};

        ListNode listNode = m.mergeKLists(input);

        int a = 1;
    }
}
