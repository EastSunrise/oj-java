package cn.wsg.oj.leetcode.problems.p1400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1436. Destination City (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/destination-city/">Destination City</a>
 */
public class Solution1436 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String destCity(List<List<String>> paths) {
        Set<String> starts = new HashSet<>();
        for (List<String> path : paths) {
            starts.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!starts.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
