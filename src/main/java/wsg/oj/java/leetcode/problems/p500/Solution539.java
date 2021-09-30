package wsg.oj.java.leetcode.problems.p500;

import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 539. Minimum Time Difference (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-time-difference/">Minimum Time
 * Difference</a>
 * @since 2021-07-20
 */
public class Solution539 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] timestamps = new int[n];
        for (int i = 0; i < n; i++) {
            timestamps[i] = timestamp(timePoints.get(i));
        }
        Arrays.sort(timestamps);
        int min = timestamps[1] - timestamps[0];
        for (int i = 2; i < n; i++) {
            min = Math.min(min, timestamps[i] - timestamps[i - 1]);
        }
        min = Math.min(min, timestamps[0] - timestamps[n - 1] + 24 * 60);
        return min;
    }

    private int timestamp(String timePoint) {
        int timestamp = 0;
        timestamp += timePoint.charAt(0) - '0';
        timestamp = timestamp * 10 + timePoint.charAt(1) - '0';
        timestamp = timestamp * 6 + timePoint.charAt(3) - '0';
        timestamp = timestamp * 10 + timePoint.charAt(4) - '0';
        return timestamp;
    }
}
