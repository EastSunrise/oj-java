package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/magnetic-force-between-two-balls/">1552. Magnetic Force Between Two Balls</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2064

 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.MEDIUM,
        date = "2025-02-14"
)
public class Solution1552 {

    @Complexity(time = "O(n*log(n))", space = "O(1)")
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, position[i] - position[i - 1]);
        }

        int left = minDiff, right = (position[n - 1] - position[0]) / (m - 1);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (maxCount(position, n, mid) >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private int maxCount(int[] position, int n, int limit) {
        int prev = position[0], cnt = 1;
        for (int i = 1; i < n; i++) {
            if (position[i] - prev >= limit) {
                prev = position[i];
                cnt++;
            }
        }
        return cnt;
    }
}