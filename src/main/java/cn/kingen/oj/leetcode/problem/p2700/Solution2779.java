package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation/">2779. Maximum Beauty of an Array After Applying Operation</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution325
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2294
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.SORTING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution2779 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = 0; j < n; i++) {
            while (j < n && nums[j] - nums[i] <= 2 * k) {
                j++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}