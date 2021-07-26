package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 205. Isomorphic Strings (Easy)
 *
 * @author Kingen
 * @see Solution290
 * @see <a href="https://leetcode-cn.com/problems/isomorphic-strings/">Isomorphic Strings</a>
 * @since 2021-07-12
 */
public class Solution205 implements Solution {

    /**
     * @complexity S=O(128)
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int[] s2t = new int[128];
        int[] t2s = new int[128];
        for (int i = 0; i < len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            int tShould = s2t[sc];
            int sShould = t2s[tc];
            if (tShould + sShould == 0) {
                s2t[sc] = tc;
                t2s[tc] = sc;
            } else if (tShould * sShould == 0) {
                return false;
            } else if (tShould != tc || sShould != sc) {
                return false;
            }
        }
        return true;
    }
}
