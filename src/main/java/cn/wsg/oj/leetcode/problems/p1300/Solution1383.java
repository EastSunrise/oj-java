package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1383. Maximum Performance of a Team (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-performance-of-a-team/">Maximum
 * Performance of a Team</a>
 */
public class Solution1383 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_N
     */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }
        Arrays.sort(engineers, Comparator.comparingInt(o -> o[1]));
        Queue<Integer> speeds = new PriorityQueue<>(k);
        long sum = 0, max = 0;
        for (int i = n - 1; i >= 0; i--) {
            // choose engineer[i] and k-1 engineers with maximal speeds from engineer[i+1,n-1]
            if (speeds.size() == k) {
                sum -= speeds.remove();
            }
            sum += engineers[i][0];
            max = Math.max(max, sum * engineers[i][1]);
            speeds.offer(engineers[i][0]);
        }
        return (int) (max % MOD);
    }
}
