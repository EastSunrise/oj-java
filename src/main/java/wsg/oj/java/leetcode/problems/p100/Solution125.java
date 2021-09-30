package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution234;
import wsg.oj.java.leetcode.problems.p600.Solution680;

/**
 * 125. Valid Palindrome (Easy)
 *
 * @author Kingen
 * @see Solution234
 * @see Solution680
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome/">Valid Palindrome</a>
 * @since 2021-07-11
 */
public class Solution125 implements Solution {

    /**
     * Uses two pointers from two sides.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lch = s.charAt(left);
            char rch = s.charAt(right);
            if (!isAlphanumeric(lch)) {
                left++;
            } else if (!isAlphanumeric(rch)) {
                right--;
            } else {
                if (Character.toLowerCase(lch) == Character.toLowerCase(rch)) {
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
