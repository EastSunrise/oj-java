package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p500.Solution528;
import java.util.Arrays;
import java.util.Random;

/**
 * 497. Random Point in Non-overlapping Rectangles (Medium)
 *
 * @author Kingen
 * @see Solution528
 * @see Solution478
 * @see <a href="https://leetcode-cn.com/problems/random-point-in-non-overlapping-rectangles/">Random
 * Point in Non-overlapping Rectangles</a>
 */
public class Solution497 implements Solution {

    static class Solution {

        private final int[] prefixSums;
        private final int[][] rectangles;
        private final Random random = new Random();
        private final int points;

        public Solution(int[][] rects) {
            int points = 0;
            prefixSums = new int[rects.length];
            rectangles = new int[rects.length][];
            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                prefixSums[i] = points;
                rectangles[i] = rect;
                points += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            }
            this.points = points;
        }

        public int[] pick() {
            int rand = random.nextInt(points);
            int idx = Arrays.binarySearch(prefixSums, rand);
            if (idx < 0) {
                idx = -idx - 2;
            }
            int offset = rand - prefixSums[idx];
            int[] rect = rectangles[idx];
            int width = rect[2] - rect[0] + 1;
            return new int[]{rect[0] + offset % (width), rect[1] + offset / (width)};
        }
    }
}
