package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1600.Solution1671;

/**
 * 941. Valid Mountain Array (EASY)
 *
 * @author Kingen
 * @see Solution1671
 * @see <a href="https://leetcode-cn.com/problems/valid-mountain-array/">Valid Mountain Array</a>
 */
public class Solution941 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
