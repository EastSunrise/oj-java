package wsg.oj.java.leetcode.problems.p1500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1574. Shortest Subarray to be Removed to Make Array Sorted (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/">Shortest
 * Subarray to be Removed to Make Array Sorted</a>
 * @since 2021-07-27
 */
public class Solution1574 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 1;
        while (left < n && arr[left - 1] <= arr[left]) {
            left++;
        }
        if (left == n) {
            return 0;
        }
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        int i = 0, j = right, min = Math.min(right, n - left);
        while (i < left && j < n) {
            if (arr[i] > arr[j]) {
                j++;
            } else {
                // remaining array: arr[0,i] + arr[j,n-1]
                min = Math.min(min, j - i - 1);
                i++;
            }
        }
        return min;
    }
}
