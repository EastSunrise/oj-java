package wsg.oj.java.leetcode.problems.p1300;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1374. Generate a String With Characters That Have Odd Counts (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/">Generate
 * a String With Characters That Have Odd Counts</a>
 * @since 2021-07-27
 */
public class Solution1374 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
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
