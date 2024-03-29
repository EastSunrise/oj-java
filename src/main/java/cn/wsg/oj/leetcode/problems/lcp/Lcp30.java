package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LCP 30. 魔塔游戏 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/p0NxJO/">魔塔游戏</a>
 */
public class Lcp30 implements Solution {

    /**
     * @complexity T=O(n*log{k}), k=the number of monsters
     * @complexity S=O(k)
     */
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
                // move the monster with largest damage to the tail
                blood -= heap.remove();
                cnt++;
            }
        }
        return cnt;
    }
}
