package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-if-digit-game-can-be-won/">3232. Find if Digit Game Can Be Won</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1295
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2180

 */
@Question(
    tags = {Tag.ARRAY, Tag.MATH},
    difficulty = Difficulty.EASY
)
public class Solution3232 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean canAliceWin(int[] nums) {
        int singleSum = 0, doubleSum = 0;
        for (int num : nums) {
            if (num < 10) {
                singleSum += num;
            } else {
                doubleSum += num;
            }
        }
        return singleSum != doubleSum;
    }
}