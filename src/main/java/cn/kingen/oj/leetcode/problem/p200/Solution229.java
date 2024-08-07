package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

import static cn.kingen.oj.leetcode.util.ArrayUtils.findMajorityElements;

/**
 * <a href="https://leetcode.cn/problems/majority-element-ii/">229. Majority Element II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution169
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1150
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2404
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.COUNTING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution229 {

    @Complexity(time = "O(n)", space = "O(1)")
    public List<Integer> majorityElement(int[] nums) {
        return findMajorityElements(nums, 3);
    }
}