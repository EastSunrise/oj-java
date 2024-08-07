package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/ambiguous-coordinates/">816. Ambiguous Coordinates</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STRING, Tag.BACKTRACKING, Tag.ENUMERATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution816 {

    @Complexity(time = "O(n^3)", space = "O(n^2)")
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (String left : getValidString(s.substring(0, i))) {
                for (String right : getValidString(s.substring(i))) {
                    ans.add("(" + left + ", " + right + ")");
                }
            }
        }
        return ans;
    }

    private List<String> getValidString(String s) {
        List<String> valid = new ArrayList<>();
        if (s.endsWith("0")) {
            if ("0".equals(s) || !s.startsWith("0")) {
                valid.add(s);
            }
        } else if (s.startsWith("0")) {
            valid.add("0." + s.substring(1));
        } else {
            valid.add(s);
            for (int i = 1; i < s.length(); i++) {
                valid.add(s.substring(0, i) + "." + s.substring(i));
            }
        }
        return valid;
    }
}