package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximize-score-of-numbers-in-ranges/">3281. Maximize Score of Numbers in Ranges</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution719
 */
@Question(
        difficulty = Difficulty.MEDIUM
)
public class Solution3281 {

    @Complexity(time = "O(n*log(n))", space = "O(1)")
    public int maxPossibleScore(int[] start, int d) {
        int n = start.length;
        Arrays.sort(start);
        int low = 0, high = (start[n - 1] + d - start[0]) / (n - 1);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(start, d, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean check(int[] start, int d, int diff) {
        int n = start.length;
        int x = start[0];
        for (int i = 1; i < n; i++) {
            x += diff;
            if (start[i] > x) {
                x = start[i];
            } else if (start[i] + d < x) {
                return false;
            }
        }
        return true;
    }
}