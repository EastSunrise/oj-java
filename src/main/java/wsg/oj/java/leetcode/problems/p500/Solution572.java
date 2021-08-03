package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
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
class Solution572 extends Solution100 implements Solution {

    /**
     * @complexity T=O(mn)
     * @complexity S=O(max{h1,h2}), h1=the height of root, h2=the height of subRoot
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSameTree(root, subRoot)
            || (root.left != null && isSubtree(root.left, subRoot))
            || (root.right != null && isSubtree(root.right, subRoot));
    }


}
