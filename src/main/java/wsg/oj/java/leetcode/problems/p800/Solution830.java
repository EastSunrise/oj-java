package wsg.oj.java.leetcode.problems.p800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 830. Positions of Large Groups (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/positions-of-large-groups/">Positions of Large
 * Groups</a>
 * @since 2021-07-27
 */
public class Solution830 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        while (start < n) {
            char ch = s.charAt(start);
            int end = start + 1;
            while (end < n && s.charAt(end) == ch) {
                end++;
            }
            if (end - start >= 3) {
                res.add(Arrays.asList(start, end - 1));
            }
            start = end;
        }
        return res;
    }
}
