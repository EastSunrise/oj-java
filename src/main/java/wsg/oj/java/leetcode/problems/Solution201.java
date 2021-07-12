package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution201 implements Solution {

    /**
     * 221. Maximal Square (Medium)
     *
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
     * 235. Lowest Common Ancestor of a Binary Search Tree (Easy)
     *
     * @see Solution201#lowestCommonAncestorII(TreeNode, TreeNode, TreeNode)
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
     * 240. Search a 2D Matrix II (Medium)
     *
     * @see Arrays#binarySearch
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
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
     * 242. Valid Anagram (Easy)
     *
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
     * 257. Binary Tree Paths (Easy)
     *
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
     * @see <a href="https://leetcode-cn.com/problems/add-digits/">Add Digits</a>
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 260. Single Number III (Medium)
     *
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
     * 263. Ugly Number (Easy)
     *
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
     * @see Solution201#isUgly(int)
     * @see Solution201#numSquares(int)
     * @see Solution301#nthSuperUglyNumber(int, int[])
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
     * 268. Missing Number (Easy)
     *
     * @see Solution201#findDuplicate(int[])
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
     * 278. First Bad Version (Easy)
     *
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
     * 283. Move Zeroes (Easy)
     *
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
     * 287. Find the Duplicate Number (Medium)
     *
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
     * 292. Nim Game (Easy)
     * <p>
     * Bash Game: given n stones, take turns to remove 1-m stones, then the person who takes the
     * last turn wins.
     * <i>If (m+1)|n, the person who takes the first turn will certainly win. Otherwise fail.</i>
     *
     * @see <a href="https://leetcode-cn.com/problems/nim-game/">Nim Game</a>
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
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