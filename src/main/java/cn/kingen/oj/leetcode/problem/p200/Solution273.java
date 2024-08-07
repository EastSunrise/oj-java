package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.NUMBER_WORDS;
import static cn.kingen.oj.leetcode.util.MathUtils.TEN_NUMBER_WORDS;

/**
 * <a href="https://leetcode.cn/problems/integer-to-english-words/">273. Integer to English Words</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution12
 */
@Question(
        tags = {Tag.RECURSION, Tag.MATH, Tag.STRING},
        difficulty = Difficulty.HARD
)
public class Solution273 {

    @Complexity(time = "O(log{num})", space = "O(log{num})")
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        if (num >= 1_000_000_000) {
            toWords(sb, num / 1_000_000_000);
            sb.append("Billion ");
            num %= 1_000_000_000;
        }
        if (num >= 1_000_000) {
            toWords(sb, num / 1_000_000);
            sb.append("Million ");
            num %= 1_000_000;
        }
        if (num >= 1000) {
            toWords(sb, num / 1000);
            sb.append("Thousand ");
            num %= 1000;
        }
        toWords(sb, num);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * @param num 1-999
     */
    private void toWords(StringBuilder sb, int num) {
        if (num >= 100) {
            sb.append(NUMBER_WORDS[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            sb.append(TEN_NUMBER_WORDS[num / 10]).append(" ");
            num %= 10;
        }
        if (num > 0) {
            sb.append(NUMBER_WORDS[num]).append(" ");
        }
    }
}