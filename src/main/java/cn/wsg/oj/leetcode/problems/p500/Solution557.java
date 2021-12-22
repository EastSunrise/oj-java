package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 557. Reverse Words in a String III (EASY)
 *
 * @author Kingen
 * @see Solution541
 * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/">Reverse Words in a
 * String III</a>
 */
public class Solution557 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        while (start < n) {
            int end = start + 1;
            while (end < n && chars[end] != ' ') {
                end++;
            }
            int left = start, right = end - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
            start = end + 1;
        }
        return new String(chars);
    }
}
