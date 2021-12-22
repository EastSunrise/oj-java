package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 404. Sum of Left Leaves (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
 */
public class Solution404 implements Solution {

    /**
     * @see #PREORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
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
