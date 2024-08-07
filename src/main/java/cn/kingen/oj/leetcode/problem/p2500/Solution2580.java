package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import cn.kingen.oj.leetcode.util.MathUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges/">2580. Count Ways to Group Overlapping Ranges</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution56
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2580 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int ans = 1, n = ranges.length;
        for (int i = 0; i < n; ) {
            int r = ranges[i][1];
            while (++i < n && ranges[i][0] <= r) {
                r = Math.max(ranges[i][1], r);
            }
            ans = (ans << 1) % MathUtils.MOD;
        }
        return ans;
    }
}