package wsg.oj.java.leetcode.problems.p700;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 781. Rabbits in Forest (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/rabbits-in-forest/">Rabbits in Forest</a>
 * @since 2021-07-27
 */
public class Solution781 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int answer : answers) {
            answer++;
            counts.put(answer, counts.getOrDefault(answer, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            count += ((entry.getValue() - 1) / entry.getKey() + 1) * entry.getKey();
        }
        return count;
    }
}
