package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-i/">3461. Check If Digits Are Equal in String After Operations I</a>
 *
 * @author Kingen

 */
@Question(
        difficulty = Difficulty.EASY,
        contest = 438
)
public class Solution3461 {

    @Complexity(time = "O(n)", space = "O(n)")
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        while (n > 2) {
            for (int i = 1; i < n; i++) {
                digits[i - 1] = (digits[i - 1] + digits[i]) % 10;
            }
            n--;
        }
        return digits[0] == digits[1];
    }
}