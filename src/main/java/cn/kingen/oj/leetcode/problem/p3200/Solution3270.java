package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-key-of-the-numbers/">3270. Find the Key of the Numbers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution179
 */
@Question(
    tags = {Tag.MATH},
    difficulty = Difficulty.EASY,
    daily = "2025-01-11"
)
public class Solution3270 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0;
        for (int i = 1000; i > 0; i /= 10) {
            ans = ans * 10 + Math.min(num1 / i, Math.min(num2 / i, num3 / i));
            num1 %= i;
            num2 %= i;
            num3 %= i;
        }
        return ans;
    }
}