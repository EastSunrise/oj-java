package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-subarray-with-bitwise-or-closest-to-k/">3171. Find Subarray With Bitwise OR Closest to K</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3117
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.SEGMENT_TREE, Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.HARD
)
public class Solution3171 {

    @Complexity(time = "O(n*log(C))", space = "O(1)", note = "C is the maximum value of nums")
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x - k)); // only nums[i]
            for (int j = i - 1; j >= 0; j--) {
                int or = nums[j] | x;
                if (nums[j] == or) { // x is a binary-subset of nums[j]
                    break;
                }
                nums[j] = or; // nums[j] = OR(nums[j,...,i])
                ans = Math.min(ans, Math.abs(or - k));
            }
        }
        return ans;
    }
}