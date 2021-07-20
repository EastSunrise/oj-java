package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution344;

/**
 * 541. Reverse String II (EASY)
 *
 * @author Kingen
 * @see Solution344
 * @see Solution557
 * @see <a href="https://leetcode-cn.com/problems/reverse-string-ii/">Reverse String II</a>
 * @since 2021-07-20
 */
public class Solution541 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int start = 0; start < len; start += 2 * k) {
            int left = start, right = Math.min(start + k, len) - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
