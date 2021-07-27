package wsg.oj.java.leetcode.problems.p800;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 816. Ambiguous Coordinates (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/ambiguous-coordinates/">Ambiguous Coordinates</a>
 * @since 2021-07-27
 */
public class Solution816 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NNN
     * @see wsg.oj.java.Complexity#SPACE_NNN
     */
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (String left : getValidString(s.substring(0, i))) {
                for (String right : getValidString(s.substring(i))) {
                    StringBuilder builder = new StringBuilder()
                        .append("(").append(left).append(", ")
                        .append(right).append(")");
                    res.add(builder.toString());
                }
            }
        }
        return res;
    }

    private List<String> getValidString(String s) {
        List<String> res = new ArrayList<>();
        if (s.endsWith("0")) {
            if ("0".equals(s) || !s.startsWith("0")) {
                res.add(s);
            }
        } else if (s.startsWith("0")) {
            res.add("0." + s.substring(1));
        } else {
            res.add(s);
            for (int i = 1; i < s.length(); i++) {
                res.add(s.substring(0, i) + "." + s.substring(i));
            }
        }
        return res;
    }
}
