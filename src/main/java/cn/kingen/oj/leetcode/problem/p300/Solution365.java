package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.gcd;

/**
 * <a href="https://leetcode.cn/problems/water-and-jug-problem/">365. Water and Jug Problem</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution365 {

    /**
     * The integer solutions of the equation ax+by=c. The equation has integer solutions if and only if gcd(x,y)|c.
     */
    @Complexity(time = "O(1)", space = "O(1)")
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }
        return target % gcd(x, y) == 0;
    }
}