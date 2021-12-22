package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 1374. Generate a String With Characters That Have Odd Counts (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/">Generate
 * a String With Characters That Have Odd Counts</a>
 */
public class Solution1374 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        if (n % 2 == 0) {
            chars[0] = 'b';
        }
        return new String(chars);
    }
}
