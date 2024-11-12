package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-i/">3254. Find the Power of K-Size Subarrays I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2461
 */
@Question(
        tags = {Tag.ARRAY, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution3254 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0, j = 0; j < n; j++) {
            if (j > i && nums[j - 1] + 1 != nums[j]) { // nums[i,j] is valid
                i = j;
            }
            if (j >= k - 1) {
                ans[j - k + 1] = j - i + 1 >= k ? nums[j] : -1;
            }
        }
        return ans;
    }
}