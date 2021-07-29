package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 5. 替换空格 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/">替换空格 LCOF</a>
 * @since 2021-07-28
 */
public class Offer5 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                builder.append("%20");
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
