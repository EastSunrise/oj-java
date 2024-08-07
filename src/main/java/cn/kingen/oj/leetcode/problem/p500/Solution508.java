package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/most-frequent-subtree-sum/">508. Most Frequent Subtree Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution572
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1973
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.HASH_TABLE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution508 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sums = new HashMap<>(16);
        dfs(root, sums);
        List<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
            int count = entry.getValue();
            if (count > max) {
                max = count;
                ans.clear();
                ans.add(entry.getKey());
            } else if (count == max) {
                ans.add(entry.getKey());
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode t, Map<Integer, Integer> sums) {
        if (t == null) {
            return 0;
        }
        int left = dfs(t.left, sums);
        int right = dfs(t.right, sums);
        int sum = t.val + left + right;
        sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        return sum;
    }
}