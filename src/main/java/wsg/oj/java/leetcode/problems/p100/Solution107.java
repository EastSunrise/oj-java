package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution637;

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
public class Solution107 extends BinaryTree implements Solution {

    /**
     * @see #traverseLevels(TreeNode, Function, BiConsumer)
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        traverseLevels(root, size -> {
            List<Integer> level = new ArrayList<>(size);
            res.addFirst(level);
            return level;
        }, List::add);
        return res;
    }
}
