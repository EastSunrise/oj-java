package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 119. Pascal's Triangle II (Easy)
 *
 * @author Kingen
 * @see Solution118
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
 * @since 2021-07-11
 */
class Solution119 implements Solution {

    /**
     * Each row is a group of binomial coefficients: C(n,0),C(n,1),...,C(n,n).
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long last = 1;
        res.add((int) last);
        for (int i = 0; i < rowIndex; i++) {
            last = last * (rowIndex - i) / (i + 1);
            res.add((int) last);
        }
        return res;
    }
}
