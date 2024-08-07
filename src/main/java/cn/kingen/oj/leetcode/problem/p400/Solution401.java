package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-watch/">401. Binary Watch</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution17
 * @see cn.kingen.oj.leetcode.problem.p100.Solution191
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.BACKTRACKING},
        difficulty = Difficulty.EASY
)
public class Solution401 {

    @Complexity(time = "O(1)", space = "O(1)")
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int hc = 0; hc < 4; hc++) {
            int mc = turnedOn - hc;
            if (mc < 0 || mc >= 6) {
                continue;
            }
            List<Integer> hours = new ArrayList<>();
            dfs(hours, 4, hc, 0, 0);
            List<Integer> minutes = new ArrayList<>();
            dfs(minutes, 6, mc, 0, 0);
            for (int h : hours) {
                if (h < 12) {
                    for (int min : minutes) {
                        if (min < 60) {
                            ans.add(String.format("%d:%02d", h, min));
                        }
                    }
                }
            }
        }
        return ans;
    }

    private void dfs(List<Integer> res, int n, int c, int i, int v) {
        if (c == 0) {
            res.add(v);
            return;
        }
        if (i >= n) {
            return;
        }
        // choose this bit
        dfs(res, n, c - 1, i + 1, v | (1 << i));
        // not choose this bit
        dfs(res, n, c, i + 1, v);
    }
}