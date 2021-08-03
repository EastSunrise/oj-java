package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 226. Invert Binary Tree (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/invert-binary-tree/">Invert Binary Tree</a>
 * @since 2021-07-13
 */
class Solution226 implements Solution {

    /**
     * @see #POSTORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }
}
