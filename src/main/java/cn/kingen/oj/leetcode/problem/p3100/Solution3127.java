package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/make-a-square-with-the-same-color/">3127. Make a Square with the Same Color</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.ENUMERATION, Tag.MATRIX},
    difficulty = Difficulty.EASY
)
public class Solution3127 {

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean canMakeSquare(char[][] grid) {
        for (int l = 0; l < 2; l++) {
            for (int t = 0; t < 2; t++) {
                int b = 0;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        b += grid[l + i][t + j] == 'B' ? 1 : 0;
                    }
                }
                if (b != 2) {
                    return true;
                }
            }
        }
        return false;
    }
}