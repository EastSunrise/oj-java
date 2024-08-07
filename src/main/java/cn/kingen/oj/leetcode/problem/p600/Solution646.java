package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-of-pair-chain/">646. Maximum Length of Pair Chain</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution300
 * @see cn.kingen.oj.leetcode.problem.p400.Solution491
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution646 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
        int count = 1, right = pairs[0][1];
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > right) {
                count++;
                right = pairs[i][1];
            }
        }
        return count;
    }
}