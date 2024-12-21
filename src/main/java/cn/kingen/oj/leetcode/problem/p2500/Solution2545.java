package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sort-the-students-by-their-kth-score/">2545. Sort the Students by Their Kth Score</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution587
 * @see cn.kingen.oj.leetcode.problem.p700.Solution791
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2418

 */
@Question(
    tags = {Tag.ARRAY, Tag.MATRIX, Tag.SORTING},
    difficulty = Difficulty.MEDIUM
)
public class Solution2545 {

    @Complexity(time = "O(m*log(m))", space = "O(1)")
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a1, a2) -> Integer.compare(a2[k], a1[k]));
        return score;
    }
}