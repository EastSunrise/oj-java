package wsg.oj.java.leetcode.problems.p600;

import java.util.List;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 636. Exclusive Time of Functions (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/exclusive-time-of-functions/">Exclusive Time of
 * Functions</a>
 * @since 2021-07-23
 */
class Solution636 implements Solution {

    /**
     * @complexity T=O(s), s=the size of logs
     * @complexity S=O(d+n), d=the depth of recursive calls of functions
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> ids = new Stack<>();
        int[] res = new int[n];
        int prevTimestamp = 0;
        for (String log : logs) {
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
            if (log.indexOf('s') > 0) {
                if (!ids.isEmpty()) {
                    res[ids.peek()] += timestamp - prevTimestamp;
                }
                ids.push(Integer.parseInt(log.substring(0, log.indexOf(':'))));
                prevTimestamp = timestamp;
            } else {
                res[ids.pop()] += timestamp + 1 - prevTimestamp;
                prevTimestamp = timestamp + 1;
            }
        }
        return res;
    }
}
