package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 9. Palindrome Number (Easy)
 *
 * @author Kingen
 * @see Solution234
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number/">Palindrome Number</a>
 * @since 2021-07-10
 */
public class Solution9 implements Solution {

    /**
     * Reverses the right half of x and compares with the left half.
     *
     * @complexity T=O(d), d=the half number of digits of x
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int reversed = 0;
        do {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        } while (x > reversed);
        return x == reversed || x == reversed / 10;
    }
}
