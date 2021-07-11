package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution101 implements Solution {

    /**
     * 136. Single Number (Easy)
     *
     * @see Solution101#singleNumber(int[])
     * @see Solution201#singleNumber(int[])
     * @see Solution201#missingNumber(int[])
     * @see Solution201#findDuplicate(int[])
     * @see Solution301#findTheDifference(String, String)
     * @see <a href="https://leetcode-cn.com/problems/single-number/">Single Number</a>
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }

    /**
     * 137. Single Number II (Medium)
     *
     * @see Solution101#singleNumber(int[])
     * @see Solution201#singleNumber(int[])
     * @see <a href="https://leetcode-cn.com/problems/single-number-ii/">Single Number II</a>
     */
    public int singleNumberII(int[] nums) {
        // x->(x,0)->(0,x)->(0,0)
        int a = 0, b = 0;
        for (int num : nums) {
            a = (num ^ a) & ~b;
            b = (num ^ b) & ~a;
        }
        return a;
    }

    /**
     * 139. Word Break (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see Solution101#wordBreakII(String, String[])
     * @see <a href="https://leetcode-cn.com/problems/word-break/">Word Break</a>
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // dp[i]: whether the substring s[0,i) can be broken to dict
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= len; i++) {
            // split s[0,i) into s[0,j)+s[j,i)
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    /**
     * 141. Linked List Cycle (Easy)
     *
     * @see Solution101#detectCycle(ListNode)
     * @see Solution201#isHappy(int)
     * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/">Linked List Cycle</a>
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 142. Linked List Cycle II (Medium)
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     * @see Solution101#hasCycle(ListNode)
     * @see Solution201#findDuplicate(int[])
     * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/">Linked List Cycle
     * II</a>
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 143. Reorder List (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/reorder-list/">Reorder List</a>
     */
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        // cut the list at the middle
        slow.next = null;
        // reverse the right half
        ListNode right = null, cur = mid, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = right;
            right = cur;
            cur = temp;
        }
        // merge the two lists
        ListNode left = head;
        while (right != null) {
            temp = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = temp;
        }
    }

    /**
     * 147. Insertion Sort List (Medium)
     *
     * @see Solution101#sortList(ListNode)
     * @see Solution701#insert(ListNode, int)
     * @see <a href="https://leetcode-cn.com/problems/insertion-sort-list/">Insertion Sort List</a>
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode prev = head, cur = prev.next;
        while (cur != null) {
            prev.next = null;
            ListNode node = res;
            while (node.next != null && node.next.val < cur.val) {
                node = node.next;
            }
            if (node == prev) {
                prev.next = cur;
                prev = cur;
            } else {
                prev.next = cur.next;
                cur.next = node.next;
                node.next = cur;
            }
            cur = prev.next;
        }
        return res.next;
    }

    /**
     * 148. Sort List (Medium)
     *
     * @see Solution1#mergeTwoLists(ListNode, ListNode)
     * @see Solution1#sortColors(int[])
     * @see Solution101#insertionSortList(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/sort-list/">Sort List</a>
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0, head);
        ListNode slow = res;
        for (ListNode fast = res; fast != null && fast.next != null; fast = fast.next.next) {
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        slow = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                slow.next = right;
                right = right.next;
            } else {
                slow.next = left;
                left = left.next;
            }
            slow = slow.next;
        }
        if (left != null) {
            slow.next = left;
        }
        if (right != null) {
            slow.next = right;
        }
        return res.next;
    }

    /**
     * 150. Evaluate Reverse Polish Notation (Medium)
     *
     * @see Solution201#calculate(String)
     * @see Solution201#addOperators(String, int)
     * @see <a href="https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/">Evaluate
     * Reverse Polish Notation</a>
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            char ch = token.charAt(token.length() - 1);
            if ('+' == ch) {
                stack.push(stack.pop() + stack.pop());
            } else if ('-' == ch) {
                stack.push(-stack.pop() + stack.pop());
            } else if ('*' == ch) {
                stack.push(stack.pop() * stack.pop());
            } else if ('/' == ch) {
                int divisor = stack.pop();
                int dividend = stack.pop();
                stack.push(dividend / divisor);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    /**
     * 151. Reverse Words in a String (Medium)
     *
     * @see Solution101#reverseWords(char[])
     * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string/">Reverse Words in a
     * String</a>
     */
    public String reverseWords(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (builder.length() > 0) {
                    res.add(builder.toString());
                    builder = new StringBuilder();
                }
            } else {
                builder.append(ch);
            }
        }
        if (builder.length() > 0) {
            res.add(builder.toString());
        }
        Collections.reverse(res);
        return String.join(" ", res);
    }

    /**
     * 152. Maximum Product Subarray (Medium)
     *
     * @see Solution1#maxSubArray(int[])
     * @see Solution101#rob(int[])
     * @see Solution201#productExceptSelf(int[])
     * @see Solution601#maximumProduct(int[])
     * @see Solution701#numSubarrayProductLessThanK(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/maximum-product-subarray/">Maximum Product
     * Subarray</a>
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    /**
     * 153. Find Minimum in Rotated Sorted Array (Medium)
     *
     * @see Solution1#search(int[], int)
     * @see Solution101#findMin(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">Find
     * Minimum in Rotated Sorted Array</a>
     */

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                return nums[left];
            }
        }
        return nums[left];
    }

    /**
     * 160. Intersection of Two Linked Lists (Easy)
     *
     * @see Solution501#findRestaurant(String[], String[])
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">Intersection
     * of Two Linked Lists</a>
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursorA = headA, cursorB = headB;
        while (cursorA != cursorB) {
            cursorA = cursorA == null ? headB : cursorA.next;
            cursorB = cursorB == null ? headA : cursorB.next;
        }
        return cursorA;
    }

    /**
     * 162. Find Peak Element (Medium)
     *
     * @see Solution801#peakIndexInMountainArray(int[])
     * @see Solution1901#findPeakGrid(int[][])
     * @see <a href="https://leetcode-cn.com/problems/find-peak-element/">Find Peak Element</a>
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     * 165. Compare Version Numbers (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/compare-version-numbers/">Compare Version
     * Numbers</a>
     */
    public int compareVersion(String version1, String version2) {
        int i1 = 0, i2 = 0, len1 = version1.length(), len2 = version2.length();
        while (i1 < len1 || i2 < len2) {
            int v1 = 0;
            if (i1 < len1) {
                int j1 = i1;
                while (j1 < len1 && version1.charAt(j1) != '.') {
                    j1++;
                }
                v1 = Integer.parseInt(version1, i1, j1, 10);
                i1 = j1 + 1;
            }
            int v2 = 0;
            if (i2 < len2) {
                int j2 = i2;
                while (j2 < len2 && version2.charAt(j2) != '.') {
                    j2++;
                }
                v2 = Integer.parseInt(version2, i2, j2, 10);
                i2 = j2 + 1;
            }
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 166. Fraction to Recurring Decimal (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/fraction-to-recurring-decimal/">Fraction to
     * Recurring Decimal</a>
     */
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if (numerator != 0 && (numerator < 0 ^ denominator < 0)) {
            // negative
            res.append("-");
        }
        // the integer part
        res.append(Math.abs(((long) numerator / denominator)));
        long remainder = numerator % denominator;
        if (remainder == 0) {
            return res.toString();
        }
        res.append(".");
        // appeared remainders
        List<Long> remainders = new ArrayList<>();
        // fraction part
        List<Integer> fractions = new ArrayList<>();
        do {
            int idx = remainders.lastIndexOf(remainder);
            if (idx >= 0) {
                // recurring decimal
                for (int i = 0; i < idx; i++) {
                    res.append(fractions.get(i));
                }
                res.append("(");
                for (int i = idx; i < remainders.size(); i++) {
                    res.append(fractions.get(i));
                }
                return res.append(")").toString();
            }
            remainders.add(remainder);
            remainder *= 10;
            fractions.add((int) Math.abs(remainder / denominator));
            remainder = remainder % denominator;
        } while (remainder != 0);
        for (int fraction : fractions) {
            res.append(fraction);
        }
        return res.toString();
    }

    /**
     * 167. Two Sum II - Input array is sorted (Easy)
     *
     * @see Solution1#twoSum(int[], int)
     * @see Solution601#findTarget(TreeNode, int)
     * @see Solution1001#twoSumLessThanK(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II
     * - Input array is sorted</a>
     */
    public int[] twoSumII(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    /**
     * 168. Excel Sheet Column Title (Easy)
     *
     * @see Solution101#titleToNumber(String)
     * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-title/">Excel Sheet Column
     * Title</a>
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0) {
            int mod = columnNumber % 26;
            if (mod == 0) {
                mod = 26;
            }
            str.insert(0, (char) (64 + mod));
            columnNumber = (columnNumber - mod) / 26;
        }
        return str.toString();
    }

    /**
     * 169. Majority Element (Easy)
     * <p>
     * Boyer–Moore majority vote algorithm: delete/nullify two different numbers from the array
     * every time, then the only left number is the majority one.
     *
     * @see Solution201#majorityElement(int[])
     * @see Solution1101#isMajorityElement(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/majority-element/">Majority Element</a>
     */
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else if (count == 0) {
                count++;
                major = nums[i];
            } else {
                count--;
            }
        }
        return major;
    }

    /**
     * 171. Excel Sheet Column Number (Easy)
     *
     * @see Solution101#convertToTitle(int)
     * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-number/">Excel Sheet Column
     * Number</a>
     */
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (char c : columnTitle.toCharArray()) {
            sum = (c - 64) + sum * 26;
        }
        return sum;
    }

    /**
     * 172. Factorial Trailing Zeroes (Easy)
     *
     * @see Solution201#countDigitOne(int)
     * @see Solution701#preimageSizeFZF(int)
     * @see <a href="https://leetcode-cn.com/problems/factorial-trailing-zeroes/">Factorial Trailing
     * Zeroes</a>
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    /**
     * 179. Largest Number (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-number/">Largest Number</a>
     */
    public String largestNumber(int[] nums) {
        boolean positive = false;
        for (int num : nums) {
            if (num > 0) {
                positive = true;
                break;
            }
        }
        if (!positive) {
            // all zeros
            return "0";
        }
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            }
            return (o2 + o1).compareTo(o1 + o2);
        });
        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            res.append(s);
        }
        return res.toString();
    }

    /**
     * 187. Repeated DNA Sequences (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/repeated-dna-sequences/">Repeated DNA
     * Sequences</a>
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len <= 10) {
            return new ArrayList<>();
        }
        int value = 0;
        // the value of the first 9 digits
        for (int i = 0; i < 9; i++) {
            value = (value << 2) + charToQuaternary(s.charAt(i));
        }
        // key: the quaternary value of the 10-letter-long sequence
        // value: count of same values
        byte[] counts = new byte[1 << 20];
        List<String> res = new ArrayList<>();
        // (1<<(c*2-1))-1
        int base = 0x3ffff;
        // start: the start index of the 10-letter-long sequence
        for (int start = 0, sLen = len - 10; start <= sLen; start++) {
            value = (value << 2) + charToQuaternary(s.charAt(start + 9));
            counts[value]++;
            if (counts[value] == 2) {
                // more than one
                res.add(s.substring(start, start + 10));
            }
            // remove the first digit
            value = value & base;
        }
        return res;
    }

    private int charToQuaternary(char ch) {
        switch (ch) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            default:
                return 3;
        }
    }

    /**
     * 189. Rotate Array (Medium)
     *
     * @see Solution1#rotateRight(ListNode, int)
     * @see Solution101#reverseWords(char[])
     * @see <a href="https://leetcode-cn.com/problems/rotate-array/">Rotate Array</a>
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 190. Reverse Bits (Easy)
     * <p>
     * todo study bits
     *
     * @see Integer#reverse(int)
     * @see Solution1#reverse(int)
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-bits/">Reverse Bits</a>
     */
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    /**
     * 191. Number of 1 Bits (Easy)
     *
     * @see Solution101#reverseBits(int)
     * @see Solution201#isPowerOfTwo(int)
     * @see Solution301#countBits(int)
     * @see Solution401#readBinaryWatch(int)
     * @see Solution401#hammingDistance(int, int)
     * @see Solution601#hasAlternatingBits(int)
     * @see Solution701#countPrimeSetBits(int, int)
     * @see <a href="https://leetcode-cn.com/problems/number-of-1-bits/">Number of 1 Bits</a>
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 199. Binary Tree Right Side View (Medium)
     *
     * @see #LEVEL_ORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_LOG_N
     * @see Solution116#connect(Solution116.Node)
     * @see Solution501#boundaryOfBinaryTree(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">Binary Tree
     * Right Side View</a>
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return res;
    }

    /**
     * 200. Number of Islands (Medium)
     *
     * @see #DFS
     * @see Solution101#solve(char[][])
     * @see Solution201#wallsAndGates(int[][])
     * @see Solution301#numIslands2(int, int, int[][])
     * @see Solution301#countComponents(int, int[][])
     * @see Solution601#numDistinctIslands(int[][])
     * @see Solution601#maxAreaOfIsland(int[][])
     * @see Solution1901#countSubIslands(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/number-of-islands/">Number of Islands</a>
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    sinkIsland(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void sinkIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
            // out of index
            return;
        }
        if (grid[i][j] == '0') {
            // water or sank
            return;
        }
        grid[i][j] = '0';
        sinkIsland(grid, i - 1, j);
        sinkIsland(grid, i + 1, j);
        sinkIsland(grid, i, j - 1);
        sinkIsland(grid, i, j + 1);
    }
}