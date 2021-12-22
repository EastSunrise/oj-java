package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p500.Solution503;
import cn.wsg.oj.leetcode.problems.p500.Solution556;
import cn.wsg.oj.leetcode.problems.p700.Solution739;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 496. Next Greater Element I (Easy)
 *
 * @author Kingen
 * @see Solution503
 * @see Solution556
 * @see Solution739
 * @see <a href="https://leetcode-cn.com/problems/next-greater-element-i/">Next Greater Element
 * I</a>
 */
public class Solution496 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_M_PLUS_N
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Map<Integer, Integer> nextGreaterElements = new HashMap<>(n);
        Deque<Integer> stack = new LinkedList<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() <= num) {
                nextGreaterElements.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = nextGreaterElements.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
