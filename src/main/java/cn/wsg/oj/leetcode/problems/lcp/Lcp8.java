package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * LCP 8. 剧情触发时间 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/ju-qing-hong-fa-shi-jian/">剧情触发时间</a>
 */
public class Lcp8 implements Solution {

    /**
     * @complexity T=O(n*log{m})
     * @complexity S=O(1)
     */
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int m = increase.length, n = requirements.length;
        for (int i = 1; i < m; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            int[] rq = requirements[i];
            if (rq[0] == 0 && rq[1] == 0 && rq[2] == 0) {
                times[i] = 0;
            } else {
                int idx = Arrays.binarySearch(increase, rq, (a1, a2) -> {
                    if (a1[0] < a2[0] || a1[1] < a2[1] || a1[2] < a2[2]) {
                        return -1;
                    }
                    if (a1[0] == a2[0] && a1[1] == a2[1] && a1[2] == a2[2]) {
                        return 0;
                    }
                    return 1;
                });
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                times[i] = idx == m ? -1 : idx + 1;
            }
        }
        return times;
    }
}
