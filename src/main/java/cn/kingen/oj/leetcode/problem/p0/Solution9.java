package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/palindrome-number/">9. Palindrome Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution234
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2217
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2396
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2843
 */
@Question(
        tags = {Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution9 {

    /**
     * Reverses the right half of x and compares with the left half.
     */
    @Complexity(time = "O(log{x})", space = "O(1)")
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int reversed = 0;
        do {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        } while (x > reversed);
        return x == reversed || x == reversed / 10;
    }
}