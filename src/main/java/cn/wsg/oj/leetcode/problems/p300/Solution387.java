package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution451;

/**
 * 387. First Unique Character in a String (Easy)
 *
 * @author Kingen
 * @see Solution451
 * @see <a href="https://leetcode-cn.com/problems/first-unique-character-in-a-string/">First Unique
 * Character in a String</a>
 */
public class Solution387 implements Solution {

    /**
     * @complexity T=O(n+26)
     * @complexity S=O(26)
     */
    public int firstUniqChar(String s) {
        int n = s.length();
        // [i][0]: count of char i+'a', [i][1]: first index of char i+'a'
        int[][] counts = new int[26][2];
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            counts[idx][0]++;
            counts[idx][1] = i;
        }
        int first = n;
        for (int[] count : counts) {
            if (count[0] == 1 && count[1] < first) {
                first = count[1];
            }
        }
        return first == n ? -1 : first;
    }
}
