package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-prefixes-of-a-given-string/">2255. Count Prefixes of a Given String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1455
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1961
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2185
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING},
        difficulty = Difficulty.EASY,
        date = "2025-03-24"
)
public class Solution2255 {

    @Complexity(time = "O(mn)", space = "O(1)")
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                cnt++;
            }
        }
        return cnt;
    }
}