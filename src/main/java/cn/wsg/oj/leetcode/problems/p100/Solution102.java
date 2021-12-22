package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.datastructure.BinaryTree;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p400.Solution429;
import cn.wsg.oj.leetcode.problems.p600.Solution637;
import cn.wsg.oj.leetcode.problems.p900.Solution993;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Function;

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
 */
public class Solution102 implements Solution {

    /**
     * @see BinaryTree#traverseLevels(Function, BiConsumer)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
