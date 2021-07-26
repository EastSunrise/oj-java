package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 557. Reverse Words in a String III (EASY)
 *
 * @author Kingen
 * @see Solution541
 * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/">Reverse Words in a
 * String III</a>
 * @since 2021-07-20
 */
public class Solution557 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int start = 0;
        do {
            int end = start + 1;
            while (end < len && chars[end] != ' ') {
                end++;
            }
            int left = start, right = end - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            start = end + 1;
        } while (start < len);
        return new String(chars);
    }
}
