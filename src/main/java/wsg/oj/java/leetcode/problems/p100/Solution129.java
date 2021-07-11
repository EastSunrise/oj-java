package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 129. Sum Root to Leaf Numbers (Medium)
 *
 * @author Kingen
 * @see Solution112
 * @see Solution124
 * @see Solution988
 * @see <a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">Sum Root to Leaf
 * Numbers</a>
 * @since 2021-07-11
 */
class Solution129 implements Solution {

    /**
     * @see #DFS
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int tmp) {
        if (node.left == null && node.right == null) {
            // find a path
            return tmp * 10 + node.val;
        }
        int sum = 0;
        tmp = tmp * 10 + node.val;
        if (node.left != null) {
            sum += sumNumbers(node.left, tmp);
        }
        if (node.right != null) {
            sum += sumNumbers(node.right, tmp);
        }
        return sum;
    }
}
