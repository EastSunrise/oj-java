package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations (Medium)
 *
 * @author Kingen
 * @see Solution39
 * @see Solution46
 * @see <a href="https://leetcode-cn.com/problems/combinations/">Combinations</a>
 */
public class Solution77 implements Solution {

    /**
     * @complexity T=O(k*C(n,k))
     * @complexity S=O(n)
     * @see #DFS
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
