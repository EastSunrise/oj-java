package cn.wsg.oj.leetcode.problems.p1800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 1894. Find the Student that Will Replace the Chalk (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/">Find
 * the Student that Will Replace the Chalk</a>
 */
public class Solution1894 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int[] prefixSums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
            if (sum > k) {
                return i;
            }
            prefixSums[i] = sum;
        }
        k %= sum;
        int i = Arrays.binarySearch(prefixSums, k);
        return Math.abs(i + 1);
    }
}
