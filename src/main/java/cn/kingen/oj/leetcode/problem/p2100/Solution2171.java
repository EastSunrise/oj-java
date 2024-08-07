package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/">2171. Removing Minimum Number of Magic Beans</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution462
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1658
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.ENUMERATION, Tag.PREFIX_SUM, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2171 {

    @Complexity(time = "O(n*log{n})", space = "O(log{n})")
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long total = 0;
        for (int bean : beans) {
            total += bean;
        }
        long remaining = 0;
        for (int i = 0; i < n; i++) {
            remaining = Math.max(remaining, (long) beans[i] * (n - i));
        }
        return total - remaining;
    }
}