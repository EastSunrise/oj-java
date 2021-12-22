package cn.wsg.oj.leetcode.problems.interview.ch17;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 面试题 17.12. BiNode LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/binode-lcci/">BiNode LCCI</a>
 */
public class Interview12 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
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
