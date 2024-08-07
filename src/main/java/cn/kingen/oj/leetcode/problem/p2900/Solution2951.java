package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-the-peaks/">2951. Find the Peaks</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.ENUMERATION},
        difficulty = Difficulty.EASY
)
public class Solution2951 {

    @Complexity(time = "O(n)", space = "O(1)")
    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n - 1; ) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                ans.add(i);
                i += 2;
            } else {
                i++;
            }
        }
        return ans;
    }
}