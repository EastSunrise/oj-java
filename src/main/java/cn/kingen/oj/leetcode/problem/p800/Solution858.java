package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.gcd;

/**
 * <a href="https://leetcode.cn/problems/mirror-reflection/">858. Mirror Reflection</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.MATH, Tag.NUMBER_THEORY},
        difficulty = Difficulty.MEDIUM
)
public class Solution858 {

    @Complexity(time = "O(log{p})", space = "O(1)")
    public int mirrorReflection(int p, int q) {
        int gcd = gcd(p, q);
        int lcm = p * q / gcd;
        return (lcm / p) % 2 == 0 ? 0 : (lcm / q) % 2 == 0 ? 2 : 1;
    }
}