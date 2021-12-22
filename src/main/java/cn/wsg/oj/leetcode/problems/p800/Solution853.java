package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 853. Car Fleet (MEDIUM)
 *
 * @author Kingen
 * @see Solution1776
 * @see <a href="https://leetcode-cn.com/problems/car-fleet/">Car Fleet</a>
 */
public class Solution853 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_N
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
