package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution53;

/**
 * 978. Longest Turbulent Subarray (MEDIUM)
 *
 * @author Kingen
 * @see Solution53
 * @see <a href="https://leetcode-cn.com/problems/longest-turbulent-subarray/">Longest Turbulent
 * Subarray</a>
 */
public class Solution978 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int down = 1, up = 1, max = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                up = down + 1;
                down = 1;
                max = Math.max(max, up);
            } else if (arr[i - 1] > arr[i]) {
                down = up + 1;
                up = 1;
                max = Math.max(max, down);
            } else {
                up = down = 1;
            }
        }
        return max;
    }
}
