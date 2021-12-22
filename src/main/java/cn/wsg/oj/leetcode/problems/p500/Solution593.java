package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * 593. Valid Square (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/valid-square/">Valid Square</a>
 */
class Solution593 implements Solution {

    Map<Integer, Integer> counts = new HashMap<>(6);

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        distance(p1, p2);
        distance(p1, p3);
        distance(p1, p4);
        distance(p2, p3);
        distance(p2, p4);
        distance(p3, p4);
        if (counts.size() != 2) {
            return false;
        }
        int side = -1, hypotenuse = -1;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 2) {
                hypotenuse = entry.getKey();
            } else if (entry.getValue() == 4) {
                side = entry.getKey();
            } else {
                return false;
            }
        }
        return side != 0 && side * 2 == hypotenuse;
    }

    private void distance(int[] p1, int[] p2) {
        int dist = (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
        counts.put(dist, counts.getOrDefault(dist, 0) + 1);
    }
}
