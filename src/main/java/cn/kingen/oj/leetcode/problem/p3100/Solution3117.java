package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-sum-of-values-by-dividing-array/">3117. Minimum Sum of Values by Dividing Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2547
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2578
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.SEGMENT_TREE, Tag.QUEUE, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution3117 {

    @Complexity(time = "O(nm*log{U})", space = "O(nm*log{U})", note = "U is the maximum value of nums")
    public int minimumValueSum(int[] nums, int[] andValues) {
        int ans = dfs(new HashMap<>(), nums, andValues, 0, 0, 0x3fffffff);
        return ans >= 0x3fffffff ? -1 : ans;
    }

    private int dfs(Map<Long, Integer> memo, int[] nums, int[] andValues, int i, int j, int sum) {
        if (i >= nums.length && j >= andValues.length) { // find a solution
            return 0;
        }
        if (j >= andValues.length || nums.length - i < andValues.length - j) { // no enough andValues
            return 0x3fffffff;
        }

        long mask = (long) sum << 24 | (long) i << 4 | j;
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }

        sum &= nums[i];
        int res = dfs(memo, nums, andValues, i + 1, j, sum); // skip
        if (sum == andValues[j]) { // split
            res = Math.min(res, dfs(memo, nums, andValues, i + 1, j + 1, 0x3fffffff) + nums[i]);
        }
        memo.put(mask, res);
        return res;
    }
}