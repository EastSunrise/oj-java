package cn.kingen.oj.leetcode.problem.p1900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-weeks-for-which-you-can-work/">1953. Maximum Number of Weeks for Which You Can Work</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution621
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM
)
public class Solution1953 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long numberOfWeeks(int[] milestones) {
        long max = 0, sum = 0;
        for (int milestone : milestones) {
            max = Math.max(max, milestone);
            sum += milestone;
        }
        long rest = sum - max;
        return max <= rest + 1 ? sum : 2 * rest + 1;
    }
}