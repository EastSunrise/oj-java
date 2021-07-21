package wsg.oj.java.leetcode.problems.p500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 519. Random Flip Matrix (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/random-flip-matrix/">Random Flip Matrix</a>
 * @since 2021-07-20
 */
class Solution519 implements Solution {

    static class Solution {

        private final int rows;
        private final int cols;
        private final List<Set<Integer>> flipped;
        private final Random random = new Random();
        private int size;

        public Solution(int n_rows, int n_cols) {
            this.rows = n_rows;
            this.cols = n_cols;
            this.flipped = new ArrayList<>(rows);
            for (int i = 0; i < rows; i++) {
                flipped.add(new HashSet<>());
            }
            reset();
        }

        public int[] flip() {
            int target = random.nextInt(size);
            for (int i = 0; i < rows; i++) {
                Set<Integer> row = flipped.get(i);
                int remained = cols - row.size();
                if (target >= remained) {
                    target -= remained;
                } else {
                    int j = 0;
                    while (true) {
                        if (row.contains(j)) {
                            j++;
                        } else if (target > 0) {
                            j++;
                            target--;
                        } else {
                            row.add(j);
                            size--;
                            return new int[]{i, j};
                        }
                    }
                }
            }
            throw new IllegalArgumentException("No more zero.");
        }

        public void reset() {
            for (Set<Integer> row : flipped) {
                row.clear();
            }
            size = rows * cols;
        }
    }
}
