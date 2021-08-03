package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 938. Range Sum of BST (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/range-sum-of-bst/">Range Sum of BST</a>
 * @since 2021-07-27
 */
public class Solution938 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
