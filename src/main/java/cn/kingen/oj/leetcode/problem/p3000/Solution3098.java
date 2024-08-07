package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/find-the-sum-of-subsequence-powers/">3098. Find the Sum of Subsequence Powers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1498
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1755
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution3098 {

    @Complexity(time = "k*n^4", space = "k*n^3")
    public int sumOfPowers(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Map<Integer, Integer>>> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Map<Integer, Integer>> list = new ArrayList<>(k + 1);
            for (int j = 0; j <= k; j++) {
                list.add(new HashMap<>());
            }
            dp.add(list);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            dp.get(i).get(1).put(Integer.MAX_VALUE, 1);
            for (int j = 0; j < i; j++) {
                int power = nums[i] - nums[j];
                for (int p = 2; p <= k; p++) {
                    for (var entry : dp.get(j).get(p - 1).entrySet()) {
                        int v = entry.getKey(), cnt = entry.getValue();
                        dp.get(i).get(p).merge(Math.min(v, power), cnt, (a, b) -> (a + b) % MOD);
                    }
                }
            }

            for (var entry : dp.get(i).get(k).entrySet()) {
                int v = entry.getKey(), cnt = entry.getValue();
                sum = (sum + (long) v * cnt) % MOD;
            }
        }
        return (int) sum;
    }
}