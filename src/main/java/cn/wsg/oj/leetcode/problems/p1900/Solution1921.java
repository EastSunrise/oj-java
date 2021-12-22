package cn.wsg.oj.leetcode.problems.p1900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 1921. Eliminate Maximum Number of Monsters (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/eliminate-maximum-number-of-monsters/">Eliminate
 * Maximum Number of Monsters</a>
 */
public class Solution1921 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_N
     */
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(times);
        for (int i = 0; i < n; i++) {
            if (times[i] <= i) {
                return i;
            }
        }
        return n;
    }
}
