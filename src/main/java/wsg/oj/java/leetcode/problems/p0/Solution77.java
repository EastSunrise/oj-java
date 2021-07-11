package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 77. Combinations (Medium)
 *
 * @author Kingen
 * @see Solution39
 * @see Solution46
 * @see <a href="https://leetcode-cn.com/problems/combinations/">Combinations</a>
 * @since 2021-07-11
 */
class Solution77 implements Solution {

    /**
     * @complexity S=O(kC(n,k))
     * @see #BACKTRACKING
     * @see wsg.oj.java.Complexity#TIME_2_N
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(k), 1, n + 1, k);
        return res;
    }

    /**
     * @param temp chosen numbers in ascending order
     * @param from the min number (inclusive) that can be chosen
     * @param to   the max number (exclusive) that can be chosen
     * @param k    the left numbers to choose from [from,to)
     */
    private void combine(List<List<Integer>> res, List<Integer> temp, int from, int to, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = from, len = to - k; i <= len; i++) {
            temp.add(i);
            combine(res, temp, i + 1, to, k - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
