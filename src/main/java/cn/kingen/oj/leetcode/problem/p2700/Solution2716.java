package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimize-string-length/">2716. Minimize String Length</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1047
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1209
 */
@Question(
    tags = {Tag.HASH_TABLE, Tag.STRING},
    difficulty = Difficulty.EASY,
    date = "2025-03-28"
)
public class Solution2716 {

    @Complexity(time = "O(n)", space = "O(C)", note = "C is the size of charset")
    public int minimizedStringLength(String s) {
        int[] freq = new int[26];
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a']++ == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}