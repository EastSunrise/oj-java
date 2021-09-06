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
public class Solution165 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int i = 0, min = Math.min(parts1.length, parts2.length);
        while (i < min) {
            int v1 = Integer.parseInt(parts1[i]);
            int v2 = Integer.parseInt(parts2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            i++;
        }
        while (i < parts1.length) {
            if (Integer.parseInt(parts1[i]) > 0) {
                return 1;
            }
            i++;
        }
        while (i < parts2.length) {
            if (Integer.parseInt(parts2[i]) > 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
