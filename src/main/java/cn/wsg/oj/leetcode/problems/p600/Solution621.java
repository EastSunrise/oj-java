package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p700.Solution767;

/**
 * 621. Task Scheduler (MEDIUM)
 *
 * @author Kingen
 * @see Solution358
 * @see Solution767
 * @see <a href="https://leetcode-cn.com/problems/task-scheduler/">Task Scheduler</a>
 */
public class Solution621 implements Solution {

    /**
     * Supposes that tasks=A,A,A,B,B,B,C,D,.., which has three for A,B and one for each other
     * letter. The length of tasks is m.
     * <p>
     * Arrange the tasks like: A-B-···-A-B-···-A-B where each interval between A-B's has <i>n-1 or
     * more</i> positions to insert other letters. So the time is the larger one between m and
     * (3-1)*(n+1)+2.
     *
     * @complexity T=O(m+26)
     * @complexity S=O(26)
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        int max = counts[0], count = 1;
        for (int i = 1; i < 26; i++) {
            if (counts[i] == max) {
                count++;
            } else if (counts[i] > max) {
                max = counts[i];
                count = 1;
            }
        }
        return Math.max((max - 1) * (n + 1) + count, tasks.length);
    }
}
