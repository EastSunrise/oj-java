package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. Positions of Large Groups (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/positions-of-large-groups/">Positions of Large
 * Groups</a>
 */
public class Solution830 implements Solution {

    /**
     * @see Complexity#TIME_N
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
