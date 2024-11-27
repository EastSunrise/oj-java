package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/alternating-groups-ii/">3208. Alternating Groups II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution3208 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0;
        for (int i = 0, j = 0; i < n; ) {
            while (j - i + 1 < k && colors[j % n] != colors[(j + 1) % n]) {
                j++;
            }

            if (j - i + 1 == k) { // colors[i,j] is alternating
                ans++;
                i++;
            } else { // start from colors[j+1]
                i = ++j;
            }
        }
        return ans;
    }
}