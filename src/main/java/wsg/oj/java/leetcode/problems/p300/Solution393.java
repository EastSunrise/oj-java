package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 393. UTF-8 Validation (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/utf-8-validation/">UTF-8 Validation</a>
 * @since 2021-07-06
 */
public class Solution393 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean validUtf8(int[] data) {
        // left bytes
        int bytes = 0;
        for (int b : data) {
            if (bytes > 0) {
                if ((b >>> 6) != 2) {
                    return false;
                }
                bytes--;
            } else if ((b >>> 7) == 0) {
                if (bytes != 0) {
                    return false;
                }
            } else if ((b >>> 3) == 0b11110) {
                bytes = 3;
            } else if ((b >>> 4) == 0b1110) {
                bytes = 2;
            } else if ((b >>> 5) == 0b110) {
                bytes = 1;
            } else {
                return false;
            }
        }
        return bytes == 0;
    }
}
