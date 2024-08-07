package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/string-to-integer-atoi/">8. String to Integer (atoi)</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution7
 * @see cn.kingen.oj.leetcode.problem.p0.Solution65
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution8 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        boolean positive = true;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            positive = false;
            i++;
        }

        int limit = positive ? -Integer.MAX_VALUE : Integer.MIN_VALUE;
        int mulLimit = limit / 10;
        int value = 0; // handle as negative
        for (; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d < 0 || d > 9) {
                break;
            }
            if (value < mulLimit) { // exceed limit
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value *= 10;
            if (value < limit + d) { // exceed limit
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value -= d;
        }
        return positive ? -value : value;
    }
}