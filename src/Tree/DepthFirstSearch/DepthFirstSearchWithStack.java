package Tree.DepthFirstSearch;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by tianle on 3/6/18.
 */
public class DepthFirstSearchWithStack {

    private Stack<TreeNode> stack = new Stack<>();
    private Set<TreeNode> visited = new HashSet<>();

    public void dfsWithStack(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println("Visit " + root.value);
        stack.push(root);
        visited.add(root);

        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();

            if (peek.left != null && !visited.contains(peek.left)) {
                System.out.println("Visit " + peek.left.value);
                stack.push(peek.left);
                visited.add(peek.left);
                continue;
            }

            if (peek.right != null && !visited.contains(peek.right)) {
                System.out.println("Visit " + peek.right.value);
                stack.push(peek.right);
                visited.add(peek.right);
                continue;
            }

            stack.pop();
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
        DepthFirstSearchWithStack d = new DepthFirstSearchWithStack();

        d.dfsWithStack(d.test());
    }
}
