package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 107. Binary Tree Level Order Traversal II (Medium)
 *
 * @author Kingen
 * @see Solution102
 * @see Solution637
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">Binary Tree
 * Level Order Traversal II</a>
 * @since 2021-07-08
 */
class Solution107 extends BinaryTree implements Solution {

    /**
     * @see #traverseLevels(TreeNode, Consumer)
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverseLevels(root, res::add);
        Collections.reverse(res);
        return res;
    }
}
