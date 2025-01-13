package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-ways-to-split-array/">2270. Number of Ways to Split Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution410
 * @see cn.kingen.oj.leetcode.problem.p700.Solution724
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1712
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1991
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2035
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2256

 */
@Question(
        tags = {Tag.ARRAY, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM,
        daily = "2025-01-13"
)
public class Solution2270 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, ans = 0;
        long left = 0, right = 0;
        for (int num : nums) {
            right += num;
        }
        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            right -= nums[i];
            if (left >= right) {
                ans++;
            }
        }
        return ans;
    }
}