package cn.kingen.oj.leetcode.problem.p1000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/convert-to-base-2/">1017. Convert to Base -2</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1256
 */
@Question(
        tags = {Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution1017 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }

        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            ans.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return ans.reverse().toString();
    }
}