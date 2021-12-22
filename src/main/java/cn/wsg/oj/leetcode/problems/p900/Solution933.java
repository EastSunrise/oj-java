package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. Number of Recent Calls (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-of-recent-calls/">Number of Recent
 * Calls</a>
 */
public class Solution933 implements Solution {

    static class RecentCounter {

        private final Queue<Integer> recent;

        public RecentCounter() {
            this.recent = new LinkedList<>();
        }

        public int ping(int t) {
            recent.offer(t);
            int min = t - 3000;
            while (!recent.isEmpty() && recent.peek() < min) {
                recent.poll();
            }
            return recent.size();
        }
    }
}
