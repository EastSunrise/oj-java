package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution367;

/**
 * 633. Sum of Square Numbers (MEDIUM)
 *
 * @author Kingen
 * @see Solution367
 * @see <a href="https://leetcode-cn.com/problems/sum-of-square-numbers/">Sum of Square Numbers</a>
 */
public class Solution633 implements Solution {

    /**
     * Supposes that c=2^r*p1^r1*···*pn^rn, then c is the sum of two squares if and only if none of
     * pi-ri pair satisfies pi%4==3 and ri%2==1 at the same time.
     */
    public boolean judgeSquareSum(int c) {
        if (c <= 2) {
            return true;
        }
        if (c % 4 == 3) {
            return false;
        }
        while (c % 2 == 0) {
            c /= 2;
        }
        int p = 3;
        while (p * p <= c) {
            int count = 0;
            while (c % p == 0) {
                count++;
                c /= p;
            }
            if (p % 4 == 3 && count % 2 == 1) {
                return false;
            }
            p += 2;
        }
        // pn
        return c % 4 != 3;
    }

    /**
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean judgeSquareSum2(int c) {
        if (c % 4 == 3) {
            return false;
        }
        int high = (int) Math.sqrt(c);
        int low = (int) Math.sqrt(c - high * high);
        while (low <= high) {
            if (low * low + high * high == c) {
                return true;
            }
            high--;
            low = (int) Math.sqrt(c - high * high);
        }
        return false;
    }
}
