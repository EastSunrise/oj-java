package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.*;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/">653. Two Sum IV - Input is a BST</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution1
 * @see cn.kingen.oj.leetcode.problem.p100.Solution167
 * @see cn.kingen.oj.leetcode.problem.p100.Solution170
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1214
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution653 {

    @Complexity(time = "O(n)", space = "O(h)")
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }

    private boolean dfs(TreeNode t, int k, Set<Integer> visited) {
        if (t == null) {
            return false;
        }
        if (visited.contains(k - t.val)) {
            return true;
        }
        visited.add(t.val);
        return dfs(t.left, k, visited) || dfs(t.right, k, visited);
    }
}