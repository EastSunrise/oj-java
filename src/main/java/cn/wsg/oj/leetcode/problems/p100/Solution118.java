package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle (Easy)
 *
 * @author Kingen
 * @see Solution119
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle/">Pascal's Triangle</a>
 */
public class Solution118 implements Solution {

    /**
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_NN
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
