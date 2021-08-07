package wsg.oj.java.leetcode.problems.p0;

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
public class Solution28 implements Solution {

    /**
     * @see wsg.oj.java.algorithm.PatternSearching
     * @see String#indexOf(String)
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
