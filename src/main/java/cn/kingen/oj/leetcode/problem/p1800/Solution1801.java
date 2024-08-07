package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/number-of-orders-in-the-backlog/">1801. Number of Orders in the Backlog</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1801 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> buy = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int[] e;
        for (int[] order : orders) {
            int price = order[0], amount = order[1], type = order[2];
            if (type == 0) {
                while (amount > 0 && !sell.isEmpty() && (e = sell.peek())[0] <= price) {
                    if (amount >= e[1]) {
                        amount -= e[1];
                        sell.poll();
                    } else {
                        e[1] -= amount;
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    buy.offer(new int[]{price, amount});
                }
            } else if (type == 1) {
                while (amount > 0 && !buy.isEmpty() && (e = buy.peek())[0] >= price) {
                    if (amount >= e[1]) {
                        amount -= e[1];
                        buy.poll();
                    } else {
                        e[1] -= amount;
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    sell.offer(new int[]{price, amount});
                }
            }
        }
        return (int) ((buy.stream().mapToLong(t -> t[1]).sum() + sell.stream().mapToLong(t -> t[1]).sum()) % MOD);
    }
}