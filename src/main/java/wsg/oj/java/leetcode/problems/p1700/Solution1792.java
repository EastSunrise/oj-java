package wsg.oj.java.leetcode.problems.p1700;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1792. Maximum Average Pass Ratio (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-average-pass-ratio/">Maximum Average Pass
 * Ratio</a>
 * @since 2021-07-27
 */
public class Solution1792 implements Solution {

    /**
     * @complexity T=((n+k)*log{n}), k=extra students
     * @complexity S=O(n)
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        Queue<int[]> queue = new PriorityQueue<>(n,
            Comparator.comparingDouble(c -> (c[1] + 1.0) * c[1] / (c[1] - c[0])));
        for (int[] clazz : classes) {
            queue.offer(clazz);
        }
        while (extraStudents-- > 0) {
            int[] clazz = queue.remove();
            clazz[0]++;
            clazz[1]++;
            queue.offer(clazz);
        }
        double ratio = 0.0;
        for (int[] clazz : classes) {
            ratio += clazz[0] * 1.0 / clazz[1];
        }
        return ratio / n;
    }
}
