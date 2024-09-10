package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/exam-room/">855. Exam Room</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution849
 */
@Question(
        tags = {Tag.DESIGN, Tag.ORDERED_SET, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class ExamRoom {

    private final int n;
    // occupied seats
    private final TreeSet<Integer> seats;
    /**
     * Segments like PXX...XXP, including delayed-deleted ones.
     * <p>
     * a[0] is the index of the left 'P' and a[1] is the index of the right 'P'
     */
    private final PriorityQueue<int[]> queue;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
        this.queue = new PriorityQueue<>(Comparator.<int[], Integer>comparing(a -> (a[1] - a[0]) / 2).reversed().thenComparing(a -> a[0]));
    }

    @Complexity(time = "O(log(m))", space = "#", note = "m is the number of occupied seats")
    public int seat() {
        if (seats.isEmpty()) { // the first student
            seats.add(0);
            return 0;
        }
        int head = seats.first(), tail = n - 1 - seats.last();
        while (!queue.isEmpty()) {
            int[] seg = queue.peek();
            int le = seg[0], ri = seg[1];
            if (!seats.contains(le) || !seats.contains(ri) || seats.higher(le) != ri) { // deleted segment
                queue.poll();
                continue;
            }

            int dist = (ri - le) / 2;
            if (dist <= head || dist < tail) { // sit at head or tail
                break;
            }

            // sit at the middle seat[mid]
            int mid = le + dist;
            queue.poll();
            queue.offer(new int[]{le, mid});
            queue.offer(new int[]{mid, ri});
            seats.add(mid);
            return mid;
        }

        if (head >= tail) { // sit at the seat[0]
            queue.offer(new int[]{0, seats.first()});
            seats.add(0);
            return 0;
        }

        // sit at the seat[n-1]
        queue.offer(new int[]{seats.last(), n - 1});
        seats.add(n - 1);
        return n - 1;
    }

    @Complexity(time = "O(log(m))", space = "#", note = "m is the number of occupied seats")
    public void leave(int p) {
        Integer le = seats.lower(p), ri = seats.higher(p);
        if (le != null && ri != null) { // student sitting in the middle
            queue.offer(new int[]{le, ri});
        }
        seats.remove(p);
    }
}