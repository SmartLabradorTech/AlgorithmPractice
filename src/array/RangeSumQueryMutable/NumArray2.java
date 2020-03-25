package array.RangeSumQueryMutable;

//https://leetcode.com/problems/range-sum-query-mutable/

import java.util.LinkedList;
import java.util.Queue;

class NumArray2 {
    public Node root;

    private Node[] nodes;

    public NumArray2(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return;
        }

        nodes = new Node[length];

        for (int i = 0; i < length; i++) {
            Node aNode = new Node();
            aNode.leftIndex = i;
            aNode.rightIndex = i;
            aNode.value = nums[i];
            aNode.evaluated = true;

            nodes[i] = aNode;
        }

        if (length == 1) {
            root = nodes[0];
        } else {
            root = new Node();
            root.evaluated = false;
            root.leftIndex = 0;
            root.rightIndex = nums.length - 1;
            build(root);
        }
    }

    public void update(int i, int val) {
        update(i, val, root);
    }

    private Node update(int i, int val, Node current) {
        if (current == null) {
            return null;
        }

        int leftIndex = current.leftIndex;
        int rightIndex = current.rightIndex;

        if (i == leftIndex && i == rightIndex) {
            current.value = val;
            return current;
        }

        if (i < leftIndex || i > rightIndex) {
            return current;
        }

        int midIndex = (leftIndex + rightIndex) / 2;

        if (i <= midIndex) {
            update(i, val, current.left);
        } else {
            update(i, val, current.right);
        }

        current.value = current.left.value + current.right.value;

        return current;
    }

    public int sumRange(int i, int j) {
        return sum(i, j, root);
    }

    private int sum(int i, int j, Node root) {
        if (root == null) {
            return 0;
        }

        int leftIndex = root.leftIndex;
        int rightIndex = root.rightIndex;

        if (leftIndex == rightIndex) {
            if (leftIndex >= i && leftIndex <= j) {
                return root.value;
            }

            return 0;
        }

        if (rightIndex < i) {
            return 0;
        }

        if (leftIndex > j) {
            return 0;
        }

        if (leftIndex >= i && rightIndex <= j) {
            return root.value;
        }

        return sum(i, j, root.left) + sum(i, j, root.right);
    }

    public int build(Node current) {
        if (current.evaluated) {
            return current.value;
        }

        int leftIndex = current.leftIndex;
        int rightIndex = current.rightIndex;

        int midIndex = (leftIndex + rightIndex) / 2;

        Node leftNode;
        Node rightNode;

        if (leftIndex == midIndex) {
            leftNode = nodes[leftIndex];
        } else {
            leftNode = new Node();
            leftNode.evaluated = false;
            leftNode.leftIndex = leftIndex;
            leftNode.rightIndex = midIndex;
        }

        current.left = leftNode;

        if (rightIndex == midIndex + 1) {
            rightNode = nodes[rightIndex];
        } else {
            rightNode = new Node();
            rightNode.evaluated = false;
            rightNode.leftIndex = midIndex + 1;
            rightNode.rightIndex = rightIndex;
        }

        current.right = rightNode;

        int result = build(leftNode) + build(rightNode);
        current.evaluated = true;
        current.value = result;

        return result;
    }

    public void printLevelByLevel(Node current) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        Node special = new Node();
        queue.add(special);

        while (queue.size() != 0) {
            Node poll = queue.poll();
            if (poll == special) {
                System.out.println();
                if (queue.size() != 0) {
                    queue.add(special);
                }
                continue;
            }

            System.out.print(poll.value + ",");

            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }


    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 6, 5, 3};

        int[] nums = {0, 9, 5, 7, 3};

        NumArray2 numArray2 = new NumArray2(nums);

        numArray2.printLevelByLevel(numArray2.root);

        System.out.println();

        System.out.println(numArray2.sumRange(2, 4));

//        numArray2.update(0, 10);
//
//        numArray2.printLevelByLevel(numArray2.root);

    }

}

class Node {
    boolean evaluated;
    int value;
    int leftIndex;
    int rightIndex;

    Node left;
    Node right;
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
