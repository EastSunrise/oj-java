package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.algorithm.PatternSearching;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution459;

/**
 * 28. Implement strStr() (Easy)
 *
 * @author Kingen
 * @see Solution214
 * @see Solution459
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr/">Implement strStr()</a>
 */
public class Solution28 implements Solution {

    /**
     * @see PatternSearching
     * @see String#indexOf(String)
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
