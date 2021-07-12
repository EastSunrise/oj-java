package wsg.oj.java.leetcode.problems.p200;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution39;

/**
 * 216. Combination Sum III (Medium)
 *
 * @author Kingen
 * @see Solution39
 * @see <a href="https://leetcode-cn.com/problems/combination-sum-iii/">Combination Sum III</a>
 * @since 2021-07-12
 */
class Solution216 implements Solution {

    /**
     * @complexity T=(kC), C=C(9,k)
     * @complexity S=O(9)
     * @see #BACKTRACKING
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k * (k + 1) / 2 || n > (19 - k) * k / 2) {
            return res;
        }
        combinationSum3(res, new ArrayList<>(k), k, n, 1);
        return res;
    }

    void combinationSum3(List<List<Integer>> res, List<Integer> temp, int k, int n, int start) {
        if (k == 0 || n <= 0) {
            if (k == 0 && n == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        k--;
        for (int i = start; i < 10; i++) {
            temp.add(i);
            combinationSum3(res, temp, k, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
