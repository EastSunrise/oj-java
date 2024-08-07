package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/">35. Search Insert Position</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution278
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.EASY
)
public class Solution35 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midV = nums[mid];
            if (midV < target) {
                low = mid + 1;
            } else if (midV > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}