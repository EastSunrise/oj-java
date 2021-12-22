package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 434. Number of Segments in a String (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-of-segments-in-a-string/">Number of
 * Segments in a String</a>
 */
public class Solution434 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int countSegments(String s) {
        int i = s.length() - 1, cnt = 0;
        while (i >= 0) {
            if (s.charAt(i--) != ' ') {
                cnt++;
                while (i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }
            }
        }
        return cnt;
    }
}
