package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/separate-squares-i/">3453. Separate Squares I</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM,
        contest2 = 150
)
public class Solution3453 {

    @Complexity(time = "O(n*log(m))", space = "O(n)", note = "m is the range of ys")
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] square : squares) {
            min = Math.min(min, square[1]);
            max = Math.max(max, square[1] + square[2]);
        }

        double low = min, high = max, error = 1e-6;
        long[] areas = new long[n];
        while (low <= high) {
            double mid = (low + high) / 2;
            double diff = diff(squares, areas, mid);
            if (diff > 0) {
                low = mid + error;
            } else {
                high = mid - error;
            }
        }
        return high;
    }

    private double diff(int[][] squares, long[] areas, double t) {
        double diff = 0.0;
        for (int i = 0; i < squares.length; i++) {
            int[] square = squares[i];
            long y1 = square[1], r = square[2], y2 = y1 + r;
            if (y1 >= t) {
                if (areas[i] == 0) {
                    diff += (areas[i] = (r * r));
                } else {
                    diff += areas[i];
                }
            } else if (y2 <= t) {
                if (areas[i] == 0) {
                    diff -= (areas[i] = (r * r));
                } else {
                    diff -= areas[i];
                }
            } else {
                diff += (y1 + y2 - t - t) * r;
            }
        }
        return diff;
    }
}