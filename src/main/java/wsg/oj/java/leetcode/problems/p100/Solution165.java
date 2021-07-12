package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 165. Compare Version Numbers (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/compare-version-numbers/">Compare Version
 * Numbers</a>
 * @since 2021-07-12
 */
class Solution165 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int compareVersion(String version1, String version2) {
        int i1 = 0, i2 = 0, len1 = version1.length(), len2 = version2.length();
        while (i1 < len1 || i2 < len2) {
            int v1 = 0;
            if (i1 < len1) {
                int j1 = i1;
                while (j1 < len1 && version1.charAt(j1) != '.') {
                    j1++;
                }
                v1 = Integer.parseInt(version1, i1, j1, 10);
                i1 = j1 + 1;
            }
            int v2 = 0;
            if (i2 < len2) {
                int j2 = i2;
                while (j2 < len2 && version2.charAt(j2) != '.') {
                    j2++;
                }
                v2 = Integer.parseInt(version2, i2, j2, 10);
                i2 = j2 + 1;
            }
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }
}
