package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution273;

/**
 * 12. Integer to Roman (Medium)
 *
 * @author Kingen
 * @see Solution13
 * @see Solution273
 * @see <a href="https://leetcode-cn.com/problems/integer-to-roman/">Integer to Roman</a>
 */
public class Solution12 implements Solution {

    char[] dict = new char[]{
        'I', 'V', 'X', 'L', 'C', 'D', 'M'
    };

    /**
     * Thinks of 1-3, 4, 5-8, 9 separately.
     *
     * @complexity T=O(d), d=the number of digits of the number
     * @see Complexity#SPACE_CONSTANT
     */
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit < 4) {
                while (digit-- > 0) {
                    builder.append(dict[i]);
                }
            } else if (digit == 4) {
                builder.append(dict[i + 1]).append(dict[i]);
            } else if (digit < 9) {
                while (digit-- > 5) {
                    builder.append(dict[i]);
                }
                builder.append(dict[i + 1]);
            } else {
                builder.append(dict[i + 2]).append(dict[i]);
            }
            num /= 10;
            i += 2;
        }
        return builder.reverse().toString();
    }
}
