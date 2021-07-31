package wsg.oj.java.leetcode.problems.p800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 874. Walking Robot Simulation (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/walking-robot-simulation/">Walking Robot
 * Simulation</a>
 * @since 2021-07-27
 */
public class Solution874 implements Solution {

    /**
     * @complexity T=O(L), L=the total length of the path the robot goes through
     * @complexity S=O(m), m=the number of obstacles
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> obs = new HashMap<>(obstacles.length);
        for (int[] obstacle : obstacles) {
            obs.computeIfAbsent(obstacle[0], key -> new HashSet<>()).add(obstacle[1]);
        }
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int max = 0;
        // direction: 0-N, 1-E, 2-S, 3-W
        int dir = 0, x = 0, y = 0;
        for (int cmd : commands) {
            if (cmd > 0) {
                for (int i = 0; i < cmd; i++) {
                    x += dx[dir];
                    y += dy[dir];
                    Set<Integer> ys = obs.get(x);
                    if (ys != null && ys.contains(y)) {
                        x -= dx[dir];
                        y -= dy[dir];
                        break;
                    }
                }
                int dist = x * x + y * y;
                if (dist > max) {
                    max = dist;
                }
            } else if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else {
                dir = (dir + 3) % 4;
            }
        }
        return max;
    }
}
