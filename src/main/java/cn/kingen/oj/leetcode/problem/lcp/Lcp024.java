package cn.kingen.oj.leetcode.problem.lcp;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/5TxKeK/">LCP 24. 数字游戏</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Lcp024 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int[] numsGame(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        long lowerSum = 0, higherSum = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i] - i;
            if (lower.size() == higher.size()) {
                if (lower.isEmpty() || num <= higher.peek()) {
                    lower.offer(num);
                    lowerSum += num;
                } else {
                    higher.offer(num);
                    higherSum += num;
                    lower.offer(higher.poll());
                    higherSum -= lower.element();
                    lowerSum += lower.element();
                }
                ans[i] = (int) ((higherSum - lowerSum + lower.element()) % MOD);
            } else {
                if (num >= lower.element()) {
                    higher.offer(num);
                    higherSum += num;
                } else {
                    lower.offer(num);
                    lowerSum += num;
                    higher.offer(lower.poll());
                    lowerSum -= higher.element();
                    higherSum += higher.element();
                }
                ans[i] = (int) ((higherSum - lowerSum) % MOD);
            }
        }
        return ans;
    }
}