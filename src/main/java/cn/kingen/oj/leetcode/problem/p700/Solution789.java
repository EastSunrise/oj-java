package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/escape-the-ghosts/">789. Escape The Ghosts</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1728
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution789 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= dist) {
                return false;
            }
        }
        return true;
    }
}