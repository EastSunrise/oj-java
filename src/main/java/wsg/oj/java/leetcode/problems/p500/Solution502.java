package wsg.oj.java.leetcode.problems.p500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 502. IPO (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/ipo/">IPO</a>
 * @since 2021-07-27
 */
public class Solution502 implements Solution {

    /**
     * @complexity T=O((n+k)*log{n})
     * @complexity S=O(n)
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(projects, Comparator.comparingInt(o -> o[1]));

        int i = 0;
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        while (k-- > 0) {
            while (i < n && projects[i][1] <= w) {
                heap.offer(projects[i++][0]);
            }
            if (!heap.isEmpty()) {
                w += heap.remove();
            } else {
                break;
            }
        }
        return w;
    }
}
