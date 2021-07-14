package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 404. Sum of Left Leaves (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
 * @since 2021-07-14
 */
class Solution404 implements Solution {

    /**
     * @see #PREORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root != null) {
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}
