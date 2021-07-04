package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.impl.MinStack;

/**
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution201 extends Solution {

    /**
     * 201. Bitwise AND of Numbers Range (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/">Bitwise AND of
     * Numbers Range</a>
     */
    public int rangeBitwiseAnd(int left, int right) {
        // the count of bits after consecutive same bits from the first bit
        int bits = 0;
        while (left > 0 && left != right) {
            left >>>= 1;
            right >>>= 1;
            bits++;
        }
        return left == right ? left << bits : 0;
    }

    /**
     * 202. Happy Number (Easy)
     *
     * @see Solution101#hasCycle(ListNode)
     * @see Solution201#addDigits(int)
     * @see Solution201#isUgly(int)
     * @see <a href="https://leetcode-cn.com/problems/happy-number/">Happy Number</a>
     */
    public boolean isHappy(int n) {
        Set<Integer> unhappy = Set.of(2, 4, 16, 37, 58, 89, 145, 42, 20);
        while (n != 1) {
            if (unhappy.contains(n)) {
                return false;
            }
            int sum = 0;
            while (n > 0) {
                int mod = n % 10;
                sum += mod * mod;
                n /= 10;
            }
            n = sum;
        }
        return true;
    }

    /**
     * 203. Remove Linked List Elements (Easy)
     *
     * @see Solution1#removeElement(int[], int)
     * @see Solution201#deleteNode(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/remove-linked-list-elements/">Remove Linked
     * List Elements</a>
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode cursor = ret;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return ret.next;
    }

    /**
     * 204. Count Primes (Easy)
     *
     * @see Solution201#isUgly(int)
     * @see Solution201#nthUglyNumber(int)
     * @see Solution201#numSquares(int)
     * @see <a href="https://en.wikibooks.org/wiki/Discrete_Mathematics/Sieve_of_Eratosthenes">Sieve
     * of Eratosthenes</a>
     * @see <a href="https://leetcode-cn.com/problems/count-primes/">Count Primes</a>
     */
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                for (long j = (long) i * i; j < n; j += i) {
                    notPrimes[(int) j] = true;
                }
            }
        }
        return count;
    }

    /**
     * 205. Isomorphic Strings (Easy)
     *
     * @see Solution201#wordPattern(String, String)
     * @see <a href="https://leetcode-cn.com/problems/isomorphic-strings/">Isomorphic Strings</a>
     */
    public boolean isIsomorphic(String s, String t) {
        int[] s2t = new int[128];
        int[] t2s = new int[128];
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        for (int i = 0, length = schars.length; i < length; i++) {
            char sc = schars[i];
            char tc = tchars[i];
            int tShould = s2t[sc];
            int sShould = t2s[tc];
            if (tShould + sShould == 0) {
                s2t[sc] = tc;
                t2s[tc] = sc;
            } else if (tShould * sShould == 0) {
                return false;
            } else if (tShould != tc || sShould != sc) {
                return false;
            }
        }
        return true;
    }

    /**
     * 206. Reverse Linked List (Easy)
     *
     * @see Solution1#reverseBetween(ListNode, int, int)
     * @see Solution101#upsideDownBinaryTree(TreeNode)
     * @see Solution201#isPalindrome(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">Reverse Linked List</a>
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 207. Course Schedule (Medium)
     *
     * @complexity O(| E |)
     * @see #DFS
     * @see Solution201#findOrder(int, int[][])
     * @see Solution201#validTree(int, int[][])
     * @see Solution301#findMinHeightTrees(int, int[][])
     * @see Solution601#scheduleCourse(int[][])
     * @see <a href="https://leetcode-cn.com/problems/course-schedule/">Course Schedule</a>
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = Arrays.stream(prerequisites)
            .collect(Collectors.groupingBy(a -> a[0], Collectors.mapping(a -> a[1],
                Collectors.toList())));
        Set<Integer> finished = new HashSet<>(numCourses);
        for (int end : edges.keySet()) {
            if (!canFinish(edges, finished, new HashSet<>(), end)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 209. Minimum Size Subarray Sum (Medium)
     *
     * @see Solution1#minWindow(String, String)
     * @see Solution301#maxSubArrayLen(int[], int)
     * @see Solution701#findLength(int[], int[])
     * @see Solution1601#minOperations(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/minimum-size-subarray-sum/">Minimum Size
     * Subarray Sum</a>
     */
    public int minSubArrayLen(int target, int[] nums) {
        for (int num : nums) {
            if (num >= target) {
                return 1;
            }
        }
        // i: the left (inclusive) of the window
        // j: the right (exclusive) of the window
        int i = 0, j = 0, len = nums.length;
        int sum = 0, res = Integer.MAX_VALUE;
        while (j < len) {
            // move the the right side
            sum += nums[j++];
            if (sum >= target) {
                // find one subarray
                res = Math.min(res, j - i);
                do {
                    // move the left side
                    sum -= nums[i++];
                } while (sum >= target);
                res = Math.min(res, j - i + 1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 210. Course Schedule II (Medium)
     *
     * @see Solution201#canFinish(int, int[][])
     * @see Solution201#alienOrder(String[])
     * @see Solution301#findMinHeightTrees(int, int[][])
     * @see Solution401#sequenceReconstruction(int[], int[][])
     * @see Solution601#scheduleCourse(int[][])
     * @see Solution1101#minimumSemesters(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/course-schedule-ii/">Course Schedule II</a>
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = Arrays.stream(prerequisites)
            .collect(Collectors.groupingBy(a -> a[0], Collectors.mapping(a -> a[1],
                Collectors.toList())));
        Set<Integer> finished = new LinkedHashSet<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(edges, finished, new HashSet<>(), i)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        for (int course : finished) {
            res[i++] = course;
        }
        return res;
    }

    /**
     * Finishes the target.
     *
     * @param edges     all edges in the graph
     * @param finished  courses that have been finished
     * @param finishing the courses being finished
     * @param target    the course to be finished
     */
    private boolean canFinish(Map<Integer, List<Integer>> edges, Set<Integer> finished,
        Set<Integer> finishing, int target) {
        if (finishing.contains(target)) {
            return false;
        }
        List<Integer> starts = edges.get(target);
        if (starts != null) {
            finishing.add(target);
            for (int start : starts) {
                if (!finished.contains(start) && !canFinish(edges, finished, finishing, start)) {
                    return false;
                }
            }
            finishing.remove(target);
        }
        finished.add(target);
        return true;
    }

    /**
     * 212. Word Search II (Hard)
     *
     * @see Solution1#exist(char[][], String)
     * @see Solution901#uniquePathsIII(int[][])
     * @see <a href="https://leetcode-cn.com/problems/word-search-ii/">Word Search II</a>
     */
    public String[] findWords(char[][] board, String[] words) {
        // todo
        return new String[0];
    }

    /**
     * 214. Shortest Palindrome (Hard)
     *
     * @see Solution1#longestPalindrome(String)
     * @see Solution1#strStr(String, String)
     * @see Solution301#palindromePairs(String[])
     * @see <a href="https://leetcode-cn.com/problems/shortest-palindrome/">Shortest Palindrome</a>
     */
    public String shortestPalindrome(String s) {
        // todo
        return "";
    }

    /**
     * 216. Combination Sum III (Medium)
     *
     * @see #BACKTRACKING
     * @see Solution1#combinationSum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/combination-sum-iii/">Combination Sum III</a>
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k * (k + 1) / 2 || n > (19 - k) * k / 2) {
            return res;
        }
        combinationSum3(res, new ArrayList<>(k), k, n, 1);
        return res;
    }

    void combinationSum3(List<List<Integer>> res, List<Integer> temp, int k, int n, int start) {
        if (k == 0 || n <= 0) {
            if (k == 0 && n == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        k--;
        for (int i = start; i < 10; i++) {
            temp.add(i);
            combinationSum3(res, temp, k, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 217. Contains Duplicate (Easy)
     *
     * @see Solution201#containsNearbyDuplicate(int[], int)
     * @see Solution201#containsNearbyAlmostDuplicate(int[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/contains-duplicate/">Contains Duplicate</a>
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (!unique.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 218. The Skyline Problem (Hard)
     *
     * @see Solution601#fallingSquares(int[][])
     * @see <a href="https://leetcode-cn.com/problems/the-skyline-problem/">The Skyline Problem</a>
     */
    public int[][] getSkyline(int[][] buildings) {
        // todo
        return new int[0][0];
    }

    /**
     * 219. Contains Duplicate II (Easy)
     *
     * @see Solution201#containsDuplicate(int[])
     * @see Solution201#containsNearbyAlmostDuplicate(int[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/contains-duplicate-ii/">Contains Duplicate
     * II</a>
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> num2LastIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer oldValue = num2LastIndexMap.put(nums[i], i);
            if (oldValue != null && i - oldValue <= k) {
                return true;
            }
        }
        return false;
    }

    /**
     * 220. Contains Duplicate III (Medium)
     *
     * @see Solution201#containsDuplicate(int[])
     * @see Solution201#containsNearbyDuplicate(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/contains-duplicate-iii/">Contains Duplicate
     * III</a>
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> window = new TreeSet<>();
        // slide the window
        // j: the right (inclusive) index of the window
        for (int j = 0; j < len; j++) {
            Long ceiling = window.ceiling(((long) nums[j] - t));
            if (ceiling != null && ceiling - nums[j] <= t) {
                return true;
            }
            window.add((long) nums[j]);
            if (window.size() == k + 1) {
                window.remove((long) nums[j - k]);
            }
        }
        return false;
    }

    /**
     * 221. Maximal Square (Medium)
     *
     * @see Solution1#maximalRectangle(char[][])
     * @see Solution701#orderOfLargestPlusSign(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/maximal-square/">Maximal Square</a>
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }

    /**
     * 222. Count Complete Tree Nodes (Medium)
     *
     * @see Solution201#closestValue(TreeNode, double)
     * @see <a href="https://leetcode-cn.com/problems/count-complete-tree-nodes/">Count Complete
     * Tree Nodes</a>
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        if (left == null) {
            return 1;
        }
        int level = 1;
        while (left != null) {
            left = left.left;
            level++;
        }
        // count of nodes except the last level
        int count = (1 << (level - 1)) - 1;
        TreeNode cur = root;
        while (level > 2) {
            TreeNode mid = cur.left;
            for (int i = 3; i < level; i++) {
                mid = mid.right;
            }
            if (mid.left == null) {
                cur = cur.left;
            } else if (mid.right != null) {
                // the left subtree is complete
                cur = cur.right;
                // plus the last level of the left subtree
                count += 1 << (level - 2);
            } else {
                // find the rightmost node of the last level
                return count + (1 << (level - 2)) - 1;
            }
            level--;
        }

        if (cur.right != null) {
            count += 2;
        } else if (cur.left != null) {
            count++;
        }
        return count;
    }

    /**
     * 223. Rectangle Area (Medium)
     *
     * @see Solution801#isRectangleOverlap(int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/rectangle-area/">Rectangle Area</a>
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = 0;
        // the area of the two rectangles
        area += (ax2 - ax1) * (ay2 - ay1);
        area += (bx2 - bx1) * (by2 - by1);
        // not overlapped
        if (ax1 > bx2 || bx1 > ax2 || ay1 > by2 || by1 > ay2) {
            return area;
        }
        int cx1 = Math.max(ax1, bx1);
        int cy1 = Math.max(ay1, by1);
        int cx2 = Math.min(ax2, bx2);
        int cy2 = Math.min(ay2, by2);
        return area - (cx2 - cx1) * (cy2 - cy1);
    }

    /**
     * 224. Basic Calculator (Hard)
     *
     * @see Solution101#evalRPN(String[])
     * @see Solution201#calculate(String)
     * @see Solution201#diffWaysToCompute(String)
     * @see Solution201#addOperators(String, int)
     * @see Solution701#calculate(String)
     * @see <a href="https://leetcode-cn.com/problems/basic-calculator/">Basic Calculator</a>
     */
    public int calculate(String s) {
        // todo
        return 0;
    }

    /**
     * 226. Invert Binary Tree (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/invert-binary-tree/">Invert Binary Tree</a>
     */
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }

    /**
     * 227. Basic Calculator II (Medium)
     *
     * @see Solution201#calculate(String)
     * @see Solution201#addOperators(String, int)
     * @see Solution701#calculate(String)
     * @see <a href="https://leetcode-cn.com/problems/basic-calculator-ii/">Basic Calculator II</a>
     */
    public int calculateII(String s) {
        Map<Character, Integer> priorities = Map.of('+', 2, '-', 2, '*', 4, '/', 4);
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                if (ch < '0' || ch > '9') {
                    int p = priorities.get(ch);
                    int operand2 = Integer.parseInt(builder.toString());
                    while (!operators.isEmpty() && p < priorities.get(operators.peek()) + 1) {
                        // calculate the previous operator with higher priority
                        operand2 = calculate(operators.pop(), operands.pop(), operand2);
                    }
                    operators.push(ch);
                    operands.push(operand2);
                    builder = new StringBuilder();
                } else {
                    builder.append(ch);
                }
            }
        }
        // calculate left operators
        int operand2 = Integer.parseInt(builder.toString());
        while (!operators.isEmpty()) {
            operand2 = calculate(operators.pop(), operands.pop(), operand2);
        }
        return operand2;
    }

    private int calculate(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '*':
                return operand1 * operand2;
            case '-':
                return operand1 - operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    /**
     * 228. Summary Ranges (Easy)
     *
     * @see Solution101#findMissingRanges(int[], int, int)
     * @see SummaryRanges
     * @see <a href="https://leetcode-cn.com/problems/summary-ranges/">Summary Ranges</a>
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>(nums.length);
        int length = nums.length;
        int left = 0;
        while (left < length) {
            int right = left + 1;
            while (right < length && nums[right] == nums[right - 1] + 1) {
                right++;
            }
            StringBuilder builder = new StringBuilder().append(nums[left]);
            if (right > left + 1) {
                builder.append("->").append(nums[right - 1]);
            }
            res.add(builder.toString());
            left = right;
        }
        return res;
    }

    /**
     * 229. Majority Element II (Medium)
     * <p>
     * If a is a majority that appears more than [n/3] times, it's still a majority after removing
     * three different elements from the array.
     *
     * @see Solution101#majorityElement(int[])
     * @see Solution1101#isMajorityElement(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/majority-element-ii/">Majority Element II</a>
     */
    public List<Integer> majorityElement(int[] nums) {
        return majorityElements(nums, 3);
    }

    /**
     * Finds elements that appear more than [n/m] times.
     */
    private List<Integer> majorityElements(int[] nums, int m) {
        m--;
        int[] majorities = new int[m];
        Arrays.fill(majorities, Integer.MAX_VALUE);
        int[] counts = new int[m];
        for (int num : nums) {
            int i = 0;
            while (i < m) {
                if (num == majorities[i]) {
                    counts[i]++;
                    break;
                }
                i++;
            }
            if (i == m) {
                // not in majorities
                int j = 0;
                while (j < m) {
                    if (counts[j] == 0) {
                        // replace
                        majorities[j] = num;
                        counts[j]++;
                        break;
                    }
                    j++;
                }
                if (j == m) {
                    // all majorities are placed
                    for (int k = 0; k < m; k++) {
                        counts[k]--;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int target = nums.length / (m + 1);
        for (int i = 0; i < m; i++) {
            if (counts[i] > 0) {
                counts[i] = 0;
                for (int num : nums) {
                    if (num == majorities[i]) {
                        counts[i]++;
                    }
                }
                if (counts[i] > target) {
                    res.add(majorities[i]);
                }
            }
        }
        return res;
    }

    /**
     * 230. Kth Smallest Element in a BST (Medium)
     *
     * @see #INORDER
     * @see Solution1#inorderTraversal(TreeNode)
     * @see Solution601#findSecondMinimumValue(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest
     * Element in a BST</a>
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode left = root;
        do {
            stack.push(left);
            left = left.left;
        } while (left != null);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            left = node.right;
            while (left != null) {
                stack.push(left);
                left = left.left;
            }
        }
        throw new IllegalArgumentException("out of range");
    }

    /**
     * 231. Power of Two (Easy)
     *
     * @see Solution101#hammingWeight(int)
     * @see Solution301#isPowerOfThree(int)
     * @see Solution301#isPowerOfFour(int)
     * @see <a href="https://leetcode-cn.com/problems/power-of-two/">Power of Two</a>
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n >>= 1;
        }
        return n == 1;
    }

    /**
     * 231.2 Power of Two (Easy) (Bit)
     */
    public boolean isPowerOfTwo2(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    /**
     * 233. Number of Digit One (Hard)
     *
     * @see Solution101#trailingZeroes(int)
     * @see Solution1001#digitsCount(int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/number-of-digit-one/">Number of Digit One</a>
     */
    public int countDigitOne(int n) {
        // todo
        return 0;
    }

    /**
     * 234. Palindrome Linked List (Easy)
     *
     * @see Solution1#isPalindrome(int)
     * @see Solution101#isPalindrome(String)
     * @see Solution201#reverseList(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">Palindrome Linked
     * List</a>
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }
        ListNode tail = reverseList(slow);
        while (tail != null && head != null) {
            if (tail.val != head.val) {
                return false;
            } else {
                tail = tail.next;
                head = head.next;
            }
        }
        return true;
    }

    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree (Easy)
     *
     * @see Solution201#lowestCommonAncestorII(TreeNode, TreeNode, TreeNode)
     * @see Solution1201#findSmallestRegion(String[][], String, String)
     * @see Solution1601#lowestCommonAncestor(TreeNode, int, int)
     * @see Solution1601#lowestCommonAncestor(int[], int, int)
     * @see Solution1601#lowestCommonAncestor(TreeNode, int[])
     * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Lowest
     * Common Ancestor of a Binary Search Tree</a>
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < min) {
                cur = cur.right;
            } else if (cur.val > max) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    /**
     * 236. Lowest Common Ancestor of a Binary Tree (Medium)
     * <p>
     * todo Tarjan Algorithm
     *
     * @see Solution201#lowestCommonAncestor(TreeNode, TreeNode, TreeNode)
     * @see Solution1201#findSmallestRegion(String[][], String, String)
     * @see Solution1601#lowestCommonAncestor(TreeNode, int, int)
     * @see Solution1601#lowestCommonAncestor(int[], int, int)
     * @see Solution1601#lowestCommonAncestor(TreeNode, int[])
     * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest
     * Common Ancestor of a Binary Tree</a>
     */
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pas = new ArrayList<>(), qas = new ArrayList<>();
        getAncestor(root, p, pas);
        getAncestor(root, q, qas);
        int i = pas.size() - 1, j = qas.size() - 1;
        while (i >= 0 && j >= 0 && pas.get(i) == qas.get(j)) {
            i--;
            j--;
        }
        return pas.get(i + 1);
    }

    private boolean getAncestor(TreeNode node, TreeNode target, List<TreeNode> ancestors) {
        if (node == target) {
            ancestors.add(node);
            return true;
        }
        if (node.left != null && getAncestor(node.left, target, ancestors)) {
            ancestors.add(node);
            return true;
        }
        if (node.right != null && getAncestor(node.right, target, ancestors)) {
            ancestors.add(node);
            return true;
        }
        return false;
    }

    /**
     * 237. Delete Node in a Linked List (Easy)
     *
     * @see Solution201#removeElements(ListNode, int)
     * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">Delete Node in
     * a Linked List</a>
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 238. Product of Array Except Self (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see Solution1#trap(int[])
     * @see Solution101#maxProduct(int[])
     * @see Solution201#minCostII(int[][])
     * @see <a href="https://leetcode-cn.com/problems/product-of-array-except-self/">Product of
     * Array Except Self</a>
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // calculate the product of nums[0,i-1]
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // calculate the product of nums[i+1,len)
        int product = 1;
        for (int i = len - 2; i >= 0; i--) {
            product *= nums[i + 1];
            res[i] *= product;
        }
        return res;
    }

    /**
     * 239. Sliding Window Maximum (Hard)
     *
     * @see Solution1#minWindow(String, String)
     * @see MinStack
     * @see Solution101#lengthOfLongestSubstringTwoDistinct(String)
     * @see Solution201#minCostII(int[][])
     * @see Solution1601#maxResult(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/sliding-window-maximum/">Sliding Window
     * Maximum</a>
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // todo
        return new int[0];
    }

    /**
     * 240. Search a 2D Matrix II (Medium)
     *
     * @see Arrays#binarySearch
     * @see #TIME_M_PLUS_N
     * @see Solution1#searchMatrix(int[][], int)
     * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix
     * II</a>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int bottom = m - 1, left = 0;
        while (bottom >= 0 && left < n) {
            int bl = matrix[bottom][left];
            if (bl < target) {
                // next columns
                left++;
            } else if (bl > target) {
                // previous rows
                bottom--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 241. Different Ways to Add Parentheses (Medium)
     *
     * @see Solution1#generateTrees(int)
     * @see Solution201#calculate(String)
     * @see Solution201#addOperators(String, int)
     * @see <a href="https://leetcode-cn.com/problems/different-ways-to-add-parentheses/">Different
     * Ways to Add Parentheses</a>
     */
    public int[] diffWaysToCompute(String expression) {
        // todo
        return new int[0];
    }

    /**
     * 242. Valid Anagram (Easy)
     *
     * @see Solution49#groupAnagrams(String[])
     * @see Solution201#canPermutePalindrome(String)
     * @see Solution401#findAnagrams(String, String)
     * @see <a href="https://leetcode-cn.com/problems/valid-anagram/">Valid Anagram</a>
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            int i = ch - 'a';
            if (count[i] == 0) {
                return false;
            }
            count[i]--;
        }
        return true;
    }

    /**
     * 243. Shortest Word Distance (Easy)
     *
     * @see WordDistance
     * @see Solution201#shortestWordDistance(String[], String, String)
     * @see <a href="https://leetcode-cn.com/problems/shortest-word-distance/">Shortest Word
     * Distance</a>
     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        // todo
        return 0;
    }

    /**
     * 245. Shortest Word Distance III (Medium)
     *
     * @see Solution201#shortestDistance(String[], String, String)
     * @see WordDistance
     * @see <a href="https://leetcode-cn.com/problems/shortest-word-distance-iii/">Shortest Word
     * Distance III</a>
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        // todo
        return 0;
    }

    /**
     * 246. Strobogrammatic Number (Easy)
     *
     * @see Solution201#findStrobogrammatic(int)
     * @see Solution201#strobogrammaticInRange(String, String)
     * @see Solution1001#confusingNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/strobogrammatic-number/">Strobogrammatic
     * Number</a>
     */
    public boolean isStrobogrammatic(String num) {
        // todo
        return false;
    }

    /**
     * 247. Strobogrammatic Number II (Medium)
     *
     * @see Solution201#isStrobogrammatic(String)
     * @see Solution201#strobogrammaticInRange(String, String)
     * @see <a href="https://leetcode-cn.com/problems/strobogrammatic-number-ii/">Strobogrammatic
     * Number II</a>
     */
    public String[] findStrobogrammatic(int n) {
        // todo
        return new String[0];
    }

    /**
     * 248. Strobogrammatic Number III (Hard)
     *
     * @see Solution201#isStrobogrammatic(String)
     * @see Solution201#findStrobogrammatic(int)
     * @see <a href="https://leetcode-cn.com/problems/strobogrammatic-number-iii/">Strobogrammatic
     * Number III</a>
     */
    public int strobogrammaticInRange(String low, String high) {
        // todo
        return 0;
    }

    /**
     * 249. Group Shifted Strings (Medium)
     *
     * @see Solution49#groupAnagrams(String[])
     * @see <a href="https://leetcode-cn.com/problems/group-shifted-strings/">Group Shifted
     * Strings</a>
     */
    public String[][] groupStrings(String[] strings) {
        // todo
        return new String[0][0];
    }

    /**
     * 250. Count Univalue Subtrees (Medium)
     *
     * @see Solution501#isSubtree(TreeNode, TreeNode)
     * @see Solution601#longestUnivaluePath(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/count-univalue-subtrees/">Count Univalue
     * Subtrees</a>
     */
    public int countUnivalSubtrees(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 252. Meeting Rooms (Easy)
     *
     * @see Solution1#merge(int[][])
     * @see Solution201#minMeetingRooms(int[][])
     * @see <a href="https://leetcode-cn.com/problems/meeting-rooms/">Meeting Rooms</a>
     */
    public boolean canAttendMeetings(int[][] intervals) {
        // todo
        return false;
    }

    /**
     * 253. Meeting Rooms II (Medium)
     *
     * @see Solution1#merge(int[][])
     * @see Solution201#canAttendMeetings(int[][])
     * @see Solution401#findMinArrowShots(int[][])
     * @see Solution1001#carPooling(int[][], int)
     * @see <a href="https://leetcode-cn.com/problems/meeting-rooms-ii/">Meeting Rooms II</a>
     */
    public int minMeetingRooms(int[][] intervals) {
        // todo
        return 0;
    }

    /**
     * 254. Factor Combinations (Medium)
     *
     * @see Solution1#combinationSum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/factor-combinations/">Factor Combinations</a>
     */
    public int[][] getFactors(int n) {
        // todo
        return new int[0][0];
    }

    /**
     * 255. Verify Preorder Sequence in Binary Search Tree (Medium)
     *
     * @see Solution101#preorderTraversal(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/">Verify
     * Preorder Sequence in Binary Search Tree</a>
     */
    public boolean verifyPreorder(int[] preorder) {
        // todo
        return false;
    }

    /**
     * 256. Paint House (Medium)
     *
     * @see Solution101#rob(int[])
     * @see Solution201#rob(int[])
     * @see Solution201#minCostII(int[][])
     * @see Solution201#numWays(int, int)
     * @see <a href="https://leetcode-cn.com/problems/paint-house/">Paint House</a>
     */
    public int minCost(int[][] costs) {
        // todo
        return 0;
    }

    /**
     * 257. Binary Tree Paths (Easy)
     *
     * @see Solution101#pathSum(TreeNode, int)
     * @see Solution901#smallestFromLeaf(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-paths/">Binary Tree Paths</a>
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        List<String> res = new ArrayList<>(left.size() + right.size());
        for (String path : left) {
            StringBuilder sb = new StringBuilder().append(root.val).append("->").append(path);
            res.add(sb.toString());
        }
        for (String path : right) {
            StringBuilder sb = new StringBuilder().append(root.val).append("->").append(path);
            res.add(sb.toString());
        }
        if (res.isEmpty()) {
            res.add(String.valueOf(root.val));
        }
        return res;
    }

    /**
     * 258. Add Digits (Easy)
     * <p>
     * Assumes that <i>num = 100a + 10b + c</i>, then <i>digitsSum = a + b + c</i>. The difference
     * is <i>99a + 9b</i> which is a multiple of 9, So the final result is the original number mod 9
     * or 9 if the original number is a multiple of 9.
     *
     * @see Solution201#isHappy(int)
     * @see Solution1001#sumOfDigits(int[])
     * @see <a href="https://leetcode-cn.com/problems/add-digits/">Add Digits</a>
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 259. 3Sum Smaller (Medium)
     *
     * @see Solution1#threeSum(int[])
     * @see Solution1#threeSumClosest(int[], int)
     * @see Solution601#triangleNumber(int[])
     * @see Solution1001#twoSumLessThanK(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/3sum-smaller/">3Sum Smaller</a>
     */
    public int threeSumSmaller(int[] nums, int target) {
        // todo
        return 0;
    }

    /**
     * 260. Single Number III (Medium)
     *
     * @see Solution101#singleNumber(int[])
     * @see Solution101#singleNumberII(int[])
     * @see <a href="https://leetcode-cn.com/problems/single-number-iii/">Single Number III</a>
     */
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        // find the first occurrence of digit 1 from right to left
        // it also means that the kth digits of the two targets are 1 and 0 respectively
        // assume that it the kth digit, then base=1<<(k-1)
        int base = 1;
        while ((sum & 1) == 0) {
            sum >>= 1;
            base <<= 1;
        }
        // divide the nums into two parts
        // one contains numbers whose kth digit is 0
        // the other contains numbers whose kth digit is 1
        // the two targets will be divided into different parts
        int sum1 = 0, sum2 = 0;
        for (int num : nums) {
            if ((num & base) == 0) {
                sum1 ^= num;
            } else {
                sum2 ^= num;
            }
        }
        return new int[]{sum1, sum2};
    }

    /**
     * 261. Graph Valid Tree (Medium)
     *
     * @see Solution201#canFinish(int, int[][])
     * @see Solution301#countComponents(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/graph-valid-tree/">Graph Valid Tree</a>
     */
    public boolean validTree(int n, int[][] edges) {
        // todo
        return false;
    }

    /**
     * 263. Ugly Number (Easy)
     *
     * @see Solution201#isHappy(int)
     * @see Solution201#countPrimes(int)
     * @see Solution201#nthUglyNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/ugly-number/">Ugly Number</a>
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    /**
     * 264. Ugly Number II (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see Solution1#mergeKLists(ListNode[])
     * @see Solution201#countPrimes(int)
     * @see Solution201#isUgly(int)
     * @see Solution201#numSquares(int)
     * @see Solution301#nthSuperUglyNumber(int, int[])
     * @see Solution1201#nthUglyNumber(int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/ugly-number-ii/">Ugly Number II</a>
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num2 = 2 * dp[i2];
            int num3 = 3 * dp[i3];
            int num5 = 5 * dp[i5];
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                i2++;
            }
            if (dp[i] == num3) {
                i3++;
            }
            if (dp[i] == num5) {
                i5++;
            }
        }
        return dp[n - 1];
    }

    /**
     * 265. Paint House II (Hard)
     *
     * @see Solution201#productExceptSelf(int[])
     * @see Solution201#maxSlidingWindow(int[], int)
     * @see Solution201#minCost(int[][])
     * @see Solution201#numWays(int, int)
     * @see <a href="https://leetcode-cn.com/problems/paint-house-ii/">Paint House II</a>
     */
    public int minCostII(int[][] costs) {
        // todo
        return 0;
    }

    /**
     * 266. Palindrome Permutation (Easy)
     *
     * @see Solution1#longestPalindrome(String)
     * @see Solution201#isAnagram(String, String)
     * @see Solution201#generatePalindromes(String)
     * @see Solution401#longestPalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/palindrome-permutation/">Palindrome
     * Permutation</a>
     */
    public boolean canPermutePalindrome(String s) {
        // todo
        return false;
    }

    /**
     * 267. Palindrome Permutation II (Medium)
     *
     * @see Solution1#nextPermutation(int[])
     * @see Solution1#permuteUnique(int[])
     * @see Solution201#canPermutePalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/palindrome-permutation-ii/">Palindrome
     * Permutation II</a>
     */
    public String[] generatePalindromes(String s) {
        // todo
        return new String[0];
    }

    /**
     * 268. Missing Number (Easy)
     *
     * @see Solution1#firstMissingPositive(int[])
     * @see Solution101#singleNumber(int[])
     * @see Solution201#findDuplicate(int[])
     * @see Solution701#minSwapsCouples(int[])
     * @see <a href="https://leetcode-cn.com/problems/missing-number/">Missing Number</a>
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    /**
     * 269. Alien Dictionary (Hard)
     *
     * @see Solution201#findOrder(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/alien-dictionary/">Alien Dictionary</a>
     */
    public String alienOrder(String[] words) {
        // todo
        return "";
    }

    /**
     * 270. Closest Binary Search Tree Value (Easy)
     *
     * @see Solution201#countNodes(TreeNode)
     * @see Solution201#closestKValues(TreeNode, double, int)
     * @see Solution601#searchBST(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/closest-binary-search-tree-value/">Closest
     * Binary Search Tree Value</a>
     */
    public int closestValue(TreeNode root, double target) {
        // todo
        return 0;
    }

    /**
     * 271. Encode and Decode Strings (Medium)
     *
     * @see Solution1#countAndSay(int)
     * @see Solution201#Codec(TreeNode)
     * @see Solution401#compress(char[])
     * @see Solution601#countBinarySubstrings(String)
     * @see <a href="https://leetcode-cn.com/problems/encode-and-decode-strings/">Encode and Decode
     * Strings</a>
     */
    public String[] encode(String[] dummy_input) {
        // todo
        return new String[0];
    }

    /**
     * 272. Closest Binary Search Tree Value II (Hard)
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see Solution201#closestValue(TreeNode, double)
     * @see <a href="https://leetcode-cn.com/problems/closest-binary-search-tree-value-ii/">Closest
     * Binary Search Tree Value II</a>
     */
    public int[] closestKValues(TreeNode root, double target, int k) {
        // todo
        return new int[0];
    }

    /**
     * 273. Integer to English Words (Hard)
     *
     * @see Solution1#intToRoman(int)
     * @see <a href="https://leetcode-cn.com/problems/integer-to-english-words/">Integer to English
     * Words</a>
     */
    public String numberToWords(int num) {
        // todo
        return "";
    }

    /**
     * 274. H-Index (Medium)
     *
     * @see Solution201#hIndex(int[])
     * @see <a href="https://leetcode-cn.com/problems/h-index/">H-Index</a>
     * @see <a href="https://en.wikipedia.org/wiki/H-index>h-index</a>
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length - 1, h = 0;
        for (int i = len; i >= 0; i--) {
            if (citations[i] > len - i) {
                h++;
            }
        }
        return h;
    }

    /**
     * 275. H-Index II (Medium)
     *
     * @see Solution201#hIndex(int[])
     * @see <a href="https://leetcode-cn.com/problems/h-index-ii/">H-Index II</a>
     */
    public int hIndexII(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (citations[mid] < len - mid) {
                low = mid + 1;
            } else if (citations[mid] > len - mid) {
                high = mid - 1;
            } else {
                return citations[mid];
            }
        }
        return len - low;
    }

    /**
     * 276. Paint Fence (Medium)
     *
     * @see Solution101#rob(int[])
     * @see Solution201#rob(int[])
     * @see Solution201#minCost(int[][])
     * @see Solution201#minCostII(int[][])
     * @see <a href="https://leetcode-cn.com/problems/paint-fence/">Paint Fence</a>
     */
    public int numWays(int n, int k) {
        // todo
        return 0;
    }

    /**
     * 277. Find the Celebrity (Medium)
     *
     * @see Solution901#findJudge(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/find-the-celebrity/">Find the Celebrity</a>
     */
    public int findCelebrity(int[][] graph) {
        // todo
        return 0;
    }

    /**
     * 278. First Bad Version (Easy)
     *
     * @see Solution1#searchRange(int[], int)
     * @see Solution1#searchInsert(int[], int)
     * @see Solution301#guessNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/first-bad-version/">First Bad Version</a>
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        // defined api
        return version >= 5;
    }

    /**
     * 279. Perfect Squares (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see Solution201#countPrimes(int)
     * @see Solution201#nthUglyNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/perfect-squares/">Perfect Squares</a>
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int base = 2, square = 4;
        for (int i = 2; i <= n; i++) {
            if (i == square) {
                dp[i] = 1;
                base++;
                square = base * base;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1, jj = 1; jj <= i; j++, jj = j * j) {
                    dp[i] = Math.min(dp[i], dp[i - jj] + 1);
                }
            }
        }
        return dp[n];
    }

    /**
     * 279.2 Perfect Squares (Medium)
     * <p>
     * Every natural number n can be represented as the sum of four integers squares.
     * <p>
     * If and only if n=(4^k)(8m+7), n can only be represented as the sum of four positive integers
     * squares.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem>Lagrange's
     * four-square theorem</a>
     */
    public int numSquares2(int n) {
        if (isSquare(n)) {
            return 1;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    private boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    /**
     * 280. Wiggle Sort (Medium)
     *
     * @see Solution1#sortColors(int[])
     * @see Solution301#wiggleSort(int[])
     * @see <a href="https://leetcode-cn.com/problems/wiggle-sort/">Wiggle Sort</a>
     */
    public void wiggleSort(int[] nums) {
        // todo
    }

    /**
     * 281. Zigzag Iterator (Medium)
     *
     * @see BSTIterator
     * @see Vector2D
     * @see wsg.oj.java.leetcode.problems.impl.PeekingIterator
     * @see NestedInteger
     * @see Solution1701#mergeAlternately(String, String)
     * @see <a href="https://leetcode-cn.com/problems/zigzag-iterator/">Zigzag Iterator</a>
     */
    public int[] ZigzagIterator(int[] v1, int[] v2) {
        // todo
        return new int[0];
    }

    /**
     * 282. Expression Add Operators (Hard)
     *
     * @see Solution101#evalRPN(String[])
     * @see Solution201#calculate(String)
     * @see Solution201#calculate(String)
     * @see Solution201#diffWaysToCompute(String)
     * @see Solution401#findTargetSumWays(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/expression-add-operators/">Expression Add
     * Operators</a>
     */
    public String[] addOperators(String num, int target) {
        // todo
        return new String[0];
    }

    /**
     * 283. Move Zeroes (Easy)
     *
     * @see Solution1#removeElement(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/move-zeroes/">Move Zeroes</a>
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[j++] = num;
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }


    /**
     * 285. Inorder Successor in BST (Medium)
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see BSTIterator
     * @see Solution501#inorderSuccessor(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/inorder-successor-in-bst/">Inorder Successor
     * in BST</a>
     */
    public TreeNode inorderSuccessor(TreeNode root, int p) {
        // todo
        return new TreeNode();
    }

    /**
     * 286. Walls and Gates (Medium)
     *
     * @see Solution101#solve(char[][])
     * @see Solution101#numIslands(char[][])
     * @see Solution301#shortestDistance(int[][])
     * @see Solution401#cleanRoom(int[][], int, int)
     * @see Solution901#orangesRotting(int[][])
     * @see <a href="https://leetcode-cn.com/problems/walls-and-gates/">Walls and Gates</a>
     */
    public void wallsAndGates(int[][] rooms) {
        // todo
    }

    /**
     * 287. Find the Duplicate Number (Medium)
     *
     * @see Solution1#firstMissingPositive(int[])
     * @see Solution101#singleNumber(int[])
     * @see Solution101#detectCycle(ListNode)
     * @see Solution201#missingNumber(int[])
     * @see Solution601#findErrorNums(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-the-duplicate-number/">Find the Duplicate
     * Number</a>
     */
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = 0;
        do {
            fast = nums[fast];
            slow = nums[slow];
        } while (fast != slow);
        return fast;
    }

    /**
     * 289. Game of Life (Medium)
     *
     * @see Solution1#setZeroes(int[][])
     * @see <a href="https://leetcode-cn.com/problems/game-of-life/">Game of Life</a>
     */
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nextState(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>>= 1;
            }
        }
    }

    private void nextState(int[][] board, int i, int j) {
        int lives = 0;
        lives += isLive(board, i - 1, j - 1);
        lives += isLive(board, i, j - 1);
        lives += isLive(board, i + 1, j - 1);
        lives += isLive(board, i - 1, j);
        lives += isLive(board, i + 1, j);
        lives += isLive(board, i - 1, j + 1);
        lives += isLive(board, i, j + 1);
        lives += isLive(board, i + 1, j + 1);
        if (board[i][j] == 0) {
            if (lives == 3) {
                board[i][j] = 2;
            }
        } else {
            if (lives == 2 || lives == 3) {
                board[i][j] = 3;
            }
        }
    }

    private int isLive(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return 0;
        }
        return board[i][j] & 1;
    }

    /**
     * 290. Word Pattern (Easy)
     *
     * @see Solution201#isIsomorphic(String, String)
     * @see Solution201#wordPatternMatch(String, String)
     * @see <a href="https://leetcode-cn.com/problems/word-pattern/">Word Pattern</a>
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<>(26);
        Map<String, Character> s2p = new HashMap<>(26);
        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");
        if (chars.length != words.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            String origin = p2s.put(chars[i], words[i]);
            Character c = s2p.put(words[i], chars[i]);
            if (origin != null && !origin.equals(words[i])) {
                return false;
            }
            if (c != null && !c.equals(chars[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 291. Word Pattern II (Medium)
     *
     * @see Solution201#wordPattern(String, String)
     * @see <a href="https://leetcode-cn.com/problems/word-pattern-ii/">Word Pattern II</a>
     */
    public boolean wordPatternMatch(String pattern, String s) {
        // todo
        return false;
    }

    /**
     * 292. Nim Game (Easy)
     * <p>
     * Bash Game: given n stones, take turns to remove 1-m stones, then the person who takes the
     * last turn wins.
     * <i>If (m+1)|n, the person who takes the first turn will certainly win. Otherwise fail.</i>
     *
     * @see Solution201#canWin(String)
     * @see <a href="https://leetcode-cn.com/problems/nim-game/">Nim Game</a>
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     * 293. Flip Game (Easy)
     *
     * @see Solution201#canWin(String)
     * @see <a href="https://leetcode-cn.com/problems/flip-game/">Flip Game</a>
     */
    public String[] generatePossibleNextMoves(String currentState) {
        // todo
        return new String[0];
    }

    /**
     * 294. Flip Game II (Medium)
     *
     * @see Solution201#canWinNim(int)
     * @see Solution201#generatePossibleNextMoves(String)
     * @see Solution301#getMoneyAmount(int)
     * @see Solution401#canIWin(int, int)
     * @see <a href="https://leetcode-cn.com/problems/flip-game-ii/">Flip Game II</a>
     */
    public boolean canWin(String currentState) {
        // todo
        return false;
    }

    /**
     * 296. Best Meeting Point (Hard)
     *
     * @see Solution301#shortestDistance(int[][])
     * @see Solution401#minMoves2(int[])
     * @see <a href="https://leetcode-cn.com/problems/best-meeting-point/">Best Meeting Point</a>
     */
    public int minTotalDistance(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 297. Serialize and Deserialize Binary Tree (Hard)
     *
     * @see Solution201#encode(String[])
     * @see Solution401#CodecDriver(TreeNode)
     * @see Solution601#findDuplicateSubtrees(TreeNode)
     * @see Solution401#CodecDriver(int)
     * @see <a href="https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/">Serialize
     * and Deserialize Binary Tree</a>
     */
    public String Codec(TreeNode root) {
        // todo
        return "";
    }

    /**
     * 298. Binary Tree Longest Consecutive Sequence (Medium)
     *
     * @see Solution101#longestConsecutive(int[])
     * @see Solution501#longestConsecutive(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence/">Binary
     * Tree Longest Consecutive Sequence</a>
     */
    public int longestConsecutive(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 299. Bulls and Cows (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/bulls-and-cows/">Bulls and Cows</a>
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] inSecret = new int[10];
        int[] inGuess = new int[10];
        for (int i = 0, len = secret.length(); i < len; i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bulls++;
            } else {
                inSecret[c1 - '0']++;
                inGuess[c2 - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(inSecret[i], inGuess[i]);
        }
        return bulls + "A" + cows + "B";
    }
}