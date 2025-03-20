package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/closest-equal-element-queries/">3488. Closest Equal Element Queries</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM,
        contest = 441
)
public class Solution3488 {

    @Complexity(time = "O(n+q)", space = "O(n)")
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, Integer> firsts = new HashMap<>(), lasts = new HashMap<>();
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            Integer prev = lasts.get(nums[i]);
            if (prev == null) {
                dist[i] = Integer.MAX_VALUE;
                firsts.put(nums[i], i);
            } else {
                dist[i] = i - prev;
                dist[prev] = Math.min(dist[prev], i - prev);
            }
            lasts.put(nums[i], i);
        }
        for (Map.Entry<Integer, Integer> entry : firsts.entrySet()) {
            int first = entry.getValue(), last = lasts.get(entry.getKey());
            if (first == last) {
                dist[first] = -1;
            } else {
                dist[first] = Math.min(dist[first], first + n - last);
                dist[last] = Math.min(dist[last], first + n - last);
            }
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int q : queries) {
            ans.add(dist[q]);
        }
        return ans;
    }
}