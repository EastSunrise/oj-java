package cn.kingen.oj.leetcode.problem.lcp;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/p0NxJO/">LCP 30. 魔塔游戏</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Lcp030 {

    @Complexity(time = "O(n*log{k})", space = "O(k)", note = "k is the number of monsters")
    public int magicTower(int[] nums) {
        long blood = 1;
        for (int num : nums) {
            blood += num;
        }
        if (blood <= 0) {
            return -1;
        }

        int cnt = 0;
        blood = 1;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            blood += num;
            if (num < 0) {
                heap.offer(num);
            }
            if (blood <= 0) {
                // move the monster with the largest damage to the tail
                blood -= heap.remove();
                cnt++;
            }
        }
        return cnt;
    }
}