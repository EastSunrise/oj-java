package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.ArrayUtils.longestIncreasingSubsequence;

/**
 * <a href="https://leetcode.cn/problems/circus-tower-lcci/">面试题 17.08. Circus Tower LCCI</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution354
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Interview08 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> weight[i] == weight[j] ? height[j] - height[i] : weight[i] - weight[j]);

        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = height[indices[i]];
        }
        return longestIncreasingSubsequence(sorted);
    }
}