package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 946. Validate Stack Sequences (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/validate-stack-sequences/">Validate Stack
 * Sequences</a>
 * @since 2021-07-27
 */
public class Solution946 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i = 0, j = 0, k = -1;
        while (i < n) {
            // push a number into the stack
            pushed[++k] = pushed[i++];
            while (k >= 0 && pushed[k] == popped[j]) {
                // pop the top number of the stack
                k--;
                j++;
            }
        }
        return k == -1;
    }
}
