package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 390. Elimination Game (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/elimination-game/">Elimination Game</a>
 * @since 2021-07-06
 */
public class Solution390 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_LOG_N
     */
    public int lastRemaining(int n) {
        return left2right(n);
    }

    /**
     * Assume that left(1,...,n) is the result after deleting from left to right once and
     * right(1,...,n) is that from right to left.
     * <p>
     * After one deletion, left(1,...,n) = 2,4,... whether n is odd or even. Then
     * right(2,4,...,)=2*right(1,2,...,n/2).
     */
    private int left2right(int n) {
        return n == 1 ? 1 : 2 * right2left(n / 2);
    }

    /**
     * Thinking of the parity of n:
     * <p>
     * 1. If n is odd, right(1,2,...,n) = 2,4,...,n-1. Then left(2,4,...,n-1)=2*left(1,2,...,n/2).
     * <p>
     * 2. If n is even, right(1,2,...,n) = 1,3,...,n-1. Then left(1,3,...,n-1)=left(2,4,...,n)-1=2*left(1,2,...,n/2)-1.
     */
    private int right2left(int n) {
        if (n == 1) {
            return 1;
        }
        if ((n & 1) == 1) {
            return 2 * left2right(n / 2);
        }
        return 2 * left2right(n / 2) - 1;
    }
}
