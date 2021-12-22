package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.datastructure.BinaryTree;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * 515. Find Largest Value in Each Tree Row (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/">Find Largest
 * Value in Each Tree Row</a>
 */
public class Solution515 implements Solution {

    /**
     * @see BinaryTree#traverseLevels(Function, BiConsumer)
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
            // traverse a level
            int size = level.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = level.remove();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
