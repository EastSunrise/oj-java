package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p600.Solution605;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 735. Asteroid Collision (MEDIUM)
 *
 * @author Kingen
 * @see Solution605
 * @see <a href="https://leetcode-cn.com/problems/asteroid-collision/">Asteroid Collision</a>
 */
public class Solution735 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> lefts = new ArrayList<>();
        Deque<Integer> rights = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                rights.push(asteroid);
            } else {
                int crash = asteroid;
                while (!rights.isEmpty() && crash < 0) {
                    crash = asteroid + rights.peek();
                    if (crash < 0) {
                        rights.pop();
                    }
                }
                if (crash < 0) {
                    lefts.add(asteroid);
                } else if (crash == 0) {
                    rights.pop();
                }
            }
        }
        int[] res = new int[lefts.size() + rights.size()];
        int i = 0;
        for (int left : lefts) {
            res[i++] = left;
        }
        while (!rights.isEmpty()) {
            res[i++] = rights.removeLast();
        }
        return res;
    }
}
