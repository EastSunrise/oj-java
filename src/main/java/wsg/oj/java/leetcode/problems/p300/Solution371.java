package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution2;

/**
 * 371. Sum of Two Integers (Medium)
 *
 * @author Kingen
 * @see Solution2
 * @see <a href="https://leetcode-cn.com/problems/sum-of-two-integers/">Sum of Two Integers</a>
 * @since 2021-07-04
 */
public class Solution371 implements Solution {

    /**
     * Adds each bit without carries first and then add the carry at once.
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
}
