package cn.wsg.oj.leetcode.problems.p1200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 1253. Reconstruct a 2-Row Binary Matrix (MEDIUM)
 *
 * @author Kingen
 * @see Solution1605
 * @see <a href="https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix/">Reconstruct a
 * 2-Row Binary Matrix</a>
 */
public class Solution1253 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
