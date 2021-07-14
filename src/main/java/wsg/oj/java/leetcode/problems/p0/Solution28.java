package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.algorithm.PatternSearching;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution459;

/**
 * 28. Implement strStr() (Easy)
 *
 * @author Kingen
 * @see Solution214
 * @see Solution459
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr/">Implement strStr()</a>
 * @since 2021-07-10
 */
public class Solution28 extends PatternSearching implements Solution {

    /**
     * @see String#indexOf(String)
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * KMP algorithm.
     *
     * @see #kmpSearch(char[], char[])
     */
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        return kmpSearch(haystack.toCharArray(), needle.toCharArray());
    }
}
