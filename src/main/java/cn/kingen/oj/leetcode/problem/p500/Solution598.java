package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/range-addition-ii/">598. Range Addition II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution370
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2718
 */
@Question(
    tags = {Tag.ARRAY, Tag.MATH},
    difficulty = Difficulty.EASY,
        date = "2025-02-02"
)
public class Solution598 {

    @Complexity(time = "O(mn)", space = "O(1)")
    public int maxCount(int m, int n, int[][] ops) {
        int r = m, c = n;
        for (int[] op : ops) {
            r = Math.min(r, op[0]);
            c = Math.min(c, op[1]);
        }
        return r * c;
    }
}