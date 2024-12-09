package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/determine-color-of-a-chessboard-square/">1812. Determine Color of a Chessboard Square</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3200.Solution3274
 */
@Question(
        tags = {Tag.MATH, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution1812 {

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a', y = coordinates.charAt(1) - '1';
        return ((x + y) & 1) != 0;
    }
}