package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.ArrayUtils.findKthSmallest;

/**
 * <a href="https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/">462. Minimum Moves to Equal Array Elements II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution296
 * @see cn.kingen.oj.leetcode.problem.p400.Solution453
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2033
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2171
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2448
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2602
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2967
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution462 {

    /**
     * Finds the median.
     * <p>
     * If the length is even and the two medians are x and y, any integer between x and y are
     * optional.
     */
    @Complexity(time = "O(n)", space = "O(log{n})")
    public int minMoves2(int[] nums) {
        int median = findKthSmallest(nums, (nums.length + 1) / 2);
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - median);
        }
        return ans;
    }
}