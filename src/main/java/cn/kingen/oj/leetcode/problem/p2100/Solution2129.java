package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/capitalize-the-title/">2129. Capitalize the Title</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution520
 * @see cn.kingen.oj.leetcode.problem.p700.Solution709
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution2129 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String capitalizeTitle(String title) {
        char[] chars = title.toCharArray();
        for (int i = 0, len = chars.length; i < len; ) {
            int j = i;
            while (j < chars.length && chars[j] != ' ') {
                if (chars[j] <= 'Z') {
                    chars[j] = (char) (chars[j] + 32);
                }
                j++;
            }
            if (j - i > 2) {
                chars[i] = (char) (chars[i] - 32);
            }
            i = j + 1;
        }
        return new String(chars);
    }
}