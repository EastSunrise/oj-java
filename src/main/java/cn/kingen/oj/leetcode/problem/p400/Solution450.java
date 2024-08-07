package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/delete-node-in-a-bst/">450. Delete Node in a BST</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution776
 */
@Question(
        tags = {Tag.TREE, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution450 {

    @Complexity(time = "O(h)", space = "O(1)", note = "h is the height of the tree")
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode t = root, p = null;
        while (t != null && t.val != key) {
            p = t;
            if (key < t.val) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        if (t == null) { // if not found
            return root;
        }

        if (t.left != null && t.right != null) {
            // if the node has two children, swap the node with its successor
            TreeNode s = t.right, sp = t;
            while (s.left != null) {
                sp = s;
                s = s.left;
            }
            t.val = s.val;
            p = sp;
            t = s;
        }

        TreeNode replacement = t.left != null ? t.left : t.right;
        if (replacement != null) {
            // if the node has exactly one child, link its parent with its child
            if (p == null) {
                root = replacement;
            } else if (p.left == t) {
                p.left = replacement;
            } else {
                p.right = replacement;
            }
            t.left = t.right = null;
        } else if (p == null) {
            root = null;
        } else { // if no children, delete itself
            if (p.left == t) {
                p.left = null;
            } else {
                p.right = null;
            }
        }
        return root;
    }
}