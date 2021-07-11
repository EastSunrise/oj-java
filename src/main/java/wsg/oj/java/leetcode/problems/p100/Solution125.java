package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 125. Valid Palindrome (Easy)
 *
 * @author Kingen
 * @see Solution234
 * @see Solution680
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome/">Valid Palindrome</a>
 * @since 2021-07-11
 */
class Solution125 implements Solution {

    /**
     * Uses two pointers from two sides.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!isAlphanumeric(chars[left])) {
                left++;
            } else if (!isAlphanumeric(chars[right])) {
                right--;
            } else {
                if (Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
