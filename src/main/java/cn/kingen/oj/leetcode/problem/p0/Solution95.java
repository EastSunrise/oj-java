package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees-ii/">95. Unique Binary Search Trees II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution96
 * @see cn.kingen.oj.leetcode.problem.p200.Solution241
 */
@Question(
        tags = {Tag.TREE, Tag.BINARY_SEARCH_TREE, Tag.DYNAMIC_PROGRAMMING, Tag.BACKTRACKING, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution95 {

    @Complexity(time = "O(G(n))", space = "O(n)", note = "G(n) is Catalan number")
    public List<TreeNode> dfs(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int min, int max) {
        List<TreeNode> ans = new ArrayList<>();
        if (min > max) {
            ans.add(null);
            return ans;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> lefts = dfs(min, i - 1);
            List<TreeNode> rights = dfs(i + 1, max);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    ans.add(new TreeNode(i, left, right));
                }
            }
        }
        return ans;
    }
}