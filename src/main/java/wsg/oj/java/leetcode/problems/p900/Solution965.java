package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 965. Univalued Binary Tree (EASY)
 *
 * @author Kingen
 * @see Solution1469
 * @see <a href="https://leetcode-cn.com/problems/univalued-binary-tree/">Univalued Binary Tree</a>
 * @since 2021-07-27
 */
public class Solution965 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return val == root.val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
}
