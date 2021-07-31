package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 941. Valid Mountain Array (EASY)
 *
 * @author Kingen
 * @see Solution1671
 * @see <a href="https://leetcode-cn.com/problems/valid-mountain-array/">Valid Mountain Array</a>
 * @since 2021-07-27
 */
public class Solution941 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int i = 1;
        while (i < n && arr[i] > arr[i - 1]) {
            i++;
        }
        if (i == 1 || i == n) {
            return false;
        }
        while (i < n && arr[i] < arr[i - 1]) {
            i++;
        }
        return i == n;
    }
}
