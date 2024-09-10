package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/car-fleet/">853. Car Fleet</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1776
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2211
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.SORTING, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.MEDIUM
)
public class Solution853 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Map<Integer, Double> times = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            times.put(position[i], (target - position[i]) / (double) speed[i]);
        }
        Arrays.sort(position);
        int ans = 1;
        double time = times.get(position[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            double curTime = times.get(position[i]);
            if (curTime > time) { // a new fleet that cannot catch up the previous fleet
                time = curTime;
                ans++;
            }
        }
        return ans;
    }
}