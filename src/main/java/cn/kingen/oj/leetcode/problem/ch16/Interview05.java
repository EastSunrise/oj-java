package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/factorial-zeros-lcci/">面试题 16.05. Factorial Zeros LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Interview05 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}