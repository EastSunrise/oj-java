package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/">600. Non-negative Integers without Consecutive Ones</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution198
 * @see cn.kingen.oj.leetcode.problem.p200.Solution213
 * @see cn.kingen.oj.leetcode.problem.p400.Solution474
 */
@Question(tags = {Tag.DYNAMIC_PROGRAMMING}, difficulty = Difficulty.HARD)
public class Solution600 {

    @Complexity(time = "O(C)", space = "O(C)", note = "C is 32")
    public int findIntegers(int n) {
        // dp[i]: the number of non-negative integers without consecutive ones between 0 and 2^(i-1)-1.
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int prev = 0, cnt = 0, i = 29;
        while (i >= 0) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                cnt += dp[i + 1];
                if (prev == 1) {
                    break;
                }
                prev = 1;
            } else {
                prev = 0;
            }
            i--;
        }
        return i < 0 ? cnt + 1 : cnt;
    }
}