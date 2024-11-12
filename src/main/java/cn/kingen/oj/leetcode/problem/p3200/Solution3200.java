package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-height-of-a-triangle/">3200. Maximum Height of a Triangle</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.ENUMERATION},
        difficulty = Difficulty.EASY
)
public class Solution3200 {

    @Complexity(time = "O(sqrt(n))", space = "O(1)")
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(maxHeight(red, blue), maxHeight(blue, red));
    }

    private int maxHeight(int odd, int even) {
        int row = 1;
        for (; ; ) {
            if (row % 2 == 1) {
                if (odd >= row) {
                    odd -= row;
                    row++;
                } else {
                    return row - 1;
                }
            } else {
                if (even >= row) {
                    even -= row;
                    row++;
                } else {
                    return row - 1;
                }
            }
        }
    }
}