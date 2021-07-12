package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 151. Reverse Words in a String (Medium)
 *
 * @author Kingen
 * @see Solution186
 * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string/">Reverse Words in a
 * String</a>
 * @since 2021-07-12
 */
class Solution151 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String reverseWords(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (builder.length() > 0) {
                    res.add(builder.toString());
                    builder = new StringBuilder();
                }
            } else {
                builder.append(ch);
            }
        }
        if (builder.length() > 0) {
            res.add(builder.toString());
        }
        Collections.reverse(res);
        return String.join(" ", res);
    }
}
