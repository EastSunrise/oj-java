package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/closest-room/">1847. Closest Room</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2070
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2403
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution1847 {

    @Complexity(time = "O(n*log(n) + m*log(m)+m*log(n))", space = "O(n+m)")
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length, m = queries.length;
        Arrays.sort(rooms, Comparator.comparingInt(a -> a[1]));
        Integer[] indices = new Integer[m];
        Arrays.setAll(indices, i -> i);
        Arrays.sort(indices, Comparator.comparingInt(i -> queries[i][1]));

        int[] ans = new int[m];
        TreeSet<Integer> roomIds = new TreeSet<>();
        for (int i = m - 1, j = n - 1; i >= 0; i--) {
            int k = indices[i];
            int preferred = queries[k][0], minSize = queries[k][1];
            while (j >= 0 && rooms[j][1] >= minSize) {
                roomIds.add(rooms[j--][0]);
            }

            Integer lower = roomIds.floor(preferred);
            Integer higher = roomIds.higher(preferred);
            if (lower == null && higher == null) {
                ans[k] = -1;
            } else if (lower == null) {
                ans[k] = higher;
            } else if (higher == null) {
                ans[k] = lower;
            } else {
                ans[k] = preferred - lower <= higher - preferred ? lower : higher;
            }
        }
        return ans;
    }
}