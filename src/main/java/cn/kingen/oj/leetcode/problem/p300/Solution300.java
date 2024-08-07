package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.ArrayUtils.longestIncreasingSubsequence;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution334
 * @see cn.kingen.oj.leetcode.problem.p300.Solution354
 * @see cn.kingen.oj.leetcode.problem.p600.Solution646
 * @see cn.kingen.oj.leetcode.problem.p600.Solution673
 * @see cn.kingen.oj.leetcode.problem.p700.Solution712
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution300 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int lengthOfLIS(int[] nums) {
        return longestIncreasingSubsequence(nums);
    }
}