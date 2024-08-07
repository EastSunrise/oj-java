package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges/">1553. Minimum Number of Days to Eat N Oranges</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MEMOIZATION, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution1553 {

    @Complexity(time = "O(log{n}*log{n})", space = "O(log{n}*log{n})")
    public int minDays(int n) {
        return dfs(new HashMap<>(), n);
    }

    private int dfs(Map<Integer, Integer> memo, int n) {
        if (n <= 2) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int days = 1 + Math.min(n % 2 + dfs(memo, n / 2), n % 3 + dfs(memo, n / 3));
        memo.put(n, days);
        return days;
    }
}