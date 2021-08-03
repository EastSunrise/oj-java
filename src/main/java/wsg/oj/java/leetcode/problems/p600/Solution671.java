package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p200.Solution230;

/**
 * 671. Second Minimum Node In a Binary Tree (EASY)
 *
 * @author Kingen
 * @see Solution230
 * @see <a href="https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/">Second
 * Minimum Node In a Binary Tree</a>
 * @since 2021-07-23
 */
public class Solution671 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        if (root.left != null) {
            int left = root.left.val, right = root.right.val;
            if (left == min) {
                left = findSecondMinimumValue(root.left);
            }
            if (right == min) {
                right = findSecondMinimumValue(root.right);
            }
            if (left == -1) {
                return right;
            }
            if (right == -1) {
                return left;
            }
            return Math.min(left, right);
        }
        return -1;
    }
}
