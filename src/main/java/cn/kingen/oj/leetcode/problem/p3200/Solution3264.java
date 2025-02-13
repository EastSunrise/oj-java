package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-i/">3264. Final Array State After K Multiplication Operations I</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.EASY,
        date = "2024-12-13"
)
public class Solution3264 {

    @Complexity(time = "O(k*log(n))", space = "O(n)")
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        // the index of the number
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.<Integer, Integer>comparing(i -> nums[i]).thenComparing(i -> i));
        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }
        while (k-- > 0) {
            int i = pq.remove();
            nums[i] *= multiplier;
            pq.offer(i);
        }
        return nums;
    }
}