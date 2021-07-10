package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * Solutions to problems No.1-No.100.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution1 implements Solution {

    /**
     * 48. Rotate Image (Medium)
     *
     * @see Solution1801#findRotation(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/rotate-image/">Rotate Image</a>
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int n = len - 1;
        // rotate quarter of the matrix four times
        for (int i = 0, iLen = (len + 1) / 2; i < iLen; i++) {
            for (int j = 0, jLen = len / 2; j < jLen; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }

    /**
     * 50. Pow(x, n) (Medium)
     *
     * @see Math#pow(double, double)
     * @see Solution1#mySqrt(int)
     * @see Solution301#superPow(int, int[])
     * @see <a href="https://leetcode-cn.com/problems/powx-n/">Pow(x, n)</a>
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            if (n == 1) {
                return x;
            }
            double res = myPow(x, n >> 1);
            return res * res * (n % 2 == 0 ? 1 : x);
        } else {
            return 1 / myPow(x, -(n + 1)) / x;
        }
    }

    /**
     * 53. Maximum Subarray (Easy)
     * <p>
     * By divide and conquer: Assumes that sum[i] is the maxSubSeqSum of arrays that end with
     * nums[i], then
     * <span>sum[i+1] = max{sum[i] + nums[i+1], nums[i+1]}</span>
     * <span>res[i+1] = max{res[i], sum[i+1]}</span>
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProduct(int[])
     * @see Solution601#findShortestSubArray(int[])
     * @see Solution901#maxTurbulenceSize(int[])
     * @see Solution1701#maxAbsoluteSum(int[])
     * @see Solution1701#maxSumAfterOperation(int[])
     * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">Maximum Subarray</a>
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0], res = nums[0];
        for (int i = 1, numsLength = nums.length; i < numsLength; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > res) {
                res = sum;
            }
        }
        return res;
    }

    /**
     * 54. Spiral Matrix (Medium)
     *
     * @see Solution1#generateMatrix(int)
     * @see Solution801#spiralMatrixIII(int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/spiral-matrix/">Spiral Matrix</a>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        // di: the step of i; dj: the step of j
        // len: the count of unvisited elements in this direction
        // turns: times of turning
        int i = 0, j = -1, di = 0, dj = 1, len = n, turns = 0;
        do {
            for (int k = 0; k < len; k++) {
                i += di;
                j += dj;
                res.add(matrix[i][j]);
            }
            turns++;
            // turn right when reaching the end in this direction
            int temp = di;
            di = dj;
            dj = -temp;
            len = (m + n) - len - turns;
        } while (len > 0);
        return res;
    }

    /**
     * 55. Jump Game (Medium)
     *
     * @see Solution1#jump(int[])
     * @see Solution1301#canReach(int[], int)
     * @see Solution1801#canReach(String, int, int)
     * @see <a href="https://leetcode-cn.com/problems/jump-game/">Jump Game</a>
     */
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        while (target > 0) {
            // if the target is reachable
            boolean reachable = false;
            for (int i = target - 1; i >= 0; i--) {
                if (i + nums[i] >= target) {
                    target = i;
                    reachable = true;
                    break;
                }
            }
            if (!reachable) {
                return false;
            }
        }
        return true;
    }

    /**
     * 56. Merge Intervals (Medium)
     *
     * @see Solution1#insert(int[][], int[])
     * @see Solution201#canAttendMeetings(int[][])
     * @see Solution201#minMeetingRooms(int[][])
     * @see Solution401#findPoisonedDuration(int[], int)
     * @see Solution601#addBoldTag(String, String[])
     * @see Solution701#employeeFreeTime(int)
     * @see Solution701#partitionLabels(String)
     * @see Solution901#intervalIntersection(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/merge-intervals/">Merge Intervals</a>
     */
    public int[][] merge(int[][] intervals) {
        // sort by start times
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            // merge if overlapping
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res.add(cur);
                last = cur;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    /**
     * 57. Insert Interval (Medium)
     *
     * @see Solution1#merge(int[][])
     * @see <a href="https://leetcode-cn.com/problems/insert-interval/">Insert Interval</a>
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int i = Arrays.binarySearch(intervals, newInterval, Comparator.comparingInt(o -> o[0]));
        if (i < 0) {
            i = i == -1 ? 0 : -(i + 1) - 1;
        }
        // merge since i
        while (i < len) {
            int[] interval = intervals[i];
            if (newInterval[1] <= interval[1]) {
                // not exceed current interval
                if (newInterval[1] >= interval[0]) {
                    // merge if overlapping
                    interval[0] = Math.min(interval[0], newInterval[0]);
                    return intervals;
                } else {
                    // insert at the i
                    int[][] res = new int[len + 1][2];
                    System.arraycopy(intervals, 0, res, 0, i);
                    res[i] = newInterval;
                    System.arraycopy(intervals, i, res, i + 1, len - i);
                    return res;
                }
            }
            if (newInterval[0] > interval[1]) {
                // not overlapping
                i++;
            } else {
                // extend the end time if overlapping
                interval[0] = Math.min(interval[0], newInterval[0]);
                int end = newInterval[1];
                int j = i + 1;
                while (j < len) {
                    if (end < intervals[j][0]) {
                        break;
                    } else if (end <= intervals[j][1]) {
                        end = intervals[j][1];
                        j++;
                        break;
                    } else {
                        j++;
                    }
                }
                interval[1] = end;
                i++;
                // merge intervals[0,i) and intervals[j,len)
                if (i == j) {
                    return intervals;
                }
                int[][] res = new int[i + len - j][2];
                System.arraycopy(intervals, 0, res, 0, i);
                System.arraycopy(intervals, j, res, i, len - j);
                return res;
            }
        }
        // append at the last of the intervals
        int[][] res = Arrays.copyOf(intervals, len + 1);
        res[len] = newInterval;
        return res;
    }

    /**
     * 58. Length of Last Word (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/length-of-last-word/">Length of Last Word</a>
     */
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        if (right < 0) {
            return 0;
        }
        int left = right - 1;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }

    /**
     * 59. Spiral Matrix II (Medium)
     *
     * @see Solution1#spiralOrder(int[][])
     * @see Solution801#spiralMatrixIII(int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/spiral-matrix-ii/">Spiral Matrix II</a>
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // di: the step of i; dj: the step of j
        // len: the count of unvisited elements in this direction
        // turns: times of turning
        int i = 0, j = -1, di = 0, dj = 1, len = n, turns = 0, value = 1;
        do {
            for (int k = 0; k < len; k++) {
                i += di;
                j += dj;
                res[i][j] = value++;
            }
            turns++;
            // turn right when reaching the end in this direction
            int temp = di;
            di = dj;
            dj = -temp;
            len = (n + n) - len - turns;
        } while (len > 0);
        return res;
    }

    /**
     * 61. Rotate List (Medium)
     *
     * @see Solution101#rotate(int[], int)
     * @see Solution1#removeNthFromEnd(ListNode, int)
     * @see Solution701#splitListToParts(ListNode, int)
     * @see <a href="https://leetcode-cn.com/problems/rotate-list/">Rotate List</a>
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        k = size - k % size;
        // concat the head and tail as a circle
        tail.next = head;
        while (k-- > 0) {
            tail = head;
            head = head.next;
        }
        // cut at kth node
        tail.next = null;
        return head;
    }

    /**
     * 62. Unique Paths (Medium)
     *
     * @see Solution1#uniquePathsWithObstacles(int[][])
     * @see Solution1#minPathSum(int[][])
     * @see Solution101#calculateMinimumHP(int[][])
     * @see <a href="https://leetcode-cn.com/problems/unique-paths/">Unique Paths</a>
     */
    public int uniquePaths(int m, int n) {
        // combinatorial number: C(m-1, m+n-2)
        long res = 1;
        int i = Math.min(m, n) - 1, k = m + n - 2;
        for (int j = 0; j < i; j++) {
            res *= k--;
        }
        while (i > 1) {
            res /= i--;
        }
        return (int) res;
    }

    /**
     * 63. Unique Paths II (Medium)
     *
     * @see Solution1#uniquePaths(int, int)
     * @see Solution901#uniquePathsIII(int[][])
     * @see <a href="https://leetcode-cn.com/problems/unique-paths-ii/">Unique Paths II</a>
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                res[i][0] = 0;
            } else {
                res[i][0] = res[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                res[0][j] = 0;
            } else {
                res[0][j] = res[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     * 64. Minimum Path Sum (Medium)
     *
     * @see Solution1#uniquePaths(int, int)
     * @see Solution1#uniquePathsWithObstacles(int[][])
     * @see Solution101#calculateMinimumHP(int[][])
     * @see Solution701#cherryPickup(int[][])
     * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">Minimum Path Sum</a>
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     * 66. Plus One (Easy)
     *
     * @see Solution1#multiply(String, String)
     * @see Solution1#addBinary(String, String)
     * @see Solution301#plusOne(ListNode)
     * @see Solution901#addToArrayForm(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/plus-one/">Plus One</a>
     */
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; carry && i >= 0; i--) {
            int d = digits[i] + 1;
            if (d == 10) {
                digits[i] = 0;
            } else {
                digits[i] = d;
                carry = false;
            }
        }
        if (!carry) {
            return digits;
        }
        int[] copy = new int[digits.length + 1];
        copy[0] = 1;
        System.arraycopy(digits, 0, copy, 1, digits.length);
        return copy;
    }

    /**
     * 67. Add Binary (Easy)
     *
     * @see Solution1#addTwoNumbers(ListNode, ListNode)
     * @see Solution1#multiply(String, String)
     * @see Solution1#plusOne(int[])
     * @see Solution401#addStrings(String, String)
     * @see Solution901#addToArrayForm(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/add-binary/">Add Binary</a>
     */
    public String addBinary(String a, String b) {
        int ai = a.length() - 1, bi = b.length() - 1;
        int ri = Math.max(ai, bi) + 1;
        char[] res = new char[ri + 1];
        int carry = 0;
        while (ai >= 0 && bi >= 0) {
            int av = a.charAt(ai--) - '0';
            int bv = b.charAt(bi--) - '0';
            int sum = av + bv + carry;
            res[ri--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        while (carry > 0 && ai >= 0) {
            char ac = a.charAt(ai--);
            if (ac == '0') {
                carry = 0;
                res[ri--] = '1';
            } else {
                res[ri--] = '0';
            }
        }
        while (ai >= 0) {
            res[ri--] = a.charAt(ai--);
        }
        while (carry > 0 && bi >= 0) {
            char bc = b.charAt(bi--);
            if (bc == '0') {
                carry = 0;
                res[ri--] = '1';
            } else {
                res[ri--] = '0';
            }
        }
        while (bi >= 0) {
            res[ri--] = b.charAt(bi--);
        }
        if (carry == 0) {
            return String.valueOf(res, 1, res.length - 1);
        }
        res[0] = '1';
        return String.valueOf(res);
    }

    /**
     * 69. Sqrt(x) (Easy)
     *
     * @see Solution1#myPow(double, int)
     * @see Solution301#isPerfectSquare(int)
     * @see <a href="https://leetcode-cn.com/problems/sqrtx/">Sqrt(x)</a>
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x;
        while (left < right) {
            right = left + ((right - left) >> 1);
            left = x / right;
        }
        return right;
    }

    /**
     * 70. Climbing Stairs (Easy)
     * <p>
     * Fibonacci sequence
     *
     * @see Solution701#minCostClimbingStairs(int[])
     * @see Solution501#fib(int)
     * @see Solution1101#tribonacci(int)
     * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">Climbing Stairs</a>
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int lastLast = 1, last = 2;
        for (int i = 3; i <= n; i++) {
            last = lastLast + last;
            lastLast = last - lastLast;
        }
        return last;
    }

    /**
     * 71. Simplify Path (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/simplify-path/">Simplify Path</a>
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (char ch : (path + "/").toCharArray()) {
            if (ch == '/') {
                if (temp.length() > 0) {
                    String name = temp.toString();
                    if ("..".equals(name)) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else if (!".".equals(name)) {
                        stack.push(name);
                    }
                    temp = new StringBuilder();
                }
            } else {
                temp.append(ch);
            }
        }
        if (stack.empty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (String s : stack) {
            res.append("/").append(s);
        }
        return res.toString();
    }

    /**
     * 73. Set Matrix Zeroes (Medium)
     *
     * @see Solution201#gameOfLife(int[][])
     * @see <a href="https://leetcode-cn.com/problems/set-matrix-zeroes/">Set Matrix Zeroes</a>
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false, column0 = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }
        for (int[] rows : matrix) {
            if (rows[0] == 0) {
                column0 = true;
                break;
            }
        }
        // record rows and columns to be changed in first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (column0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * 74. Search a 2D Matrix (Medium)
     *
     * @see Solution201#searchMatrix(int[][], int)
     * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = matrix[mid][0];
            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return right >= 0 && Arrays.binarySearch(matrix[right], target) >= 0;
    }

    /**
     * 75. Sort Colors (Medium)
     *
     * @see Solution101#sortList(ListNode)
     * @see Solution201#wiggleSort(int[])
     * @see Solution301#wiggleSort(int[])
     * @see <a href="https://leetcode-cn.com/problems/sort-colors/">Sort Colors</a>
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == 0) {
                left++;
            } else if (nums[right] != 0) {
                right--;
            } else {
                nums[right] = nums[left];
                nums[left] = 0;
                left++;
                right--;
            }
        }
        right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 1) {
                left++;
            } else if (nums[right] == 2) {
                right--;
            } else {
                nums[left] = 1;
                nums[right] = 2;
                left++;
                right--;
            }
        }
    }

    /**
     * 77. Combinations (Medium)
     *
     * @see Solution1#combinationSum(int[], int)
     * @see Solution1#permute(int[])
     * @see <a href="https://leetcode-cn.com/problems/combinations/">Combinations</a>
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(k), 1, n + 1, k);
        return res;
    }

    /**
     * @param temp chosen numbers in ascending order
     * @param from the min number (inclusive) that can be chosen
     * @param to   the max number (exclusive) that can be chosen
     * @param k    the left numbers to choose from [from,to)
     */
    private void combine(List<List<Integer>> res, List<Integer> temp, int from, int to, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = from, len = to - k; i <= len; i++) {
            temp.add(i);
            combine(res, temp, i + 1, to, k - 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 78. Subsets (Medium)
     *
     * @see Solution1#subsetsWithDup(int[])
     * @see Solution301#generateAbbreviations(String)
     * @see Solution701#letterCasePermutation(String)
     * @see <a href="https://leetcode-cn.com/problems/subsets/">Subsets</a>
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, nums, new ArrayList<>(), nums.length - 1);
        return res;
    }

    /**
     * @param temp chosen numbers from [i+1,length)
     * @param i    the index of the number to be chosen or not
     */
    private void subsets(List<List<Integer>> res, int[] nums, List<Integer> temp, int i) {
        if (i < 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        subsets(res, nums, temp, i - 1);
        temp.add(nums[i]);
        subsets(res, nums, temp, i - 1);
        temp.remove(temp.size() - 1);
    }

    /**
     * 79. Word Search (Medium)
     *
     * @see Solution201#findWords(char[][], String[])
     * @see <a href="https://leetcode-cn.com/problems/word-search/">Word Search</a>
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length - 1, n = board[0].length - 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (exist(board, m, n, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param m the maximum that i can be
     * @param n the maximum that j can be
     * @param i the row of the char to be compared
     * @param j the column of the char to be compared
     * @param k the index of the char to be found
     */
    private boolean exist(char[][] board, int m, int n, int i, int j, char[] chars, int k) {
        char ch = chars[k];
        if (board[i][j] != ch) {
            return false;
        }
        k++;
        if (k == chars.length) {
            // all found
            return true;
        }
        // used
        board[i][j] = '#';
        if (i > 0 && exist(board, m, n, i - 1, j, chars, k)) {
            return true;
        }
        if (j > 0 && exist(board, m, n, i, j - 1, chars, k)) {
            return true;
        }
        if (i < m && exist(board, m, n, i + 1, j, chars, k)) {
            return true;
        }
        if (j < n && exist(board, m, n, i, j + 1, chars, k)) {
            return true;
        }
        // restore the char
        board[i][j] = ch;
        return false;
    }

    /**
     * 80. Remove Duplicates from Sorted Array II (Medium)
     *
     * @see Solution1#removeDuplicates(int[])
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/">Remove
     * Duplicates from Sorted Array II</a>
     */
    public int removeDuplicatesII(int[] nums) {
        int res = 0, cur = nums[0], count = 0;
        for (int num : nums) {
            if (num == cur) {
                count++;
                if (count <= 2) {
                    nums[res++] = cur;
                }
            } else {
                count = 1;
                cur = num;
                nums[res++] = cur;
            }
        }
        return res;
    }

    /**
     * 81. Search in Rotated Sorted Array II (Medium)
     *
     * @see Solution1#search(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/">Search in
     * Rotated Sorted Array II</a>
     */
    public boolean searchII(int[] nums, int target) {
        return searchII(nums, 0, nums.length - 1, target);
    }

    private boolean searchII(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal == target) {
                return true;
            }
            if (midVal < nums[high]) {
                if (midVal < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (midVal == nums[high]) {
                if (midVal == nums[low]) {
                    // can't determine the order
                    return searchII(nums, low + 1, mid - 1, target)
                        || searchII(nums, mid + 1, high - 1, target);
                } else {
                    high = mid - 1;
                }
            } else {
                if (midVal > target && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * 82. Remove Duplicates from Sorted List II (Medium)
     *
     * @see Solution1#deleteDuplicates(ListNode)
     * @see Solution1801#deleteDuplicatesUnsorted(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/">Remove
     * Duplicates from Sorted List II</a>
     */
    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode cur = head, pre = res;
        while (cur != null) {
            ListNode next = cur.next;
            // count of duplicate numbers
            int count = 1, val = cur.val;
            while (next != null && next.val == val) {
                next = next.next;
                count++;
            }
            if (count > 1) {
                // remove all duplicate nodes
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return res.next;
    }

    /**
     * 83. Remove Duplicates from Sorted List (Easy)
     *
     * @see Solution1#deleteDuplicatesII(ListNode)
     * @see Solution1801#deleteDuplicatesUnsorted(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">Remove
     * Duplicates from Sorted List</a>
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = head;
        ListNode cursor = head.next;
        while (cursor != null) {
            if (cursor.val == last.val) {
                last.next = cursor.next;
            } else {
                last = cursor;
            }
            cursor = cursor.next;
        }
        return head;
    }

    /**
     * 86. Partition List (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/partition-list/">Partition List</a>
     */
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0), rightHead = new ListNode(0);
        ListNode left = leftHead, right = rightHead;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        if (leftHead.next == null) {
            return rightHead.next;
        }
        left.next = rightHead.next;
        return leftHead.next;
    }

    /**
     * 88. Merge Sorted Array (Easy)
     *
     * @see Solution1#mergeTwoLists(ListNode, ListNode)
     * @see Solution901#sortedSquares(int[])
     * @see Solution901#intervalIntersection(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/merge-sorted-array/">Merge Sorted Array</a>
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[index--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }

    /**
     * 89. Gray Code (Medium)
     * <p>
     * g(n+1) = g(n) + Reverse(g(n)+2^n)
     *
     * @see Solution701#isOneBitCharacter(int[])
     * @see <a href="https://leetcode-cn.com/problems/gray-code/">Gray Code</a>
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        grayCode(res, n);
        return res;
    }

    private int grayCode(List<Integer> res, int n) {
        if (n == 1) {
            res.add(0);
            res.add(1);
            return 2;
        }
        int power = grayCode(res, n - 1);
        for (int i = res.size() - 1; i >= 0; i--) {
            res.add(res.get(i) + power);
        }
        return power * 2;
    }

    /**
     * 89.2 Gray Code (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/gray-code/">Gray Code</a>
     */
    public List<Integer> grayCode2(int n) {
        int count = 1 << n;
        List<Integer> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    /**
     * 90. Subsets II (Medium)
     *
     * @see Solution1#subsets(int[])
     * @see <a href="https://leetcode-cn.com/problems/subsets-ii/">Subsets II</a>
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDup(res, nums, new ArrayList<>(), 0);
        return res;
    }

    /**
     * @param temp chosen numbers from [i+1,length)
     * @param i    the first index of a distinct number to be chosen or not
     */
    private void subsetsWithDup(List<List<Integer>> res, int[] nums, List<Integer> temp, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        int j = i + 1, val = nums[i];
        while (j < nums.length && nums[j] == val) {
            j++;
        }
        // without this value
        subsetsWithDup(res, nums, temp, j);
        for (int k = i; k < j; k++) {
            // with this value of k-i+1 numbers
            temp.add(val);
            subsetsWithDup(res, nums, temp, j);
        }
        // restore
        for (int k = i; k < j; k++) {
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 91. Decode Ways (Medium)
     *
     * @see Solution601#numDecodings(String)
     * @see <a href="https://leetcode-cn.com/problems/decode-ways/">Decode Ways</a>
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] res = new int[len];
        res[0] = chars[0] == '0' ? 0 : 1;
        if (len == 1) {
            return res[0];
        }

        if (chars[1] > '0') {
            res[1] += res[0];
        }
        if (chars[0] == '1' || (chars[0] == '2' && chars[1] <= '6')) {
            res[1] += 1;
        }
        for (int i = 2; i < len; i++) {
            if (chars[i] > '0') {
                res[i] += res[i - 1];
            }
            if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                res[i] += res[i - 2];
            }
        }
        return res[len - 1];
    }

    /**
     * 92. Reverse Linked List II (Medium)
     *
     * @see Solution201#reverseList(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list-ii/">Reverse Linked List
     * II</a>
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0, head);
        ListNode pre = res;
        while (left-- > 1) {
            pre = pre.next;
            right--;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = pre.next;
        while (right-- > 0) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
            ListNode top = stack.pop();
            // cut to prevent a circle
            top.next = null;
            pre.next = top;
            pre = top;
        }
        pre.next = cur;
        return res.next;
    }

    /**
     * 93. Restore IP Addresses (Medium)
     *
     * @see #BACKTRACKING
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see Solution701#ipToCIDR(String, int)
     * @see <a href="https://leetcode-cn.com/problems/restore-ip-addresses/">Restore IP
     * Addresses</a>
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddresses(res, s.toCharArray(), new StringBuilder(15), 4, 0);
        return res;
    }

    /**
     * @param temp store chosen part
     * @param left left integers to be chosen, range [0,4]
     * @param i    the start index of chars to be chosen
     */
    private void restoreIpAddresses(List<String> res, char[] chars, StringBuilder temp, int left,
        int i) {
        if (i == chars.length || left == 0) {
            if (i == chars.length && left == 0) {
                // all chars used for four integers
                res.add(temp.toString());
            }
            return;
        }
        if (left * 3 + i < chars.length || left + i > chars.length) {
            // if the left chars are too many or not enough
            return;
        }
        left--;
        int len = temp.length();
        if (len != 0) {
            temp.append('.');
        }
        int val = chars[i] - '0';
        // 0-9
        temp.append(chars[i++]);
        restoreIpAddresses(res, chars, temp, left, i);
        if (i < chars.length) {
            val = val * 10 + chars[i] - '0';
            if (val >= 10) {
                // 10-99
                temp.append(chars[i++]);
                restoreIpAddresses(res, chars, temp, left, i);
                if (i < chars.length) {
                    val = val * 10 + chars[i] - '0';
                    if (val >= 100 && val <= 255) {
                        // 100-255
                        temp.append(chars[i++]);
                        restoreIpAddresses(res, chars, temp, left, i);
                    }
                }
            }
        }
        temp.delete(len, temp.length());
    }

    /**
     * 95. Unique Binary Search Trees II (Medium)
     *
     * @see Solution1#numTrees(int)
     * @see Solution201#diffWaysToCompute(String)
     * @see <a href="https://leetcode-cn.com/problems/unique-binary-search-trees-ii/">Unique Binary
     * Search Trees II</a>
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min > max) {
            res.add(null);
            return res;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> lefts = generateTrees(min, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, max);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        return res;
    }

    /**
     * 96. Unique Binary Search Trees (Medium)
     * <p>
     * f(k) = f(0)*f(k-1) + f(1)*f(k-2) + ... + f(k-1)*f(0)
     *
     * @see Solution1#generateTrees(int)
     * @see <a href="https://leetcode-cn.com/problems/unique-binary-search-trees/">Unique Binary
     * Search Trees</a>
     */
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                res[k] += res[i] * res[k - 1 - i];
            }
        }
        return res[n];
    }

    /**
     * 97. Interleaving String (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     * @see <a href="https://leetcode-cn.com/problems/interleaving-string/">Interleaving String</a>
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        boolean[][] res = new boolean[len1 + 1][len2 + 1];
        res[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            res[i][0] = res[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= len2; j++) {
            res[0][j] = res[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char ch3 = s3.charAt(i + j - 1);
                res[i][j] = (s1.charAt(i - 1) == ch3 && res[i - 1][j])
                    || (s2.charAt(j - 1) == ch3 && res[i][j - 1]);
            }
        }
        return res[len1][len2];
    }

    /**
     * 98. Validate Binary Search Tree (Medium)
     *
     * @see #DFS
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     * @see Solution1#inorderTraversal(TreeNode)
     * @see Solution501#findMode(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">Validate Binary
     * Search Tree</a>
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * All values of the tree should be in the range (min, max), both exclusive.
     */
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        int val = node.val;
        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }
        return (node.left == null || isValidBST(node.left, min, val))
            && (node.right == null || isValidBST(node.right, val, max));
    }

    /**
     * 100. Same Tree (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/same-tree/">Same Tree</a>
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        return q != null && p.val == q.val
            && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}