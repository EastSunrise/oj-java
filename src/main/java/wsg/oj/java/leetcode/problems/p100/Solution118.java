package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 118. Pascal's Triangle (Easy)
 *
 * @author Kingen
 * @see Solution119
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle/">Pascal's Triangle</a>
 * @since 2021-07-11
 */
public class Solution118 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_NN
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        List<Integer> prev = List.of(1);
        res.add(prev);
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>(prev.size() + 1);
            current.add(1);
            for (int j = 1, lastSize = prev.size(); j < lastSize; j++) {
                current.add(prev.get(j - 1) + prev.get(j));
            }
            current.add(1);
            res.add(current);
            prev = current;
        }
        return res;
    }
}
