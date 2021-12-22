package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * LCP 12. 小张刷题计划 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua/">小张刷题计划</a>
 */
public class Lcp12 implements Solution {

    /**
     * @complexity T=O(32*n), n=the number of problems
     * @complexity S=O(1)
     */
    public int minTime(int[] time, int m) {
        int low = 0, high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (days(time, mid) <= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int days(int[] times, int limit) {
        int days = 0, sum = 0, max = 0;
        for (int time : times) {
            sum += time;
            max = Math.max(max, time);
            if (sum - max > limit) {
                days++;
                sum = max = time;
            }
        }
        return days + 1;
    }
}
