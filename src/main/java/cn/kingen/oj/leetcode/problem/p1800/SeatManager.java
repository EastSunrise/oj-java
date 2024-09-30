package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/seat-reservation-manager/">1845. Seat Reservation Manager</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution379
 * @see cn.kingen.oj.leetcode.problem.p2300.NumberContainers
 */
@Question(
        tags = {Tag.DESIGN, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class SeatManager {

    // empty seats
    private final PriorityQueue<Integer> pq;
    private int size;

    public SeatManager(int n) {
        this.pq = new PriorityQueue<>();
        this.size = 0;
    }

    public int reserve() {
        if (!pq.isEmpty()) {
            return pq.remove();
        }
        return ++size;
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}