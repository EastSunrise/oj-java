package wsg.oj.java.leetcode.problems.p1200;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1253. Reconstruct a 2-Row Binary Matrix (MEDIUM)
 *
 * @author Kingen
 * @see Solution1605
 * @see <a href="https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix/">Reconstruct a
 * 2-Row Binary Matrix</a>
 * @since 2021-07-27
 */
public class Solution1253 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        List<Integer> first = new ArrayList<>(n), second = new ArrayList<>(n);
        for (int col : colsum) {
            if (col == 2) {
                first.add(1);
                upper--;
                second.add(1);
                lower--;
            } else if (col == 1) {
                if (upper > lower) {
                    first.add(1);
                    second.add(0);
                    upper--;
                } else {
                    first.add(0);
                    second.add(1);
                    lower--;
                }
            } else {
                first.add(0);
                second.add(0);
            }
            if (upper < 0 || lower < 0) {
                return new ArrayList<>();
            }
        }
        if (upper > 0 || lower > 0) {
            return new ArrayList<>();
        }
        return List.of(first, second);
    }
}
