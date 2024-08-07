package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/decode-string/">394. Decode String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution471
 * @see cn.kingen.oj.leetcode.problem.p700.Solution726
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1087
 */
@Question(
        tags = {Tag.STACK, Tag.RECURSION, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution394 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> words = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        int count = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '[') { // push context and start a new word
                counts.push(count);
                words.push(word);
                word = new StringBuilder();
                count = 0;
            } else if (ch == ']') { // repeat the word and pop context
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