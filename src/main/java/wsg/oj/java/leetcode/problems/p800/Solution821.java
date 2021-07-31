package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 821. Shortest Distance to a Character (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shortest-distance-to-a-character/">Shortest
 * Distance to a Character</a>
 * @since 2021-07-27
 */
public class Solution821 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] distances = new int[n];
        int start = s.indexOf(c);
        // the first part
        for (int i = 0; i < start; i++) {
            distances[i] = start - i;
        }
        while (true) {
            int end = s.indexOf(c, start + 1);
            if (end < 0) {
                break;
            }
            int mid = (start + end) / 2;
            for (int i = start + 1; i <= mid; i++) {
                distances[i] = i - start;
            }
            for (int i = mid + 1; i < end; i++) {
                distances[i] = end - i;
            }
            start = end;
        }
        // the last part
        for (int i = start + 1; i < n; i++) {
            distances[i] = i - start;
        }
        return distances;
    }
}
