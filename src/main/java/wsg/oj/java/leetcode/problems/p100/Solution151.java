package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 151. Reverse Words in a String (Medium)
 *
 * @author Kingen
 * @see Solution186
 * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string/">Reverse Words in a
 * String</a>
 * @since 2021-07-12
 */
public class Solution151 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String reverseWords(String s) {
        int n = s.length();
        char[] src = (' ' + s).toCharArray();
        char[] dest = new char[n + 1];
        int end = n + 1, j = 0;
        for (int i = n; i >= 0; i--) {
            if (src[i] == ' ') {
                int len = end - i - 1;
                if (len > 0) {
                    System.arraycopy(src, i + 1, dest, j, len);
                    j += len;
                    dest[j++] = ' ';
                }
                end = i;
            }
        }
        return j == 0 ? "" : new String(dest, 0, j - 1);
    }
}
