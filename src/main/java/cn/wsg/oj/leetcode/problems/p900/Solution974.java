package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p500.Solution560;

/**
 * 974. Subarray Sums Divisible by K (MEDIUM)
 *
 * @author Kingen
 * @see Solution560
 * @see Solution1590
 * @see <a href="https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/">Subarray Sums
 * Divisible by K</a>
 */
public class Solution974 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_M
     */
    public int subarraysDivByK(int[] nums, int m) {
        int[] modules = new int[m];
        modules[0] = 1;
        int sum = 0, res = 0;
        for (int num : nums) {
            sum = Math.floorMod(sum + num, m);
            res += modules[sum];
            modules[sum]++;
        }
        return res;
    }
}
