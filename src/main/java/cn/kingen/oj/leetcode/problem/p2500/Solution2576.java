package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-maximum-number-of-marked-indices/">2576. Find the Maximum Number of Marked Indices</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2856
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2576 {

    @Complexity(time = "O(nlogn)", space = "O(1)")
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums.length / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(nums, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high * 2;
    }

    private boolean check(int[] nums, int k) {
        for (int i = 0, j = nums.length - k; i < k; i++, j++) {
            if (nums[i] * 2 > nums[j]) {
                return false;
            }
        }
        return true;
    }
}