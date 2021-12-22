package wsg.oj.java.leetcode.problems.p200;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution12;

/**
 * 273. Integer to English Words (HARD)
 *
 * @author Kingen
 * @see Solution12
 * @see <a href="https://leetcode-cn.com/problems/integer-to-english-words/">Integer to English
 * Words</a>
 * @since 2021-07-27
 */
public class Solution273 implements Solution {

    final String[] numbers = {
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };
    final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    final String[] units = {"Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        return num == 0 ? "Zero" : String.join(" ", toWords(num, 0));
    }

    private List<String> toWords(int num, int unit) {
        int prefix = num / 1000;
        num %= 1000;
        List<String> words;
        if (prefix > 0) {
            words = toWords(prefix, unit + 1);
            if (prefix % 1000 > 0) {
                words.add(units[unit]);
            }
        } else {
            words = new ArrayList<>();
        }

        prefix = num / 100;
        num %= 100;
        if (prefix > 0) {
            words.add(numbers[prefix]);
            words.add("Hundred");
        }
        if (num >= 20) {
            words.add(tens[num / 10]);
            num %= 10;
        }
        if (num > 0) {
            words.add(numbers[num]);
        }
        return words;
    }
}
