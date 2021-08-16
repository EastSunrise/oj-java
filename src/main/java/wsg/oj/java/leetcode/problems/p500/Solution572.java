package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.base.TreeSolution;
import wsg.oj.java.leetcode.problems.p100.Solution100;

/**
 * 572. Subtree of Another Tree (EASY)
 *
 * @author Kingen
 * @see Solution250
 * @see Solution508
 * @see <a href="https://leetcode-cn.com/problems/subtree-of-another-tree/">Subtree of Another
 * Tree</a>
 * @since 2021-07-20
 */
public class Solution572 extends Solution100 implements TreeSolution {

    /**
     * @complexity T=O(mn)
     * @complexity S=O(max{h1,h2}), h1=the height of root, h2=the height of subRoot
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverse(root, subRoot, getHeight(subRoot)) == -1;
    }

    private int traverse(TreeNode node, TreeNode subRoot, int height) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left, subRoot, height);
        if (left == -1) {
            return -1;
        }
        int right = traverse(node.right, subRoot, height);
        if (right == -1) {
            return -1;
        }
        int h = Math.max(left, right) + 1;
        if (h == height && equals(node, subRoot)) {
            return -1;
        }
        return h;
    }
}
