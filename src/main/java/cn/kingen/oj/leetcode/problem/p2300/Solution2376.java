package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/count-special-integers/">2376. Count Special Integers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution357
 * @see cn.kingen.oj.leetcode.problem.p400.Solution440
 */
@Question(tags = {Tag.MATH, Tag.DYNAMIC_PROGRAMMING}, difficulty = Difficulty.HARD)
public class Solution2376 {

    @Complexity(time = "O(mD*2^D)", space = "O(m*2^D)", note = "m is the number of digits of n, D is 10")
    public int countSpecialNumbers(int n) {
        String s = String.valueOf(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        int[][] memo = new int[digits.length][1 << 10];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dfs(digits, 0, 0, true, memo);
    }

    private int dfs(int[] digits, int i, int mask, boolean isLimit, int[][] memo) {
        if (i == digits.length) {
            return mask == 0 ? 0 : 1;
        }
        if (!isLimit && memo[i][mask] != -1) {
            return memo[i][mask];
        }

        int cnt = 0;
        if (mask == 0) {
            cnt += dfs(digits, i + 1, mask, false, memo);
            if (i == 0) {
                for (int d = 1; d < digits[i]; d++) {
                    cnt += dfs(digits, i + 1, mask | (1 << d), false, memo);
                }
                cnt += dfs(digits, i + 1, mask | (1 << digits[i]), true, memo);
            } else {
                for (int d = 1; d < 10; d++) {
                    cnt += dfs(digits, i + 1, mask | (1 << d), false, memo);
                }
            }
        } else {
            if (isLimit) {
                for (int d = 0; d < digits[i]; d++) {
                    if ((mask & (1 << d)) == 0) {
                        cnt += dfs(digits, i + 1, mask | (1 << d), false, memo);
                    }
                }
                if ((mask & (1 << digits[i])) == 0) {
                    cnt += dfs(digits, i + 1, mask | (1 << digits[i]), true, memo);
                }
            } else {
                for (int d = 0; d < 10; d++) {
                    if ((mask & (1 << d)) == 0) {
                        cnt += dfs(digits, i + 1, mask | (1 << d), false, memo);
                    }
                }
            }
        }
        if (!isLimit) {
            memo[i][mask] = cnt;
        }
        return cnt;
    }
}