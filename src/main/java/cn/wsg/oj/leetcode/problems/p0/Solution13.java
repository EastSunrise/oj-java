package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Map;

/**
 * 13. Roman to Integer (Easy)
 *
 * @author Kingen
 * @see Solution12
 * @see <a href="https://leetcode-cn.com/problems/roman-to-integer/">Roman to Integer</a>
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
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
