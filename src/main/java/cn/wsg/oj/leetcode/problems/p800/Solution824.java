package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 824. Goat Latin (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/goat-latin/">Goat Latin</a>
 */
public class Solution824 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String toGoatLatin(String sentence) {
        StringBuilder builder = new StringBuilder(sentence.length());
        int initial = 0, number = 1;
        for (char ch : (sentence + " ").toCharArray()) {
            if (ch == ' ') {
                char first = builder.charAt(initial);
                if (notVowel(first)) {
                    builder.deleteCharAt(initial);
                    builder.append(first);
                }
                builder.append("ma");
                builder.append("a".repeat(number++));
                builder.append(' ');
                initial = builder.length();
            } else {
                builder.append(ch);
            }
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    private boolean notVowel(char ch) {
        if (ch > 'U') {
            ch -= 32;
        }
        return ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U';
    }
}
