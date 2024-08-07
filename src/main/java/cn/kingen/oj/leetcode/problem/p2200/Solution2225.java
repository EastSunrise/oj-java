package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <a href="https://leetcode-cn.com/problems/find-players-with-zero-or-one-losses/">2225. Find Players With Zero or One Losses</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.MEDIUM,
        tags = {
                Tag.ARRAY, Tag.HASH_TABLE, Tag.COUNTING, Tag.SORTING
        }
)
public class Solution2225 {

    @Complexity(time = "O(n*log{n})", space = "O(n)", note = "n is the number of matches")
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loses = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            loses.putIfAbsent(winner, 0);
            loses.merge(loser, 1, Integer::sum);
        }
        List<Integer> zeroLosers = new ArrayList<>(), oneLosers = new ArrayList<>();
        loses.forEach((key, value) -> {
            if (value == 0) {
                zeroLosers.add(key);
            } else if (value == 1) {
                oneLosers.add(key);
            }
        });
        zeroLosers.sort(Integer::compareTo);
        oneLosers.sort(Integer::compareTo);
        return List.of(zeroLosers, oneLosers);
    }
}