package wsg.oj.java.leetcode.problems.p500;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 525. Contiguous Array (MEDIUM)
 *
 * @author Kingen
 * @see Solution325
 * @see <a href="https://leetcode-cn.com/problems/contiguous-array/">Contiguous Array</a>
 * @since 2021-07-20
 */
class Solution525 implements Solution {

    /**
     * If nums[i,j] has the same count of 0's and 1's, nums[0,i-1] and nums[0,j] have the same
     * difference between the count of 1's and that of 0's.
     *
     * @see Solution523
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public int findMaxLength(int[] nums) {
        // d-i: the difference between the count of 1's and that of 0's within nums[0,i]
        Map<Integer, Integer> differences = new HashMap<>();
        int dif = 0, max = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            dif += nums[i] == 1 ? 1 : -1;
            if (dif == 0) {
                // nums[0,i] has the same count of 0's and 1's
                max = Math.max(max, i + 1);
                continue;
            }
            Integer j = differences.get(dif);
            if (j != null) {
                // nums[j+1,i] has the same count of 0's and 1's
                max = Math.max(max, i - j);
            } else {
                differences.put(dif, i);
            }
        }
        return max;
    }
}
