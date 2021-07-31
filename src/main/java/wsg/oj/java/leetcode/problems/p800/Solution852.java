package wsg.oj.java.leetcode.problems.p800;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution162;

/**
 * 852. Peak Index in a Mountain Array (EASY)
 *
 * @author Kingen
 * @see Solution162
 * @see Solution1095
 * @see Solution1671
 * @see <a href="https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/">Peak Index in a
 * Mountain Array</a>
 * @since 2021-07-27
 */
public class Solution852 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
