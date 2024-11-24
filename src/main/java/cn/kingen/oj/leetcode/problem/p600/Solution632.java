package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/">632. Smallest Range Covering Elements from K Lists</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution76

 */
@Question(
    tags = {Tag.GREEDY, Tag.ARRAY, Tag.HASH_TABLE, Tag.SORTING, Tag.SLIDING_WINDOW, Tag.HEAP_PRIORITY_QUEUE},
    difficulty = Difficulty.HARD
)
public class Solution632 {

    @Complexity(time = "O(nk*log(n))", space = "O(n)", note = "k is the average length of lists")
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        // nums[a[0]][a[1]] = a[2]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums.get(i).getFirst();
            pq.offer(new int[]{i, 0, num});
            right = Math.max(right, num);
        }
        int[] ans = new int[]{pq.element()[2], right}, p;

        while ((p = pq.element())[1] < nums.get(p[0]).size() - 1) { // has more elements in nums[p[0]]
            pq.poll();
            int num = nums.get(p[0]).get(p[1] + 1);
            pq.offer(new int[]{p[0], p[1] + 1, num});
            right = Math.max(right, num);
            if (right - pq.element()[2] < ans[1] - ans[0]) {
                ans[0] = pq.element()[2];
                ans[1] = right;
            }
        }
        return ans;
    }
}