package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 58. Length of Last Word (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/length-of-last-word/">Length of Last Word</a>
 * @since 2021-07-11
 */
class Solution58 implements Solution {

    /**
     * @complexity T=O(l), l=length of the last word and the spaces after it
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        if (right < 0) {
            return 0;
        }
        int left = right - 1;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }
}
