package wsg.oj.java.leetcode.problems.p1000;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 1022. Sum of Root To Leaf Binary Numbers (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/">Sum of Root
 * To Leaf Binary Numbers</a>
 * @since 2021-07-27
 */
public class Solution1022 implements Solution {

    int sum = 0;

    /**
     * @see #DFS
     */
    public int sumRootToLeaf(TreeNode root) {
        sum(root, 0);
        return sum;
    }

    private void sum(TreeNode node, int prefix) {
        if (node == null) {
            return;
        }
        prefix = (prefix << 1) + node.val;
        if (node.left == null && node.right == null) {
            // reach a leaf node
            sum += prefix;
        } else {
            sum(node.left, prefix);
            sum(node.right, prefix);
        }
    }
}
