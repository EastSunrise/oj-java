package cn.wsg.oj.leetcode.problems.p1100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution70;
import cn.wsg.oj.leetcode.problems.p500.Solution509;

/**
 * 1137. N-th Tribonacci Number (EASY)
 *
 * @author Kingen
 * @see Solution70
 * @see Solution509
 * @see <a href="https://leetcode-cn.com/problems/n-th-tribonacci-number/">N-th Tribonacci
 * Number</a>
 */
public class Solution1137 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int prevPrev = 0, prev = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            int next = prevPrev + prev + cur;
            prevPrev = prev;
            prev = cur;
            cur = next;
        }
        return cur;
    }
}
