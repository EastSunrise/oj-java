package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution56;
import cn.wsg.oj.leetcode.problems.p0.Solution88;
import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections (MEDIUM)
 *
 * @author Kingen
 * @see Solution56
 * @see Solution88
 * @see Solution759
 * @see <a href="https://leetcode-cn.com/problems/interval-list-intersections/">Interval List
 * Intersections</a>
 */
public class Solution986 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_M_PLUS_N
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length, n = secondList.length;
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < m && j < n) {
            int[] first = firstList[i], second = secondList[j];
            int start = Math.max(first[0], second[0]), end = Math.min(first[1], second[1]);
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            if (first[1] == end) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
