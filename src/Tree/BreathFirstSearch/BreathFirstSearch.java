package Tree.BreathFirstSearch;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tianle on 3/6/18.
 */
public class BreathFirstSearch {

    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode poll = queue.poll();

            System.out.println("Visit " + poll.value);

            if (poll.left != null) {
                queue.add(poll.left);
            }

            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    public TreeNode test() {
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode();

        n1.value = 1;
        n2.value = 2;
        n3.value = 3;
        n4.value = 4;
        n5.value = 5;
        n6.value = 6;

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;

        return n1;
    }

    public static void main(String[] args) {
        BreathFirstSearch b = new BreathFirstSearch();

        b.bfs(b.test());
    }
}
