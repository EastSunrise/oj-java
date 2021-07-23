package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 617. Merge Two Binary Trees (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/merge-two-binary-trees/">Merge Two Binary
 * Trees</a>
 * @since 2021-07-23
 */
class Solution617 implements Solution {

    /**
     * @see #POSTORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);
        return new TreeNode(root1.val + root2.val, left, right);
    }
}
