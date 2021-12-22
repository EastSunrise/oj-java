package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution231;

/**
 * 326. Power of Three (Easy)
 *
 * @author Kingen
 * @see Solution231
 * @see Solution342
 * @see Solution1780
 * @see <a href="https://leetcode-cn.com/problems/power-of-three/">Power of Three</a>
 */
public class Solution326 implements Solution {

    /**
     * @complexity T=O(log_{3}{n})
     * @complexity S=O(1)
     */
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
