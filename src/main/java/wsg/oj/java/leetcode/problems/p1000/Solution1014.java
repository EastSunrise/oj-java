package wsg.oj.java.leetcode.problems.p1000;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1014. Best Sightseeing Pair (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/best-sightseeing-pair/">Best Sightseeing Pair</a>
 * @since 2021-07-27
 */
public class Solution1014 implements Solution {

    public int maxScoreSightseeingPair(int[] values) {
        // imax: the max value of values[i]+i when i<j
        int imax = values[0], max = 0, n = values.length;
        for (int j = 1; j < n; j++) {
            max = Math.max(max, imax + values[j] - j);
            imax = Math.max(imax, values[j] + j);
        }
        return max;
    }
}
