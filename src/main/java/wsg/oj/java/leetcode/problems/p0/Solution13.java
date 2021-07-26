package wsg.oj.java.leetcode.problems.p0;

import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 13. Roman to Integer (Easy)
 *
 * @author Kingen
 * @see Solution12
 * @see <a href="https://leetcode-cn.com/problems/roman-to-integer/">Roman to Integer</a>
 * @since 2021-07-10
 */
public class Solution13 implements Solution {

    Map<Character, Integer> symbols = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    /**
     * Traverses the string.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int ret = 0;
        int last = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];
            int value = symbols.get(ch);
            if (value < last) {
                ret -= value;
            } else {
                ret += value;
            }
            last = value;
        }
        return ret;
    }
}
