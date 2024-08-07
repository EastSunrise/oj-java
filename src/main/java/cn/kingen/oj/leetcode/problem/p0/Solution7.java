package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/reverse-integer/">7. Reverse Integer</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution8
 * @see cn.kingen.oj.leetcode.problem.p100.Solution190
 */
@Question(
        tags = {Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution7 {

    @Complexity(time = "O(log{x})", space = "O(1)")
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean positive = x > 0;
        int limit = positive ? -Integer.MAX_VALUE : Integer.MIN_VALUE;
        int mulLimit = limit / 10;
        x = positive ? -x : x; // handle as negative
        int reverse = 0;
        for (; x < 0; x /= 10) {
            int digit = x % 10;
            if (reverse < mulLimit) { // exceed the limit
                return 0;
            }
            reverse *= 10;
            if (reverse < limit - digit) { // exceed the limit
                return 0;
            }
            reverse += digit;
        }
        return positive ? -reverse : reverse;
    }
}