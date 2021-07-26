package wsg.oj.java.leetcode.problems.p400;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 455. Assign Cookies (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/assign-cookies/">Assign Cookies</a>
 * @since 2021-07-14
 */
public class Solution455 implements Solution {

    /**
     * @complexity T=O(n*log{n}+m*log{m})
     * @complexity S=O(min(m,n))
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
