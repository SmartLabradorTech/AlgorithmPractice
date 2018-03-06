package Tree.DepthFirstSearch;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tianle on 3/4/18.
 */
public class DepthFirstSearch {

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

    private Set<TreeNode> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (visited.contains(root)) {
            return;
        }

        System.out.println("Visit " + root.value);
        visited.add(root);

        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        DepthFirstSearch d = new DepthFirstSearch();

        d.dfs(d.test());
    }
}
