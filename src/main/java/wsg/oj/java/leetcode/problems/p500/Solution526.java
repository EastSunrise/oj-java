package wsg.oj.java.leetcode.problems.p500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution667;

/**
 * 526. Beautiful Arrangement (MEDIUM)
 *
 * @author Kingen
 * @see Solution667
 * @see <a href="https://leetcode-cn.com/problems/beautiful-arrangement/">Beautiful Arrangement</a>
 * @since 2021-07-20
 */
public class Solution526 implements Solution {

    /**
     * @see #DFS
     */
    public int countArrangement(int n) {
        Map<Integer, List<Integer>> options = new HashMap<>(n);
        for (int i = 1; i <= n; i++) {
            options.computeIfAbsent(i, size -> new ArrayList<>()).add(i);
            for (int j = 2 * i; j <= n; j += i) {
                options.computeIfAbsent(i, size -> new ArrayList<>()).add(j);
                options.computeIfAbsent(j, size -> new ArrayList<>()).add(i);
            }
        }
        return choose(options, new boolean[n + 1], n);
    }

    private int choose(Map<Integer, List<Integer>> map, boolean[] chosen, int i) {
        if (i == 1) {
            return 1;
        }
        List<Integer> options = map.get(i);
        int count = 0;
        for (int option : options) {
            if (!chosen[option]) {
                chosen[option] = true;
                count += choose(map, chosen, i - 1);
                chosen[option] = false;
            }
        }
        return count;
    }
}
