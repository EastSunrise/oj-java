package wsg.oj.java.leetcode.problems.p500;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 523. Continuous Subarray Sum (MEDIUM)
 *
 * @author Kingen
 * @see Solution560
 * @see <a href="https://leetcode-cn.com/problems/continuous-subarray-sum/">Continuous Subarray
 * Sum</a>
 * @since 2021-07-20
 */
class Solution523 implements Solution {

    /**
     * If sum(nums[0,i])≡sum(nums[0,j])(mod k), sum(nums[i+1,j])=nk.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        if (n / 2 >= k) {
            return true;
        }
        // the mapping of i-j means sum[0,j] % k = i
        Map<Integer, Integer> modulo = new HashMap<>(16);
        // remainder = sum[0,i] % k
        int remainder = 0;
        for (int i = 0; i < n; i++) {
            remainder = (remainder + nums[i]) % k;
            if (remainder == 0 && i > 0) {
                // sum[0,i] = nk, i>0
                return true;
            }
            int j = modulo.getOrDefault(remainder, -1);
            if (j == -1) {
                modulo.put(remainder, i);
            } else if (j + 2 <= i) {
                // sum[j+1,i] = nk
                return true;
            }
        }
        return false;
    }
}
