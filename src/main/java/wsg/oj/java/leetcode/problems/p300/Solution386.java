package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 386. Lexicographical Numbers (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/lexicographical-numbers/">Lexicographical
 * Numbers</a>
 * @since 2021-07-06
 */
class Solution386 implements Solution {

    /**
     * @see #DFS
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            lexicalOrder(res, n, i);
        }
        return res;
    }

    private void lexicalOrder(List<Integer> res, int n, int base) {
        if (base > n) {
            return;
        }
        res.add(base);
        base *= 10;
        if (base > n) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            lexicalOrder(res, n, base + i);
        }
    }
}
