package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.ArrayUtils.longestIncreasingSubsequence;

/**
 * <a href="https://leetcode.cn/problems/russian-doll-envelopes/">354. Russian Doll Envelopes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution300
 */
@Question(tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING}, difficulty = Difficulty.HARD)
public class Solution354 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }
        return longestIncreasingSubsequence(heights);
    }
}