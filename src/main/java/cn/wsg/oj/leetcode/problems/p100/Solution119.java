package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II (Easy)
 *
 * @author Kingen
 * @see Solution118
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
 */
public class Solution119 implements Solution {

    /**
     * Each row is a group of binomial coefficients: C(n,0),C(n,1),...,C(n,n).
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
