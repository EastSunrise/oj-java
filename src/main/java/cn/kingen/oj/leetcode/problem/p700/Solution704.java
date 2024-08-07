package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static java.util.Arrays.binarySearch;

/**
 * <a href="https://leetcode.cn/problems/binary-search/">704. Binary Search</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution702
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2529
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.EASY
)
public class Solution704 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public int search(int[] nums, int target) {
        int i = binarySearch(nums, target);
        return i < 0 ? -1 : i;
    }
}