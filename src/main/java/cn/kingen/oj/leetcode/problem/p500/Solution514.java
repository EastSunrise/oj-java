package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.kingen.oj.leetcode.util.ArrayUtils.binarySearch;

/**
 * <a href="https://leetcode.cn/problems/freedom-trail/">514. Freedom Trail</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution514 {

    @Complexity(time = "O(nm*log{m})", space = "O(m)")
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }

        List<int[]> ops = List.of(new int[]{0, 0});
        for (int i = 0; i < n; i++) {
            int len = ops.size();
            List<Integer> indices = map.get(key.charAt(i));
            List<int[]> nextOps = new ArrayList<>(indices.size());
            for (int idx : indices) {
                int j = binarySearch(ops, t -> t[0] - idx);
                int[] leftOp = ops.get((j - 1 + len) % len);
                int leftStep = Math.abs(leftOp[0] - idx);
                int leftSum = leftOp[1] + Math.min(leftStep, m - leftStep);
                int[] rightOp = ops.get(j % len);
                int rightStep = Math.abs(rightOp[0] - idx);
                int rightSum = rightOp[1] + Math.min(rightStep, m - rightStep);
                nextOps.add(new int[]{idx, Math.min(leftSum, rightSum)});
            }
            ops = nextOps;
        }
        int min = Integer.MAX_VALUE;
        for (int[] op : ops) {
            min = Math.min(min, op[1]);
        }
        return min + n;
    }
}