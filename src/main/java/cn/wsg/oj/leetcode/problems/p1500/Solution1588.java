package cn.wsg.oj.leetcode.problems.p1500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1588. Sum of All Odd Length Subarrays (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/">Sum of All Odd
 * Length Subarrays</a>
 */
public class Solution1588 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int leftEven = i / 2 + 1;
            int leftOdd = (i + 1) / 2;
            int rightEven = (n - i + 1) / 2;
            int rightOdd = (n - i) / 2;
            sum += (leftEven * rightEven + leftOdd * rightOdd) * arr[i];
        }
        return sum;
    }
}
