package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p100.Solution124;
import wsg.oj.java.leetcode.problems.p400.Solution437;

/**
 * 687. Longest Univalue Path (MEDIUM)
 *
 * @author Kingen
 * @see Solution124
 * @see Solution250
 * @see Solution437
 * @see <a href="https://leetcode-cn.com/problems/longest-univalue-path/">Longest Univalue Path</a>
 * @since 2021-07-23
 */
public class Solution687 implements Solution {

    int max = 0;

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            longestFromRoot(root);
        }
        return max;
    }

    private int longestFromRoot(TreeNode node) {
        int path = 0, res = 1;
        if (node.left != null) {
            int left = longestFromRoot(node.left);
            if (node.left.val == node.val) {
                path += left;
                res = Math.max(res, left + 1);
            }
        }
        if (node.right != null) {
            int right = longestFromRoot(node.right);
            if (node.right.val == node.val) {
                path += right;
                res = Math.max(res, right + 1);
            }
        }
        max = Math.max(max, path);
        return res;
    }
}
