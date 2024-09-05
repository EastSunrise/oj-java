package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/rectangle-area-ii/">850. Rectangle Area II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.SEGMENT_TREE, Tag.ARRAY, Tag.ORDERED_SET, Tag.LINE_SWEEP},
        difficulty = Difficulty.HARD
)
public class Solution850 {

    @Complexity(time = "O(n^2)", space = "O(n)")
    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        Set<Integer> ySet = new HashSet<>();
        for (int[] rectangle : rectangles) {
            ySet.add(rectangle[1]);
            ySet.add(rectangle[3]);
        }
        int[] ys = ySet.stream().sorted().mapToInt(Integer::intValue).toArray();
        int ym = ys.length;
        int[] seg = new int[ym]; // count of covered y-axis segments

        int xm = 2 * n;
        int[][] xs = new int[xm][];
        for (int i = 0, j = 0; i < n; i++) {
            int[] rect = rectangles[i];
            xs[j++] = new int[]{rect[0], i, 1}; // left edge
            xs[j++] = new int[]{rect[2], i, -1}; // right edge
        }
        Arrays.sort(xs, Comparator.comparingInt(a -> a[0]));

        long ans = 0;
        for (int i = 0; i < xm; ) {
            int j = i + 1, x = xs[i][0];
            while (j < xm && xs[j][0] == x) {
                j++;
            } // find all bounds at x

            if (j == xm) {
                break;
            }

            for (int k = i; k < j; k++) {
                int[] edge = xs[k];
                int idx = edge[1], flag = edge[2];
                int[] rect = rectangles[idx];
                int y1 = rect[1], y2 = rect[3];
                for (int r = 1; r < ym; r++) { // update its count if the y-axis segment is fully covered
                    if (y1 <= ys[r - 1] && ys[r] <= y2) {
                        seg[r] += flag;
                    }
                }
            }

            int length = 0; // total length of covered y-axis segments
            for (int r = 1; r < ym; r++) {
                if (seg[r] > 0) {
                    length += ys[r] - ys[r - 1];
                }
            }
            ans += (long) length * (xs[j][0] - x);
            i = j;
        }
        return (int) (ans % 1_000_000_007);
    }
}