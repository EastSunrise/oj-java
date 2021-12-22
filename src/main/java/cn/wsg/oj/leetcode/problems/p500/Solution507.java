package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p700.Solution728;

/**
 * 507. Perfect Number (EASY)
 *
 * @author Kingen
 * @see Solution728
 * @see <a href="https://leetcode-cn.com/problems/perfect-number/">Perfect Number</a>
 */
public class Solution507 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int low = 2, sum = 1;
        while (low * low < num) {
            if (num % low == 0) {
                sum += low + num / low;
            }
            low++;
        }
        if (low * low == num) {
            sum += low;
        }
        return sum == num;
    }
}
