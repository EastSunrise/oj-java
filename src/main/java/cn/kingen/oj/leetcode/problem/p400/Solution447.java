package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/number-of-boomerangs/">447. Number of Boomerangs</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution356
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution447 {

    @Complexity(time = "O(n^2)", space = "O(n)")
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] pi : points) {
            Map<Integer, Integer> countByDistance = new HashMap<>(16);
            for (int[] pj : points) {
                int distance = (int) (Math.pow(pj[0] - pi[0], 2) + Math.pow(pj[1] - pi[1], 2));
                int count = countByDistance.getOrDefault(distance, 0);
                ans += count << 1;
                countByDistance.put(distance, count + 1);
            }
        }
        return ans;
    }
}