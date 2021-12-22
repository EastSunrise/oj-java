package cn.wsg.oj.leetcode.problems.p1800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p800.Solution848;

/**
 * 1844. Replace All Digits with Characters (EASY)
 *
 * @author Kingen
 * @see Solution848
 * @see <a href="https://leetcode-cn.com/problems/replace-all-digits-with-characters/">Replace All
 * Digits with Characters</a>
 */
public class Solution1844 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String replaceDigits(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 1; i < n; i += 2) {
            chars[i] = (char) (chars[i - 1] + chars[i] - '0');
        }
        return new String(chars);
    }
}
