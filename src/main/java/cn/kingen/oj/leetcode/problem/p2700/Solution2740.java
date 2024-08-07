package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-value-of-the-partition/">2740. Find the Value of the Partition</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2740 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
}