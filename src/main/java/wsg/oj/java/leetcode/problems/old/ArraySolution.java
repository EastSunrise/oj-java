package wsg.oj.java.leetcode.problems.old;

/**
 * @author Kingen
 */
public class ArraySolution {

    // 849. 到最近的人的最大距离
    private int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int first = -1, last = len;
        while (++first < len && seats[first] == 0) {
        }
        while (--last >= 0 && seats[last] == 0) {
        }
        int max = Math.max(first, len - 1 - last);
        while (first < last) {
            int next = first;
            while (seats[++next] == 0) {
            }
            int dist = (next - first) >> 1;
            if (dist > max) {
                max = dist;
            }
            first = next;
        }
        return max;
    }
}
