package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-maximum-achievable-number/">2769. Find the Maximum Achievable Number</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution2769 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int theMaximumAchievableX(int num, int t) {
        return num + t * 2;
    }
}