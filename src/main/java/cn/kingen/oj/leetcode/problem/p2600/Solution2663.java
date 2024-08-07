package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-beautiful-string/">2663. Lexicographically Smallest Beautiful String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1202
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2217
 */
@Question(
        tags = {Tag.GREEDY, Tag.STRING},
        difficulty = Difficulty.HARD
)
public class Solution2663 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String smallestBeautifulString(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        char max = (char) ('a' + k);
        int i = n - 1;
        chars[i]++;
        while (i < n) {
            if (chars[i] >= max) { // carry to the previous position
                if (i == 0) {
                    return "";
                }
                chars[i] = 'a';
                chars[--i]++;
            } else if (i > 0 && chars[i] == chars[i - 1] || (i > 1 && chars[i] == chars[i - 2])) {
                chars[i]++;
            } else {
                i++;
            }
        }
        return new String(chars);
    }
}