package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 345. Reverse Vowels of a String (Easy)
 *
 * @author Kingen
 * @see Solution344
 * @see Solution1119
 * @see <a href="https://leetcode-cn.com/problems/reverse-vowels-of-a-string/">Reverse Vowels of a
 * String</a>
 * @since 2021-07-13
 */
public class Solution345 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && notVowel(chars[left])) {
                left++;
            }
            while (left < right && notVowel(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    private boolean notVowel(char ch) {
        if (ch > 'U') {
            ch -= 32;
        }
        return ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U';
    }
}
