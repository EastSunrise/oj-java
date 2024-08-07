package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/">2903. Find Indices With Index and Value Difference I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS},
        difficulty = Difficulty.EASY
)
public class Solution2903 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int mini = 0, maxi = 0;
        for (int j = indexDifference; j < n; j++) {
            int i = j - indexDifference;
            if (nums[i] < nums[mini]) {
                mini = i;
            } else if (nums[i] > nums[maxi]) {
                maxi = i;
            }
            if (Math.abs(nums[j] - nums[mini]) >= valueDifference) {
                return new int[]{mini, j};
            }
            if (Math.abs(nums[j] - nums[maxi]) >= valueDifference) {
                return new int[]{maxi, j};
            }
        }
        return new int[]{-1, -1};
    }
}