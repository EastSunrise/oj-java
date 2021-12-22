package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 917. Reverse Only Letters (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reverse-only-letters/">Reverse Only Letters</a>
 */
public class Solution917 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!isLetter(chars[left])) {
                left++;
            } else if (!isLetter(chars[right])) {
                right--;
            } else {
                char c = chars[left];
                chars[left++] = chars[right];
                chars[right--] = c;
            }
        }
        return new String(chars);
    }
}
