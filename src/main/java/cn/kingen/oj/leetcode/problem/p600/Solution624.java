package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-distance-in-arrays/">624. Maximum Distance in Arrays</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM,
        date = "2025-02-19"
)
public class Solution624 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size(), ans = 0;
        int min = arrays.getFirst().getFirst(), max = arrays.getFirst().getLast();
        for (int i = 1; i < n; i++) {
            List<Integer> arr = arrays.get(i);
            ans = Math.max(ans, Math.max(max - arr.getFirst(), arr.getLast() - min));
            min = Math.min(min, arr.getFirst());
            max = Math.max(max, arr.getLast());
        }
        return ans;
    }
}