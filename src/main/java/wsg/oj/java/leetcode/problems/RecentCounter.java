package wsg.oj.java.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kingen
 */
public class RecentCounter {

    private Queue<Integer> queue;
    private static final int SIZE = 3000;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.element() < t - SIZE)
            queue.poll();
        queue.add(t);
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        counter.ping(1);
        counter.ping(10);
        counter.ping(11);
        counter.ping(12);
        counter.ping(19);
        counter.ping(20);
        counter.ping(21);
    }
}
