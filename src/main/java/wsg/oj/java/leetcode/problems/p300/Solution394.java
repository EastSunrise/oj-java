package wsg.oj.java.leetcode.problems.p300;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 394. Decode String (Medium)
 *
 * @author Kingen
 * @see Solution471
 * @see Solution726
 * @see Solution1087
 * @see <a href="https://leetcode-cn.com/problems/decode-string/">Decode String</a>
 * @since 2021-07-06
 */
public class Solution394 implements Solution {

    /**
     * @complexity T=O(n)
     * @complexity S=O(L), L=len(result)
     */
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> words = new Stack<>();
        StringBuilder word = new StringBuilder();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                counts.push(count);
                words.push(word);
                word = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                String repeat = word.toString().repeat(counts.pop());
                word = words.pop().append(repeat);
            } else if (ch <= '9') {
                count = count * 10 + (ch - '0');
            } else {
                word.append(ch);
            }
        }
        return word.toString();
    }
}
