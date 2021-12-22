package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution125;

/**
 * 680. Valid Palindrome II (EASY)
 *
 * @author Kingen
 * @see Solution125
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome-ii/">Valid Palindrome II</a>
 */
public class Solution680 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
