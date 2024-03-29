package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LCP 9. 最小跳跃次数 (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/zui-xiao-tiao-yue-ci-shu/">最小跳跃次数</a>
 */
public class Lcp9 implements Solution {

    /**
     * @see #BFS
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int minJump(int[] jump) {
        int n = jump.length;
        int step = 0, start = 1;
        Queue<Integer> indices = new LinkedList<>();

        indices.offer(0);
        while (!indices.isEmpty()) {
            step++;
            int size = indices.size();
            for (int i = 0; i < size; i++) {
                int cur = indices.remove();

                int next = cur + jump[cur];
                if (next >= n) {
                    return step;
                }
                if (next >= start) {
                    indices.offer(next);
                }
                for (int j = start; j < cur; j++) {
                    indices.offer(j);
                }
                start = Math.max(start, cur + 1);
            }
        }
        return -1;
    }
}
