package wsg.oj.java.leetcode.problems.p1600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution215;

/**
 * 1619. Mean of Array After Removing Some Elements (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/mean-of-array-after-removing-some-elements/">Mean
 * of Array After Removing Some Elements</a>
 * @since 2021-07-27
 */
public class Solution1619 extends Solution215 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public double trimMean(int[] arr) {
        int n = arr.length;
        int start = n / 20, end = n - start;
        findKthSmallest(arr, start, 0, n);
        findKthSmallest(arr, end, 0, n);
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum * 1.0 / (end - start);
    }
}
