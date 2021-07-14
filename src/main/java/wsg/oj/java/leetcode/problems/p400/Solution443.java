package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution38;

/**
 * 443. String Compression (Medium)
 *
 * @author Kingen
 * @see Solution38
 * @see Solution271
 * @see Solution604
 * @see Solution1313
 * @see <a href="https://leetcode-cn.com/problems/string-compression/">String Compression</a>
 * @since 2021-07-08
 */
public class Solution443 implements Solution {

    /**
     * Counts the consecutive characters.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int compress(char[] chars) {
        char cur = chars[0];
        int j = 1, count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
            } else {
                if (count > 1) {
                    for (char digit : String.valueOf(count).toCharArray()) {
                        chars[j++] = digit;
                    }
                    count = 1;
                }
                chars[j++] = chars[i];
                cur = chars[i];
            }
        }
        if (count > 1) {
            for (char digit : String.valueOf(count).toCharArray()) {
                chars[j++] = digit;
            }
        }
        return j;
    }
}
