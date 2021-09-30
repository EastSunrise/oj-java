package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution125;

/**
 * 680. Valid Palindrome II (EASY)
 *
 * @author Kingen
 * @see Solution125
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome-ii/">Valid Palindrome II</a>
 * @since 2021-07-23
 */
public class Solution680 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        // check whether s[left+1,right] is a palindrome
        int i = left + 1, j = right;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j) {
            return true;
        }
        i = left;
        j = right - 1;
        // check whether s[left,right-1] is a palindrome
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }
}
