package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/">2529. Maximum Count of Positive Integer and Negative Integer</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution704
 * @see cn.kingen.oj.leetcode.problem.p1300.Solution1351
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.COUNTING},
        difficulty = Difficulty.EASY
)
public class Solution2529 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int i = binarySearchFirst(nums, 0);
        int j = binarySearchFirst(nums, 1);
        return Math.max(i, n - j);
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}