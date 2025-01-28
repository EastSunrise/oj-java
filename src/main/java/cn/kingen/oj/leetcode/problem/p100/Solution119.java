package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/">119. Pascal's Triangle II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution118
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2221
 */
@Question(
    tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.EASY,
    daily = "2025-01-28"
)
public class Solution119 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ans.add((int) ((long) ans.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return ans;
    }
}