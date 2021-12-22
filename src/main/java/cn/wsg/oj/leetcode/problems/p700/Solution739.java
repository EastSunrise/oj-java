package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution496;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. Daily Temperatures (MEDIUM)
 *
 * @author Kingen
 * @see Solution496
 * @see <a href="https://leetcode-cn.com/problems/daily-temperatures/">Daily Temperatures</a>
 */
public class Solution739 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> indices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]) {
                res[indices.peek()] = i - indices.pop();
            }
            indices.push(i);
        }
        return res;
    }
}
