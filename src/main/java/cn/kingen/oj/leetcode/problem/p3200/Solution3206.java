package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/alternating-groups-i/">3206. Alternating Groups I</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.SLIDING_WINDOW},
    difficulty = Difficulty.EASY
)
public class Solution3206 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (colors[i - 2] != colors[i - 1] && colors[i - 1] != colors[i]) {
                ans++;
            }
        }
        if (colors[0] != colors[n - 1]) {
            if (colors[0] != colors[1]) {
                ans++;
            }
            if (colors[n - 2] != colors[n - 1]) {
                ans++;
            }
        }
        return ans;
    }
}