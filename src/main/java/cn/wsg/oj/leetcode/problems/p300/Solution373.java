package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 373. Find K Pairs with Smallest Sums (Medium)
 *
 * @author Kingen
 * @see Solution378
 * @see Solution719
 * @see <a href="https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/">Find K Pairs
 * with Smallest Sums</a>
 */
public class Solution373 implements Solution {

    /**
     * @complexity T=O(k * log{k})
     * @complexity S=O(k * k)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        Queue<int[]> heap = new PriorityQueue<>(
            Comparator.comparing(arr -> nums1[arr[0]] + nums2[arr[1]])
        );
        boolean[][] visited = new boolean[Math.min(m, k + 1)][Math.min(n, k + 1)];
        heap.offer(new int[]{0, 0});
        visited[0][0] = true;

        List<List<Integer>> res = new ArrayList<>(k);
        while (!heap.isEmpty() && res.size() < k) {
            int[] pos = heap.remove();
            if (pos[0] < m - 1 && !visited[pos[0] + 1][pos[1]]) {
                heap.offer(new int[]{pos[0] + 1, pos[1]});
                visited[pos[0] + 1][pos[1]] = true;
            }
            if (pos[1] < n - 1 && !visited[pos[0]][pos[1] + 1]) {
                heap.offer(new int[]{pos[0], pos[1] + 1});
                visited[pos[0]][pos[1] + 1] = true;
            }
            res.add(List.of(nums1[pos[0]], nums2[pos[1]]));
        }
        return res;
    }
}
