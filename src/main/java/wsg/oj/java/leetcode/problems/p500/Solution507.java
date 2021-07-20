package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 507. Perfect Number (EASY)
 *
 * @author Kingen
 * @see Solution728
 * @see <a href="https://leetcode-cn.com/problems/perfect-number/">Perfect Number</a>
 * @since 2021-07-20
 */
class Solution507 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
