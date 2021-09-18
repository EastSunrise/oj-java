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
public class Solution525 implements Solution {

    /**
     * @see Solution523
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public int findMaxLength(int[] nums) {
        // the indices of prefix sums regarding 0 as -1
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);
        int sum = 0, max = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i] * 2 - 1;
            Integer j = prefixSums.get(sum);
            if (j != null) {
                // the sum of nums[j+1,i] is 0
                // which means that the subarray has the same count of 0's and 1's
                max = Math.max(max, i - j);
            } else {
                prefixSums.put(sum, i);
            }
        }
        return max;
    }
}
