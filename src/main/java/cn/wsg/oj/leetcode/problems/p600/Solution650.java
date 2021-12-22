package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p900.Solution991;

/**
 * 650. 2 Keys Keyboard (MEDIUM)
 *
 * @author Kingen
 * @see Solution651
 * @see Solution991
 * @see <a href="https://leetcode-cn.com/problems/2-keys-keyboard/">2 Keys Keyboard</a>
 */
public class Solution650 implements Solution {

    public int minSteps(int n) {
        int steps = 0, p = 2;
        while (n > 1) {
            while (n % p == 0) {
                steps += p;
                n /= p;
            }
            p++;
        }
        return steps;
    }
}
