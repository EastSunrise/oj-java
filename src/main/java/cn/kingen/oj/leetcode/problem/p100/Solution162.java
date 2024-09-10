package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-peak-element/">162. Find Peak Element</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution852
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1901
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2137
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2210
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2951
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution162 {

    @Complexity(time = "O(log(n))", space = "O(1)")
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}