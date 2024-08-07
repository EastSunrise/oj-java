package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-ii/">2972. Count the Number of Incremovable Subarrays II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1574
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH},
        difficulty = Difficulty.HARD
)
public class Solution2972 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        if (i == n) {
            return (long) n * (n + 1) / 2;
        }

        long ans = i + 1; // start with 0 or 1 or ... or i, end with n-1
        i--;
        for (int j = n - 2; j >= 0; j--) {
            int mid = nums[j + 1];
            while (i >= 0 && nums[i] >= mid) {
                i--;
            }
            ans += i + 2; // start with 0 or 1 or ... or i+1, end with j
            if (nums[j] >= nums[j + 1]) {
                break;
            }
        }
        return ans;
    }
}