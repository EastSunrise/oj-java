package cn.wsg.oj.leetcode.problems.p1600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1642. Furthest Building You Can Reach (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/furthest-building-you-can-reach/">Furthest
 * Building You Can Reach</a>
 */
public class Solution1642 implements Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            if (heights[i] > heights[i - 1]) {
                if (ladders > 0) {
                    // use a ladder and record the bricks it represents
                    ladders--;
                    queue.offer(heights[i] - heights[i - 1]);
                } else {
                    // replace the shortest ladder with bricks
                    queue.offer(heights[i] - heights[i - 1]);
                    int min = queue.remove();
                    if (bricks >= min) {
                        bricks -= min;
                        ladders++;
                    } else {
                        // bricks are also not enough
                        return i - 1;
                    }
                }
            }
        }
        return n - 1;
    }
}
