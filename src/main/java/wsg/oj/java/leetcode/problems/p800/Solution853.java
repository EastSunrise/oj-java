package wsg.oj.java.leetcode.problems.p800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 853. Car Fleet (MEDIUM)
 *
 * @author Kingen
 * @see Solution1776
 * @see <a href="https://leetcode-cn.com/problems/car-fleet/">Car Fleet</a>
 * @since 2021-07-26
 */
public class Solution853 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Map<Integer, Double> times = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            times.put(position[i], (target - position[i]) / (double) speed[i]);
        }
        Arrays.sort(position);
        int fleets = 1;
        double prevTime = times.get(position[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            double curTime = times.get(position[i]);
            if (curTime > prevTime) {
                prevTime = curTime;
                fleets++;
            }
        }
        return fleets;
    }
}
