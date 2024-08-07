package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/">2009. Minimum Number of Operations to Make Array Continuous</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution424
 * @see cn.kingen.oj.leetcode.problem.p500.Solution523
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1040
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1611
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1703
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.BINARY_SEARCH, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.HARD
)
public class Solution2009 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // unique count for duplicate numbers must be replaced
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }
        int ans = n - 1;
        // window nums[i,...,j] contains numbers that don't change
        int i = 0, j = 0;
        while (i < m && j < m) {
            int max = nums[i] + n - 1;
            while (j < m && nums[j] <= max) {
                j++;
            }
            ans = Math.min(ans, n - (j - i));
            i++;
        }
        return ans;
    }
}