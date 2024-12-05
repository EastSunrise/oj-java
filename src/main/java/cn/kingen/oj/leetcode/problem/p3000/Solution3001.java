package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-moves-to-capture-the-queen/">3001. Minimum Moves to Capture The Queen</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution999
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1222
 */
@Question(
        tags = {Tag.ARRAY, Tag.ENUMERATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution3001 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && (c != e || (d < b && d < f) || (d > b && d > f))) {
            return 1;
        }
        if (b == f && (d != f || (c < a && c < e) || (c > a && c > e))) {
            return 1;
        }
        if (c - d == e - f && (a - b != e - f || (a < c && a < e) || (a > c && a > e))) {
            return 1;
        }
        if (c + d == e + f && (a + b != e + f || (a < c && a < e) || (a > c && a > e))) {
            return 1;
        }
        return 2;
    }
}