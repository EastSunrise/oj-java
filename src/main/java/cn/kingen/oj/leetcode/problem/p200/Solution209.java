package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209. Minimum Size Subarray Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution76
 * @see cn.kingen.oj.leetcode.problem.p300.Solution325
 * @see cn.kingen.oj.leetcode.problem.p700.Solution718
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.PREFIX_SUM, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution209 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0, ans = Integer.MAX_VALUE;
        // slide a window nums[i, j)
        for (int i = 0, j = 0; ; ) {
            if (sum < target) {
                if (j == n) {
                    break;
                }
                sum += nums[j++];
            } else {
                ans = Math.min(ans, j - i);
                sum -= nums[i++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}