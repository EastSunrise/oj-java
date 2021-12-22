package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/lexicographical-numbers/">Lexicographical
 * Numbers</a>
 */
public class Solution386 implements Solution {

    /**
     * @see #DFS
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
