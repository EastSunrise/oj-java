package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/select-k-disjoint-special-substrings/">3458. Select K Disjoint Special Substrings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3104
 */
@Question(
        difficulty = Difficulty.MEDIUM,
        contest = 437
)
public class Solution3458 {

    @Complexity(time = "O(n*m+m*log(m))", space = "O(n+m)", note = "m=26")
    public boolean maxSubstringLength(String s, int k) {
        int n = s.length(), m = 26;
        int[] chars = new int[n];
        for (int i = 0; i < n; i++) {
            chars[i] = s.charAt(i) - 'a';
        }
        int[][] range = new int[m][2];
        for (int i = 0; i < m; i++) {
            range[i][0] = n;
            range[i][1] = -1;
        }
        for (int i = 0; i < n; i++) {
            int ch = chars[i];
            range[ch][0] = Math.min(range[ch][0], i);
            range[ch][1] = i;
        }
        for (int i = 0; i < m; i++) {
            if (range[i][0] == n) {
                continue;
            }
            extendRange(chars, range, i);
        }

        Arrays.sort(range, Comparator.comparingInt(a -> a[0]));
        int right = -1, count = 0;
        for (int i = 0; i < m; i++) {
            if (range[i][0] == n) {
                break;
            }
            if (range[i][1] - range[i][0] == n - 1) {
                continue;
            }
            if (range[i][0] <= right) { // choose smaller right bound if overlapped
                right = Math.min(right, range[i][1]);
            } else {
                right = range[i][1];
                count++;
            }
        }
        return count >= k;
    }

    private void extendRange(int[] chars, int[][] range, int ch) {
        int prevLow = range[ch][0], prevHigh = range[ch][0];
        int curLow = range[ch][0], curHigh = range[ch][1];
        while (curLow < prevLow || prevHigh < curHigh) {
            int nextLow = curLow, nextHigh = curHigh;
            for (int i = curLow; i < prevLow; i++) {
                nextLow = Math.min(nextLow, range[chars[i]][0]);
                nextHigh = Math.max(nextHigh, range[chars[i]][1]);
            }
            for (int i = prevHigh + 1; i <= curHigh; i++) {
                nextLow = Math.min(nextLow, range[chars[i]][0]);
                nextHigh = Math.max(nextHigh, range[chars[i]][1]);
            }
            prevLow = curLow;
            prevHigh = curHigh;
            curLow = nextLow;
            curHigh = nextHigh;
        }
        range[ch][0] = curLow;
        range[ch][1] = curHigh;
    }
}