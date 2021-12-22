package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution287;

/**
 * 645. Set Mismatch (EASY)
 *
 * @author Kingen
 * @see Solution287
 * @see <a href="https://leetcode-cn.com/problems/set-mismatch/">Set Mismatch</a>
 */
public class Solution645 implements Solution {

    /**
     * Bit calculation.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int[] findErrorNums(int[] nums) {
        int xor = 0, n = nums.length;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int mask = 1;
        while ((xor & 1) == 0) {
            mask <<= 1;
            xor >>>= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & mask) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        for (int num : nums) {
            if (num == a) {
                return new int[]{a, b};
            }
        }
        return new int[]{b, a};
    }
}
