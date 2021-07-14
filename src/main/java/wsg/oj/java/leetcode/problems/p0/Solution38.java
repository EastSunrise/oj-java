package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution443;

/**
 * 38. Count and Say (Medium)
 *
 * @author Kingen
 * @see Solution271
 * @see Solution443
 * @see <a href="https://leetcode-cn.com/problems/count-and-say/">Count and Say</a>
 * @since 2021-07-10
 */
public class Solution38 implements Solution {

    /**
     * @see Complexity#TIME_2_N
     * @see Complexity#SPACE_N
     */
    public String countAndSay(int n) {
        String res = "1";
        while (n-- > 1) {
            StringBuilder builder = new StringBuilder();
            char current = res.charAt(0);
            int count = 1, len = res.length();
            for (int i = 1; i < len; i++) {
                char ch = res.charAt(i);
                if (ch != current) {
                    builder.append(count).append(current);
                    current = ch;
                    count = 1;
                } else {
                    count++;
                }
            }
            builder.append(count).append(current);
            res = builder.toString();
        }
        return res;
    }
}
