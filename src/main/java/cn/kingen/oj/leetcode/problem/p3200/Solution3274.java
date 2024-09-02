package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color/">3274. Check if Two Chessboard Squares Have the Same Color</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.EASY
)
public class Solution3274 {

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int x1 = coordinate1.charAt(0) - 'a', y1 = coordinate1.charAt(1) - '1';
        int x2 = coordinate2.charAt(0) - 'a', y2 = coordinate2.charAt(1) - '1';
        return (x1 + y1) % 2 == (x2 + y2) % 2;
    }
}