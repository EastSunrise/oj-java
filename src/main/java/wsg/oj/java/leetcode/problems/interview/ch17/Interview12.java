package wsg.oj.java.leetcode.problems.interview.ch17;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 面试题 17.12. BiNode LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/binode-lcci/">BiNode LCCI</a>
 * @since 2021-07-28
 */
public class Interview12 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public TreeNode convertBiNode(TreeNode root) {
        return root == null ? null : headAndTail(root)[0];
    }

    private TreeNode[] headAndTail(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode[] left = headAndTail(node.left);
        TreeNode[] right = headAndTail(node.right);
        if (left == null && right == null) {
            return new TreeNode[]{node, node};
        }
        if (left == null) {
            node.right = right[0];
            right[0] = node;
            return right;
        }
        if (right == null) {
            node.left = null;
            left[1].right = node;
            left[1] = node;
            return left;
        }
        node.right = right[0];
        node.left = null;
        left[1].right = node;
        left[1] = right[1];
        return left;
    }
}
