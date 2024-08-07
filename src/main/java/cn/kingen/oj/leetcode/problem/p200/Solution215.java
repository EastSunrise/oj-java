package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.ArrayUtils.findKthSmallest;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">215. Kth Largest Element in an Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution324
 * @see cn.kingen.oj.leetcode.problem.p300.Solution347
 * @see cn.kingen.oj.leetcode.problem.p400.Solution414
 * @see cn.kingen.oj.leetcode.problem.p700.KthLargest
 * @see cn.kingen.oj.leetcode.problem.p900.Solution973
 */
@Question(
        tags = {Tag.ARRAY, Tag.DIVIDE_AND_CONQUER, Tag.QUICKSELECT, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution215 {

    @Complexity(time = "O(n)", space = "O(log{n})")
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, nums.length - k + 1);
    }
}