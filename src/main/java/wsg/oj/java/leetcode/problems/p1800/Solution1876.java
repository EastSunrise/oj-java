package wsg.oj.java.leetcode.problems.p1800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1876. Substrings of Size Three with Distinct Characters (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters/">Substrings
 * of Size Three with Distinct Characters</a>
 * @since 2021-07-27
 */
public class Solution1876 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int countGoodSubstrings(String s) {
        int n = s.length();
        if (n < 3) {
            return 0;
        }
        int count = 0;
        boolean prev = s.charAt(0) == s.charAt(1);
        for (int i = 2; i < n; i++) {
            // check s[i-2], s[i-1], s[i]
            boolean cur = s.charAt(i) == s.charAt(i - 1);
            if (!prev && !cur && s.charAt(i) != s.charAt(i - 2)) {
                count++;
            }
            prev = cur;
        }
        return count;
    }
}
