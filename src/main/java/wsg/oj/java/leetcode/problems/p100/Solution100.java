package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 100. Same Tree (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/same-tree/">Same Tree</a>
 * @since 2021-07-11
 */
class Solution100 extends BinaryTree implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return equals(p, q);
    }
}
