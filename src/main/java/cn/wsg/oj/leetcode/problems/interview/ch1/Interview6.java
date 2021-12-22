package cn.wsg.oj.leetcode.problems.interview.ch1;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 面试题 1.6. Compress String LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/compress-string-lcci/">Compress String LCCI</a>
 */
public class Interview6 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String compressString(String S) {
        if (S.length() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        char prev = S.charAt(0);
        int count = 0;
        for (char ch : S.toCharArray()) {
            if (ch == prev) {
                count++;
            } else {
                builder.append(prev).append(count);
                prev = ch;
                count = 1;
            }
        }
        builder.append(prev).append(count);
        return builder.length() < S.length() ? builder.toString() : S;
    }
}
