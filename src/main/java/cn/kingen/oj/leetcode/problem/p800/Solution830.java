package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/positions-of-large-groups/">830. Positions of Large Groups</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2138
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution830 {

    @Complexity(time = "O(n)", space = "O(1)")
    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ) {
            char ch = s.charAt(i);
            int j = i + 1;
            while (j < n && s.charAt(j) == ch) {
                j++;
            }
            if (j - i >= 3) {
                ans.add(Arrays.asList(i, j - 1));
            }
            i = j;
        }
        return ans;
    }
}