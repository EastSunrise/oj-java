package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/apply-discount-to-prices/">2288. Apply Discount to Prices</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution43
 * @see cn.kingen.oj.leetcode.problem.p1300.Cashier
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2288 {

    @Complexity(time = "O(n)", space = "O(n)", note = "n is the length of the sentence")
    public String discountPrices(String sentence, int discount) {
        double rate = 1 - discount / 100.0;
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.charAt(0) == '$') {
                int j = 1, m = word.length();
                long price = 0;
                char ch;
                while (j < m && (ch = word.charAt(j)) >= '0' && ch <= '9') {
                    price = price * 10 + ch - '0';
                    j++;
                }
                if (j == m && m > 1) {
                    words[i] = String.format("$%.2f", price * rate);
                }
            }
        }
        return String.join(" ", words);
    }
}