package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 102. Binary Tree Level Order Traversal (Medium)
 *
 * @author Kingen
 * @see Solution103
 * @see Solution107
 * @see Solution111
 * @see Solution314
 * @see Solution637
 * @see Solution429
 * @see Solution993
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">Binary Tree
 * Level Order Traversal</a>
 * @since 2021-07-08
 */
class Solution102 extends BinaryTree implements Solution {

    /**
     * @see #traverseLevels(TreeNode, Consumer)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverseLevels(root, res::add);
        return res;
    }
}
