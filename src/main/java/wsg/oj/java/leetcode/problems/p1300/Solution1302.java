package wsg.oj.java.leetcode.problems.p1300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 1302. Deepest Leaves Sum (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/deepest-leaves-sum/">Deepest Leaves Sum</a>
 * @since 2021-07-27
 */
public class Solution1302 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int deepestLeavesSum(TreeNode root) {
        int[] tmp = new int[2];
        findLeaves(root, 0, tmp);
        return tmp[1];
    }

    /**
     * @param tmp the depth of the sum, the sum of leaves with the depth
     */
    private void findLeaves(TreeNode node, int d, int[] tmp) {
        if (node == null) {
            return;
        }
        if (node.left != null || node.right != null) {
            // not a leaf node
            findLeaves(node.left, d + 1, tmp);
            findLeaves(node.right, d + 1, tmp);
        } else {
            // a leaf node
            if (d > tmp[0]) {
                tmp[0] = d;
                tmp[1] = node.val;
            } else if (d == tmp[0]) {
                tmp[1] += node.val;
            }
        }
    }
}
