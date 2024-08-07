package cn.kingen.oj.leetcode.problem.p1200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/maximum-profit-in-job-scheduling/">1235. Maximum Profit in Job Scheduling</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2008
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2054
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution1235 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Integer[] indices = new Integer[n];
        Arrays.setAll(indices, p -> p);
        Arrays.sort(indices, Comparator.comparingInt(i -> startTime[i]));
        // dp[i]: max profit since job i
        int[] dp = new int[n + 1];
        for (int p = n - 1; p >= 0; p--) {
            int i = indices[p];
            int q = binarySearch(startTime, indices, endTime[i], p + 1);
            dp[p] = Math.max(dp[p + 1], profit[i] + dp[q]);
        }
        return dp[0];
    }

    private int binarySearch(int[] arr, Integer[] indices, int target, int start) {
        int low = start;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[indices[mid]];
            if (midVal < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}