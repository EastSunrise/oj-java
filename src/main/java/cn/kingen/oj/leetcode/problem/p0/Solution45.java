package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii/">45. Jump Game II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution55
 * @see cn.kingen.oj.leetcode.problem.p1300.Solution1306
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1871
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2297
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2617
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2770
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2786
 */
@Question(
    tags = {Tag.GREEDY, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.MEDIUM,
    daily = "2025-01-27"
)
public class Solution45 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        // rm: the rightmost position that can be reached after 'step' steps
        // nrm: the next 'rm'
        int step = 0, rm = 0, nrm = nums[0], target = n - 1;
        for (int i = 1; i < n; i++) {
            if (nrm >= target) {
                return step + 1;
            }
            if (i > rm) {
                step++;
                rm = nrm;
            }
            nrm = Math.max(nrm, i + nums[i]);
        }
        throw new IllegalArgumentException("Can't reach the end of the array");
    }
}