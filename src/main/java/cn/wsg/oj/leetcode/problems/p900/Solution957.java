package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 957. Prison Cells After N Days (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/prison-cells-after-n-days/">Prison Cells After N
 * Days</a>
 */
public class Solution957 implements Solution {

    /**
     * @complexity T=O(8)
     */
    public int[] prisonAfterNDays(int[] cells, int n) {
        int num = 0;
        for (int i = 0; i < 8; i++) {
            num = (num << 1) + cells[i];
        }
        int mask = 0b01111110;
        n %= 14;
        n = n == 0 ? 14 : n;
        while (n-- > 0) {
            num = ~(num << 1 ^ num >> 1) & mask;
        }
        for (int i = 7; i >= 0; i--) {
            cells[i] = num & 1;
            num >>= 1;
        }
        return cells;
    }
}
