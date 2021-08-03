package wsg.oj.java.leetcode.problems.p500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 515. Find Largest Value in Each Tree Row (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/">Find Largest
 * Value in Each Tree Row</a>
 * @since 2021-07-20
 */
class Solution515 implements Solution {

    /**
     * @see BinaryTree#traverseLevels(Function, BiConsumer)
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
