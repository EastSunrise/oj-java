package cn.wsg.oj.leetcode.problems.p1900;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1910. Remove All Occurrences of a Substring (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/remove-all-occurrences-of-a-substring/">Remove All
 * Occurrences of a Substring</a>
 */
public class Solution1910 implements Solution {

    public String removeOccurrences(String s, String part) {
        int n = part.length();
        StringBuilder builder = new StringBuilder(s);
        while (true) {
            int i = builder.indexOf(part);
            if (i < 0) {
                return builder.toString();
            }
            builder.delete(i, i + n);
        }
    }
}
