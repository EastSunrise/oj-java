package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import cn.kingen.oj.leetcode.util.StringUtils;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/">392. Is Subsequence</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution792
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1055
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2486
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2825
 */
@Question(
        tags = {Tag.TWO_POINTERS, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.EASY
)
public class Solution392 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean isSubsequence(String s, String t) {
        return StringUtils.isSubsequence(s, t);
    }
}