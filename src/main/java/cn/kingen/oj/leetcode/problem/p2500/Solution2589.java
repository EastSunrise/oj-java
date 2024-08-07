package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-to-complete-all-tasks/">2589. Minimum Time to Complete All Tasks</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1834
 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution2589 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        boolean[] used = new boolean[2001];
        int ans = 0;
        for (int[] task : tasks) {
            int start = task[0], end = task[1], duration = task[2];
            for (int i = start; i <= end; i++) {
                if (used[i]) {
                    duration--;
                }
            }
            for (int i = end; duration > 0; i--) {
                if (!used[i]) {
                    used[i] = true;
                    duration--;
                    ans++;
                }
            }
        }
        return ans;
    }
}