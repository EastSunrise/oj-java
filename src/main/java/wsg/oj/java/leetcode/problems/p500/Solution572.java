package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

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
class Solution572 extends BinaryTree implements Solution {

    /**
     * @complexity T=O(mn)
     * @complexity S=O(max{h1,h2}), h1=the height of root, h2=the height of subRoot
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return equals(root, subRoot)
            || (root.left != null && isSubtree(root.left, subRoot))
            || (root.right != null && isSubtree(root.right, subRoot));
    }
}
