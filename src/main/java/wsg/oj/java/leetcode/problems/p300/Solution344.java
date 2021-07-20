package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution541;

/**
 * 344. Reverse String (Easy)
 *
 * @author Kingen
 * @see Solution345
 * @see Solution541
 * @see <a href="https://leetcode-cn.com/problems/reverse-string/">Reverse String</a>
 * @since 2021-07-13
 */
public class Solution344 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
