package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/relocate-marbles/">2766. Relocate Marbles</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.SORTING, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution2766 {

    @Complexity(time = "O(n*log{n}+m)", space = "O(n)")
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> stones = new HashSet<>();
        for (int num : nums) {
            stones.add(num);
        }
        for (int i = 0, m = moveFrom.length; i < m; i++) {
            stones.remove(moveFrom[i]);
            stones.add(moveTo[i]);
        }
        return stones.stream().sorted().toList();
    }
}