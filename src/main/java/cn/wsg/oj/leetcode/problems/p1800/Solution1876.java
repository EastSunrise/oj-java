package cn.wsg.oj.leetcode.problems.p1800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1876. Substrings of Size Three with Distinct Characters (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters/">Substrings
 * of Size Three with Distinct Characters</a>
 */
public class Solution1876 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
