package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/interval-list-intersections/">986. Interval List Intersections</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution56
 * @see cn.kingen.oj.leetcode.problem.p0.Solution88
 * @see cn.kingen.oj.leetcode.problem.p700.Solution759
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS},
        difficulty = Difficulty.MEDIUM
)
public class Solution986 {

    @Complexity(time = "O(m+n)", space = "O(m+n)")
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length, n = secondList.length;
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < m && j < n) {
            int[] first = firstList[i], second = secondList[j];
            int start = Math.max(first[0], second[0]), end = Math.min(first[1], second[1]);
            if (start <= end) {
                ans.add(new int[]{start, end});
            }
            if (first[1] == end) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[0][]);
    }
}