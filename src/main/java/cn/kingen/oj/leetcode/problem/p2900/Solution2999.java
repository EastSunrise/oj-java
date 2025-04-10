package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-powerful-integers/">2999. Count the Number of Powerful
 * Integers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution970
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1012
 */
@Question(
    tags = {Tag.MATH, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.HARD,
    date = "2025-04-10"
)
public class Solution2999 {

    @Complexity(time = "O(n)", space = "O(n)", note = "n is the digit length of 'finish'")
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long mask = (long) Math.pow(10, s.length());
        long suf = Long.parseLong(s);
        start = start % mask > suf ? start / mask + 1 : start / mask;
        finish = finish % mask < suf ? finish / mask - 1 : finish / mask;
        if (start > finish) {
            return 0;
        }
        if (start == 0) {
            return count(finish, limit);
        }
        return count(finish, limit) - count(start - 1, limit);
    }

    private long count(long target, int limit) {
        String s = Long.toString(target);
        int n = s.length();
        boolean exact = true;
        long dp = 1;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (exact) {
                dp = Math.min(d, limit) + 1 + (dp - 1) * (limit + 1);
            } else {
                dp = dp * (limit + 1);
            }
            exact &= d <= limit;
        }
        return dp;
    }
}