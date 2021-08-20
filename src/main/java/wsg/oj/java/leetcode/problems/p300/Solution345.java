package wsg.oj.java.leetcode.problems.p300;

import java.util.Set;
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

    Set<Character> vowels = Set.of(
        'A', 'E', 'I', 'O', 'U',
        'a', 'e', 'i', 'o', 'u'
    );

    /**
     * @complexity T=O(n)
     * @complexity S=O(K), K=the number of vowels
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!vowels.contains(chars[left])) {
                left++;
            } else if (!vowels.contains(chars[right])) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = tmp;
            }
        }
        return new String(chars);
    }
}
