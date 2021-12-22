package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution191;

/**
 * 231. Power of Two (Easy)
 *
 * @author Kingen
 * @see Solution191
 * @see Solution326
 * @see Solution342
 * @see <a href="https://leetcode-cn.com/problems/power-of-two/">Power of Two</a>
 */
public class Solution231 implements Solution {

    /**
     * @complexity T=O(32)
     * @see #SPACE_CONSTANT
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while ((n & 1) == 0) {
            n >>= 1;
        }
        return n == 1;
    }

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
