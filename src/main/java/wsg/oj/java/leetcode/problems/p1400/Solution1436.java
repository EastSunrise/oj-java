package wsg.oj.java.leetcode.problems.p1400;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1436. Destination City (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/destination-city/">Destination City</a>
 * @since 2021-07-27
 */
public class Solution1436 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
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
