package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/2-keys-keyboard/">650. 2 Keys Keyboard</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution651
 * @see cn.kingen.oj.leetcode.problem.p900.Solution991
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2507
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2521
 */
@Question(
        tags = {Tag.MATH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution650 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public int minSteps(int n) {
        int steps = 0, p = 2;
        while (n > 1) {
            while (n % p == 0) {
                steps += p;
                n /= p;
            }
            p++;
        }
        return steps;
    }
}