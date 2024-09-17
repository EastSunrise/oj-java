package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/points-that-intersect-with-cars/">2848. Points That Intersect With Cars</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution56
 * @see cn.kingen.oj.leetcode.problem.p200.Solution252
 * @see cn.kingen.oj.leetcode.problem.p200.Solution253

 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.PREFIX_SUM},
    difficulty = Difficulty.EASY
)
public class Solution2848 {

    @Complexity(time = "O(n*log(n))", space = "O(1)")
    public int numberOfPoints(List<List<Integer>> nums) {
        int n = nums.size();
        nums.sort(Comparator.comparingInt(List::getFirst));
        int ans = 0, start = nums.getFirst().getFirst(), end = nums.getFirst().get(1);
        for (int i = 1; i < n; i++) {
            int s = nums.get(i).getFirst(), e = nums.get(i).get(1);
            if (s > end) {
                ans += end - start + 1;
                start = s;
                end = e;
            } else {
                end = Math.max(end, e);
            }
        }
        return ans + end - start + 1;
    }
}