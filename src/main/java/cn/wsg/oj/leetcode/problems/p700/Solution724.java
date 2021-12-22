package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p500.Solution560;

/**
 * 724. Find Pivot Index (EASY)
 *
 * @author Kingen
 * @see Solution560
 * @see <a href="https://leetcode-cn.com/problems/find-pivot-index/">Find Pivot Index</a>
 */
public class Solution724 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int pivotIndex(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            right += nums[i];
        }
        int i = 0;
        while (i < n - 1) {
            if (left == right) {
                return i;
            }
            left += nums[i];
            i++;
            right -= nums[i];
        }
        return left == right ? i : -1;
    }
}
