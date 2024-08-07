package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/distribute-candies/">575. Distribute Candies</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3122
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3142
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.EASY
)
public class Solution575 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>();
        for (int candy : candyType) {
            types.add(candy);
        }
        return Math.min(types.size(), candyType.length / 2);
    }
}