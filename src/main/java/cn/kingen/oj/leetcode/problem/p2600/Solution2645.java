package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-additions-to-make-valid-string/">2645. Minimum Additions to Make Valid String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1768
 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2645 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int addMinimum(String word) {
        int n = word.length(), groupCount = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i - 1) >= word.charAt(i)) {
                groupCount++;
            }
        }
        return groupCount * 3 - n;
    }
}