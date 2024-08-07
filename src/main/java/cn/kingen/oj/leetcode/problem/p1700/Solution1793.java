package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-score-of-a-good-subarray/">1793. Maximum Score of a Good Subarray</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution84
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.HARD
)
public class Solution1793 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maximumScore(int[] nums, int k) {
        int i = k - 1, j = k + 1, n = nums.length;
        int min = nums[k], ans = 0;
        do {
            while (true) {
                if (i >= 0 && nums[i] >= min) {
                    i--;
                } else if (j < n && nums[j] >= min) {
                    j++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, min * (j - i - 1));
            min = Math.max(i >= 0 ? nums[i] : -1, j < n ? nums[j] : -1);
        } while (min >= 0);
        return ans;
    }
}