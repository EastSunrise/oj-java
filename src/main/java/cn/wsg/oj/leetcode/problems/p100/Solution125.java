package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution234;
import cn.wsg.oj.leetcode.problems.p600.Solution680;

/**
 * 125. Valid Palindrome (Easy)
 *
 * @author Kingen
 * @see Solution234
 * @see Solution680
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome/">Valid Palindrome</a>
 */
public class Solution125 implements Solution {

    /**
     * Uses two pointers from two sides.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
