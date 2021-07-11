package wsg.oj.java.leetcode.problems.p400;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

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
class Solution437 implements Solution {

    /**
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
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public int pathSum2(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSums = new HashMap<>(16);
        prefixSums.put(0, 1);
        return traverse(root, prefixSums, targetSum, 0);
    }

    private int traverse(TreeNode node, Map<Integer, Integer> prefixSums, int sum, int prefixSum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        prefixSum += node.val;
        // find paths which end with current node
        count += prefixSums.getOrDefault(prefixSum - sum, 0);
        prefixSums.put(prefixSum, prefixSums.getOrDefault(prefixSum, 0) + 1);
        count += traverse(node.left, prefixSums, sum, prefixSum);
        count += traverse(node.right, prefixSums, sum, prefixSum);
        prefixSums.put(prefixSum, prefixSums.get(prefixSum) - 1);
        return count;
    }
}
