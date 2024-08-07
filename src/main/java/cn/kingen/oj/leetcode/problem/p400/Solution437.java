package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/path-sum-iii/">437. Path Sum III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution112
 * @see cn.kingen.oj.leetcode.problem.p100.Solution113
 * @see cn.kingen.oj.leetcode.problem.p600.Solution666
 * @see cn.kingen.oj.leetcode.problem.p600.Solution687
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution437 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSums = new HashMap<>(16);
        prefixSums.put(0, 1);
        return dfs(root, prefixSums, 0, targetSum);
    }

    private int dfs(TreeNode t, Map<Integer, Integer> prefixSums, int sum, int target) {
        if (t == null) {
            return 0;
        }
        sum += t.val;
        // find paths which end with this node
        int count = prefixSums.getOrDefault(sum - target, 0);
        prefixSums.merge(sum, 1, Integer::sum);
        count += dfs(t.left, prefixSums, sum, target);
        count += dfs(t.right, prefixSums, sum, target);
        prefixSums.merge(sum, -1, Integer::sum);
        return count;
    }
}