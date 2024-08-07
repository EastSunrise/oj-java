package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/">2789. Largest Element in an Array after Merge Operations</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution55
 * @see cn.kingen.oj.leetcode.problem.p100.Solution198
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1646
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM
)
public class Solution2789 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long maxArrayValue(int[] nums) {
        long next = nums[nums.length - 1], max = next;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= next) {
                next += nums[i];
            } else {
                next = nums[i];
            }
            max = Math.max(max, next);
        }
        return max;
    }
}