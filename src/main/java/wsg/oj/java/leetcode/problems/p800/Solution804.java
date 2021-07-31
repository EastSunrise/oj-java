package wsg.oj.java.leetcode.problems.p800;

import java.util.HashSet;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 804. Unique Morse Code Words (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/unique-morse-code-words/">Unique Morse Code
 * Words</a>
 * @since 2021-07-27
 */
public class Solution804 implements Solution {

    String[] morse = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
        "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                builder.append(morse[ch - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }
}
