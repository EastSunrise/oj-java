package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 455. Assign Cookies (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/assign-cookies/">Assign Cookies</a>
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
