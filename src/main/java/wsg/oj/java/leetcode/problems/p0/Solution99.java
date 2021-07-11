package wsg.oj.java.leetcode.problems.p0;

import java.util.Stack;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 99. Recover Binary Search Tree (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/recover-binary-search-tree/">Recover Binary Search
 * Tree</a>
 * @since 2021-07-11
 */
class Solution99 implements Solution {

    /**
     * Traverses the tree to find the two wrong nodes with LVR and RVL respectively and then swap
     * the values.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, prev = new TreeNode(Integer.MIN_VALUE);
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            // compare with the previous value
            if (current.val >= prev.val) {
                prev = current;
            } else {
                break;
            }
            current = current.right;
        }
        TreeNode next = new TreeNode(Integer.MAX_VALUE);
        current = root;
        stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }
            current = stack.pop();
            // compare with the next value
            if (current.val <= next.val) {
                next = current;
            } else {
                break;
            }
            current = current.left;
        }
        int tmp = prev.val;
        prev.val = next.val;
        next.val = tmp;
    }
}
