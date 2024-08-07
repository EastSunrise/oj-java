package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-increment-to-make-array-unique/">945. Minimum Increment to Make Array Unique</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2233
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.COUNTING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution945 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }
}