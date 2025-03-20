package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-beautiful-numbers/">3490. Count Beautiful Numbers</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD,
        contest = 441
)
public class Solution3490 {

    private static final Map<Long, Integer> memo = new HashMap<>();

    public int beautifulNumbers(int l, int r) {
        return calculate(r) - calculate(l - 1);
    }

    private int calculate(int x) {
        int[] digits = new int[10];
        int n = 0;
        while (x > 0) {
            digits[n++] = x % 10;
            x /= 10;
        }
        return dfs(digits, 1, 0, n - 1, true, false);
    }

    private int dfs(int[] high, int p, int s, int i, boolean withLimit, boolean isNum) {
        if (i < 0) {
            return s > 0 && p % s == 0 ? 1 : 0;
        }
        long mask = (long) p << 32 | (long) s << 16 | i;
        if (!withLimit && isNum && memo.containsKey(mask)) {
            return memo.get(mask);
        }

        int cnt = 0;
        cnt += dfs(high, isNum ? 0 : 1, s, i - 1, withLimit && high[i] == 0, isNum); // fill zero
        for (int d = 1; d <= 9; d++) {
            if (withLimit && d > high[i]) { // out of range
                continue;
            }
            cnt += dfs(high, p * d, s + d, i - 1, withLimit && high[i] == d, true);
        }
        if (!withLimit && isNum) {
            memo.put(mask, cnt);
        }
        return cnt;
    }
}