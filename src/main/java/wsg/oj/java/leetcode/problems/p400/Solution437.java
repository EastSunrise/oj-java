package wsg.oj.java.leetcode.problems.p400;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p100.Solution112;
import wsg.oj.java.leetcode.problems.p100.Solution113;
import wsg.oj.java.leetcode.problems.p600.Solution687;

/**
 * 437. Path Sum III (Medium)
 *
 * @author Kingen
 * @see Solution112
 * @see Solution113
 * @see Solution666
 * @see Solution687
 * @see <a href="https://leetcode-cn.com/problems/path-sum-iii/">Path Sum III</a>
 * @since 2021-07-07
 */
public class Solution437 implements Solution {

    /**
     * Finds the paths from the root and except the root respectively.
     *
     * @see wsg.oj.java.Complexity#TIME_NN
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
            + pathSumFromRoot(root, targetSum);
    }

    private int pathSumFromRoot(TreeNode node, int target) {
        int count = 0;
        if (target == node.val) {
            count++;
        }
        target -= node.val;
        if (node.left != null) {
            count += pathSumFromRoot(node.left, target);
        }
        if (node.right != null) {
            count += pathSumFromRoot(node.right, target);
        }
        return count;
    }

    /**
     * Uses a map to store the prefix sums from the root node.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int pathSum2(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSums = new HashMap<>(16);
        prefixSums.put(0, 1);
        return traverse(root, prefixSums, 0, targetSum);
    }

    private int traverse(TreeNode node, Map<Integer, Integer> prefixSums, int sum, int target) {
        if (node == null) {
            return 0;
        }
        sum += node.val;
        // find paths which end with current node
        int count = prefixSums.getOrDefault(sum - target, 0);
        prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        count += traverse(node.left, prefixSums, sum, target);
        count += traverse(node.right, prefixSums, sum, target);
        prefixSums.put(sum, prefixSums.get(sum) - 1);
        return count;
    }
}
