package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/">113. Path Sum II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution112
 * @see cn.kingen.oj.leetcode.problem.p200.Solution257
 * @see cn.kingen.oj.leetcode.problem.p400.Solution437
 * @see cn.kingen.oj.leetcode.problem.p600.Solution666
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2096
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BACKTRACKING, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution113 {

    @Complexity(time = "O(h)", space = "O(h)", note = "h is height of the tree")
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, root, new ArrayList<>(), targetSum);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, TreeNode t, List<Integer> tmp, int target) {
        if (t == null) {
            return;
        }
        tmp.add(t.val);
        target -= t.val;
        if (t.left == null && t.right == null && target == 0) { // find a path
            ans.add(new ArrayList<>(tmp));
        }
        dfs(ans, t.left, tmp, target);
        dfs(ans, t.right, tmp, target);
        tmp.removeLast();
    }
}