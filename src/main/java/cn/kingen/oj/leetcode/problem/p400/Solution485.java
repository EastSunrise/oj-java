package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones/">485. Max Consecutive Ones</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution487
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1004
 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution485 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, ans = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                ans = Math.max(count, ans);
                count = 0;
            }
        }
        return Math.max(count, ans);
    }
}