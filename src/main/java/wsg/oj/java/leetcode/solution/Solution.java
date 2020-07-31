package wsg.oj.java.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Solutions for problems
 *
 * @author Kingen
 */
public class Solution {

    public static void main(String[] args) {
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null && j != i) {
                return new int[]{i, j};
            }
        }
        return null;
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">2. 两数相加</a>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode last = result;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            last.next = new ListNode(sum);
            last = last.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            last.next = new ListNode(sum);
            last = last.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            last.next = new ListNode(sum);
            last = last.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            last.next = new ListNode(1);
        }
        return result.next;
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int start = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int last = map.getOrDefault(c, -1);
            if (last != -1) {
                if (last >= start) {
                    max = Math.max(max, i - start);
                    start = last + 1;
                }
            }
            map.put(c, i);
        }
        max = Math.max(max, len - start);
        return max;
    }

    /**
     * todo
     *
     * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">4. 寻找两个正序数组的中位数</a>
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 * len2 == 0) {
            int[] nums = len1 == 0 ? nums2 : nums1;
            int len = nums.length;
            if (len % 2 == 0) {
                return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
            } else {
                return nums[len / 2];
            }
        }

        int left1 = 0, left2 = 0;
        int right1 = len1, right2 = len2;
        return 0.0;
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">5. 最长回文子串</a>
     */
    public String longestPalindrome(String s) {
        return null;
    }
}
