package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/rectangle-overlap/">836. Rectangle Overlap</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution223
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution836 {

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec1[2] && rec1[1] < rec1[3] && rec2[0] < rec2[2] && rec2[1] < rec2[3] &&
                rec1[0] < rec2[2] && rec1[2] > rec2[0] && rec1[1] < rec2[3] && rec1[3] > rec2[1];
    }
}