package wsg.oj.java.leetcode.problems;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator (Medium)
 *
 * @author Kingen
 * @see Solution1#inorderTraversal(TreeNode)
 * @see Vector2D
 * @see Solution201#ZigzagIterator(int[], int[])
 * @see wsg.oj.java.leetcode.problems.impl.PeekingIterator
 * @see Solution201#inorderSuccessor(TreeNode, int)
 * @see BSTIterator
 * @see <a href="https://leetcode-cn.com/problems/binary-search-tree-iterator/">Binary Search Tree
 * Iterator</a>
 * @since 2021-06-25
 */
public class BSTIterator {

    private final Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        do {
            stack.push(root);
            root = root.left;
        } while (root != null);
    }

    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
