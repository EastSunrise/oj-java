package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-pairs-of-similar-strings/">2506. Count Pairs Of Similar Strings</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution451
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1684
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2421

 */
@Question(
    tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
    difficulty = Difficulty.EASY,
    date = "2025-02-22"
)
public class Solution2506 {

    @Complexity(time = "O(n * m)", space = "O(1)")
    public int similarPairs(String[] words) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char ch : word.toCharArray()) {
                mask |= 1 << (ch - 'a');
            }
            ans += freq.getOrDefault(mask, 0);
            freq.merge(mask, 1, Integer::sum);
        }
        return ans;
    }
}