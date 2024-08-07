package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/jump-game/">55. Jump Game</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution45
 * @see cn.kingen.oj.leetcode.problem.p1300.Solution1306
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1871
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2297
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2617
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2789
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution55 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean canJump(int[] nums) {
        // rm: the rightmost bound that can be reached
        int rm = nums[0], i = 1, n = nums.length;
        while (i <= rm && i < n) {
            rm = Math.max(rm, i + nums[i]);
            i++;
        }
        return rm >= n - 1;
    }
}