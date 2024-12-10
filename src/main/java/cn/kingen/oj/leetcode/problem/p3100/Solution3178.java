package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-child-who-has-the-ball-after-k-seconds/">3178. Find the Child Who Has the Ball After K Seconds</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2682
 */
@Question(
        tags = {Tag.MATH, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution3178 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int numberOfChild(int n, int k) {
        k %= (2 * n - 2);
        return k <= n - 1 ? k : 2 * n - 2 - k;
    }
}