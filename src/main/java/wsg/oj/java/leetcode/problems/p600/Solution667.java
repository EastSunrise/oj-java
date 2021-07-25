package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution526;

/**
 * 667. Beautiful Arrangement II (MEDIUM)
 *
 * @author Kingen
 * @see Solution526
 * @see <a href="https://leetcode-cn.com/problems/beautiful-arrangement-ii/">Beautiful Arrangement
 * II</a>
 * @since 2021-07-23
 */
public class Solution667 implements Solution {

    /**
     * Constructs the array like: 1,k+1,2,k,3,k-1,4,k-2,...,k/2, k+2,k+3,...,n.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int i = 0, low = 1, high = k + 1;
        while (low < high) {
            res[i++] = low++;
            res[i++] = high--;
        }
        if (low == high) {
            res[i++] = low;
        }
        int val = k + 2;
        while (i < n) {
            res[i++] = val++;
        }
        return res;
    }
}
