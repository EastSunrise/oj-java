package wsg.oj.java.leetcode.problems.p400;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution503;

/**
 * 496. Next Greater Element I (Easy)
 *
 * @author Kingen
 * @see Solution503
 * @see Solution556
 * @see Solution739
 * @see <a href="https://leetcode-cn.com/problems/next-greater-element-i/">Next Greater Element
 * I</a>
 * @since 2021-07-14
 */
public class Solution496 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_M_PLUS_N
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterElements = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() <= num) {
                nextGreaterElements.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = nums1.length - 1; i >= 0; i--) {
            res[i] = nextGreaterElements.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
