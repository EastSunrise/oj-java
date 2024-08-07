package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.ArrayUtils.swap;

/**
 * <a href="https://leetcode.cn/problems/rotate-array/">189. Rotate Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution61
 * @see cn.kingen.oj.leetcode.problem.p100.Solution186
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2607
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.TWO_POINTERS},
        difficulty = Difficulty.MEDIUM
)
public class Solution189 {

    /**
     * Reverses the array, the left k numbers and the right remaining numbers respectively.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }
}