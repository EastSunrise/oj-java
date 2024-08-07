package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/harshad-number/">3099. Harshad Number</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution3099 {

    @Complexity(time = "O(log x)", space = "O(1)")
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        for (int i = x; i > 0; i /= 10) {
            sum += i % 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}