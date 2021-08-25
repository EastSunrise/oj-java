package wsg.oj.java.leetcode.problems.lcp;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 19. 秋叶收藏集 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/UlBDOe/">秋叶收藏集</a>
 * @since 2021-07-28
 */
public class Lcp19 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int r = 0, ry = 0, ryr = 0;
        if (leaves.charAt(0) != 'r') {
            r = ry = ryr = 1;
        }
        if (leaves.charAt(1) != 'r') {
            r++;
        } else {
            ry++;
            ryr++;
        }
        for (int i = 2; i < n; i++) {
            ryr = Math.min(ryr, ry);
            ry = Math.min(r, ry);
            if (leaves.charAt(i) != 'r') {
                ryr++;
                r++;
            } else {
                ry++;
            }
        }
        return ryr;
    }
}
