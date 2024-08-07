package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/total-distance-traveled/">2739. Total Distance Traveled</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution2739 {

    @Complexity(time = "O(log{mainTank})", space = "O(1)")
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank >= 5) {
            int count = mainTank / 5;
            ans += count * 50;

            int transfer = Math.min(count, additionalTank);
            mainTank = mainTank % 5 + transfer;
            additionalTank -= transfer;
        }
        return ans + mainTank * 10;
    }
}