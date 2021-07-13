package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 258. Add Digits (Easy)
 *
 * @author Kingen
 * @see Solution202
 * @see Solution1085
 * @see <a href="https://leetcode-cn.com/problems/add-digits/">Add Digits</a>
 * @since 2021-07-13
 */
class Solution258 implements Solution {

    /**
     * Assumes that <i>num = 100a + 10b + c</i>, then sum of digits <i>s = a + b + c</i>. The
     * difference is <i>99a + 9b</i> which is a multiple of 9. So <i>num ≡ s(mod 9)</i>.
     *
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
