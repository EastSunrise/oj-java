package wsg.oj.java.leetcode.problems.p1800;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1894. Find the Student that Will Replace the Chalk (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/">Find
 * the Student that Will Replace the Chalk</a>
 * @since 2021-07-27
 */
public class Solution1894 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSums = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            prefixSums[i] = sum = sum + chalk[i];
        }
        k %= sum;
        int i = Arrays.binarySearch(prefixSums, k);
        return Math.abs(i + 1);
    }
}
