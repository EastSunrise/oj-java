package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import cn.kingen.oj.leetcode.util.ArrayUtils;

/**
 * <a href="https://leetcode.cn/problems/next-permutation/">31. Next Permutation</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution46
 * @see cn.kingen.oj.leetcode.problem.p0.Solution47
 * @see cn.kingen.oj.leetcode.problem.p0.Solution60
 * @see cn.kingen.oj.leetcode.problem.p200.Solution267
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS},
        difficulty = Difficulty.MEDIUM
)
public class Solution31 {

    @Complexity(time = "O(n)", space = "O(1)")
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }

        // find the longest subarray which is in ascending order from the end
        int k = n - 1;
        while (k > 0 && nums[k - 1] >= nums[k]) {
            k--;
        }

        // rearrange the subarray from descending order to ascending order with two pointers
        for (int i = k, j = n - 1; i < j; i++, j--) {
            ArrayUtils.swap(nums, i, j);
        }

        if (k > 0) {
            // find the smallest number from the subarray strictly larger than nums[k-1]
            // and then swap the two numbers
            int i = k, j = n - 1, target = nums[k - 1];
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] <= target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            int temp = nums[k - 1];
            nums[k - 1] = nums[i];
            nums[i] = temp;
        }
    }
}