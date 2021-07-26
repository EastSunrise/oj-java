package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution459;

/**
 * 686. Repeated String Match (MEDIUM)
 *
 * @author Kingen
 * @see Solution459
 * @see <a href="https://leetcode-cn.com/problems/repeated-string-match/">Repeated String Match</a>
 * @since 2021-07-23
 */
public class Solution686 implements Solution {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder(a);
        int count = 1;
        while (builder.length() < b.length()) {
            builder.append(a);
            count++;
        }
        if (builder.toString().contains(b)) {
            return count;
        }
        builder.append(a);
        return builder.toString().contains(b) ? count + 1 : -1;
    }
}
