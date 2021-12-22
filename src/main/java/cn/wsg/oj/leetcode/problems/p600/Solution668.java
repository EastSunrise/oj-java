package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution378;

/**
 * 668. Kth Smallest Number in Multiplication Table (HARD)
 *
 * @author Kingen
 * @see Solution378
 * @see Solution719
 * @see Solution786
 * @see <a href="https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/">Kth
 * Smallest Number in Multiplication Table</a>
 */
public class Solution668 implements Solution {

    /**
     * @complexity T=O(m*log{m*n})
     * @complexity S=O(1)
     */
    public int findKthNumber(int m, int n, int k) {
        if (m > n) {
            return findKthNumber(n, m, k);
        }
        int low = 1, high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // find the count of numbers not larger than mid
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
