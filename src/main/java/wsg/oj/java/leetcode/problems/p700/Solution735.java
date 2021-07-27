package wsg.oj.java.leetcode.problems.p700;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution605;

/**
 * 735. Asteroid Collision (MEDIUM)
 *
 * @author Kingen
 * @see Solution605
 * @see <a href="https://leetcode-cn.com/problems/asteroid-collision/">Asteroid Collision</a>
 * @since 2021-07-26
 */
public class Solution735 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> rights = new Stack<>();
        List<Integer> lefts = new ArrayList<>();
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
        for (int right : rights) {
            res[i++] = right;
        }
        return res;
    }
}
