package wsg.oj.java.leetcode.problems.old;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kingen
 */
public class RecentCounter {

    private static final int SIZE = 3000;
    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.element() < t - SIZE) {
            queue.poll();
        }
        queue.add(t);
        return queue.size();
    }
}
