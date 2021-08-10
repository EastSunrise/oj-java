package wsg.oj.java.leetcode.problems.p200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 218. The Skyline Problem (HARD)
 *
 * @author Kingen
 * @see Solution699
 * @see <a href="https://leetcode-cn.com/problems/the-skyline-problem/">The Skyline Problem</a>
 * @since 2021-07-27
 */
public class Solution218 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<Integer> borders = new ArrayList<>();
        for (int[] building : buildings) {
            borders.add(building[0]);
            borders.add(building[1]);
        }
        Collections.sort(borders);

        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int border : borders) {
            while (i < n && buildings[i][0] <= border) {
                queue.offer(new int[]{buildings[i][1], buildings[i][2]});
                i++;
            }
            while (!queue.isEmpty() && queue.peek()[0] <= border) {
                queue.poll();
            }
            // the largest height within [border, queue.head]
            int height = queue.isEmpty() ? 0 : queue.peek()[1];
            if (res.isEmpty() || height != res.get(res.size() - 1).get(1)) {
                res.add(Arrays.asList(border, height));
            }
        }
        return res;
    }
}
