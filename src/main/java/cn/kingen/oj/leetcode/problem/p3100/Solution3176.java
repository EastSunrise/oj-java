package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/">3176. Find the Maximum Length of a Good Subsequence I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution300
 * @see cn.kingen.oj.leetcode.problem.p700.Solution718
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3176 {

    @Complexity(time = "O(n*k)", space = "O(n*k)")
    public int maximumLength(int[] nums, int k) {
        // dp{x:a[t]} is the max length of good subsequences with at most t differences ending with x
        Map<Integer, int[]> dp = new HashMap<>();
        // dpTotal[t]: max length of good subsequences with at most t differences ending with any number
        int[] dpTotal = new int[k + 1];
        for (int x : nums) {
            int[] fp = dp.computeIfAbsent(x, key -> new int[k + 1]);
            for (int t = k; t >= 0; t--) {
                fp[t]++; // ...,x,x
                if (t > 0) { // ...,y,x
                    fp[t] = Math.max(fp[t], dpTotal[t - 1] + 1);
                }
                dpTotal[t] = Math.max(dpTotal[t], fp[t]); // update dpTotal
            }
        }
        return dpTotal[k];
    }
}