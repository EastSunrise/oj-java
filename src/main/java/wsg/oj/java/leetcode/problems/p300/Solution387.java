package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution451;

/**
 * 387. First Unique Character in a String (Easy)
 *
 * @author Kingen
 * @see Solution451
 * @see <a href="https://leetcode-cn.com/problems/first-unique-character-in-a-string/">First Unique
 * Character in a String</a>
 * @since 2021-07-13
 */
public class Solution387 implements Solution {

    /**
     * @complexity T=O(n+26)
     * @complexity S=O(26)
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        // [i][0]: count of char i+'a', [i][1]: first index of char i+'a'
        int[][] counts = new int[26][2];
        for (int i = chars.length - 1; i >= 0; i--) {
            int ch = chars[i] - 'a';
            counts[ch][0]++;
            counts[ch][1] = i;
        }
        int first = chars.length;
        for (int[] count : counts) {
            if (count[0] == 1 && count[1] < first) {
                first = count[1];
            }
        }
        return first == chars.length ? -1 : first;
    }
}
