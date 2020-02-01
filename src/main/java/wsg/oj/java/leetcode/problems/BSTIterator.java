package wsg.oj.java.leetcode.problems;

import java.util.Stack;

/**
 * @author Kingen
 */
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = stack.pop(),
                node = cur.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return cur.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
