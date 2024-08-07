package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-maximum-number-of-string-pairs/">2744. Find Maximum Number of String Pairs</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution249
 * @see cn.kingen.oj.leetcode.problem.p300.Solution336
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution2744 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int maximumNumberOfStringPairs(String[] words) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (String word : words) {
            if (set.contains(word.charAt(1) * 100 + word.charAt(0))) {
                cnt++;
            } else {
                set.add(word.charAt(0) * 100 + word.charAt(1));
            }
        }
        return cnt;
    }
}