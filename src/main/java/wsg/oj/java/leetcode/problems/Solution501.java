package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * Solutions to problems No.501-No.600.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution501 extends Solution {

    /**
     * 501. Find Mode in Binary Search Tree (Easy)
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see Solution1#isValidBST(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/">Find Mode in
     * Binary Search Tree</a>
     */
    public int[] findMode(TreeNode root) {
        int[] temp = new int[3];
        List<Integer> modes = new ArrayList<>();
        inorderTraversal(root, temp, modes);
        int[] res = new int[modes.size()];
        int i = 0;
        for (int mode : modes) {
            res[i++] = mode;
        }
        return res;
    }

    private void inorderTraversal(TreeNode node, int[] temp, List<Integer> modes) {
        // temp: current number, count of current number, count of each mode
        if (node.left != null) {
            inorderTraversal(node.left, temp, modes);
        }
        if (node.val == temp[0]) {
            temp[1]++;
        } else {
            temp[0] = node.val;
            temp[1] = 1;
        }
        if (temp[1] > temp[2]) {
            modes.clear();
            modes.add(temp[0]);
            temp[2] = temp[1];
        } else if (temp[1] == temp[2]) {
            modes.add(temp[0]);
        }
        if (node.right != null) {
            inorderTraversal(node.right, temp, modes);
        }
    }

    /**
     * 502. IPO (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/ipo/">IPO</a>
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // todo
        return 0;
    }

    /**
     * 503. Next Greater Element II (Medium)
     *
     * @see Solution401#nextGreaterElement(int[], int[])
     * @see Solution501#nextGreaterElement(int)
     * @see <a href="https://leetcode-cn.com/problems/next-greater-element-ii/">Next Greater Element
     * II</a>
     */
    public int[] nextGreaterElements(int[] nums) {
        // todo
        return new int[0];
    }

    /**
     * 504. Base 7 (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/base-7/">Base 7</a>
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int value = Math.abs(num);
        StringBuilder builder = new StringBuilder();
        while (value > 0) {
            builder.append(value % 7);
            value /= 7;
        }
        if (num < 0) {
            builder.append("-");
        }
        return builder.reverse().toString();
    }

    /**
     * 505. The Maze II (Medium)
     *
     * @see Solution401#hasPath(int[][], int[], int[])
     * @see Solution401#findShortestWay(int[][], int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/the-maze-ii/">The Maze II</a>
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // todo
        return 0;
    }

    /**
     * 506. Relative Ranks (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/relative-ranks/">Relative Ranks</a>
     */
    public String[] findRelativeRanks(int[] scores) {
        int len = scores.length;
        int[] copy = Arrays.copyOf(scores, len);
        Arrays.sort(copy);
        Map<Integer, Integer> ranks = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            ranks.put(copy[i], len - i);
        }
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            int rank = ranks.get(scores[i]);
            if (rank > 3) {
                res[i] = String.valueOf(rank);
            } else {
                if (rank == 1) {
                    res[i] = "Gold Medal";
                } else if (rank == 2) {
                    res[i] = "Silver Medal";
                } else if (rank == 3) {
                    res[i] = "Bronze Medal";
                }
            }
        }
        return res;
    }

    /**
     * 507. Perfect Number (Easy)
     *
     * @see Solution701#selfDividingNumbers(int, int)
     * @see <a href="https://leetcode-cn.com/problems/perfect-number/">Perfect Number</a>
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int low = 2, sum = 1;
        while (low * low < num) {
            if (num % low == 0) {
                sum += low + num / low;
            }
            low++;
        }
        if (low * low == num) {
            sum += low;
        }
        return sum == num;
    }

    /**
     * 508. Most Frequent Subtree Sum (Medium)
     *
     * @see Solution501#isSubtree(TreeNode, TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/most-frequent-subtree-sum/">Most Frequent
     * Subtree Sum</a>
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        // todo
        return new int[0];
    }

    /**
     * 509. Fibonacci Number (Easy)
     *
     * @see Solution1#climbStairs(int)
     * @see Solution801#splitIntoFibonacci(String)
     * @see Solution801#lenLongestFibSubseq(int[])
     * @see Solution1101#tribonacci(int)
     * @see <a href="https://leetcode-cn.com/problems/fibonacci-number/">Fibonacci Number</a>
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[n];
    }

    /**
     * 510. Inorder Successor in BST II (Medium)
     *
     * @see Solution201#inorderSuccessor(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/inorder-successor-in-bst-ii/">Inorder
     * Successor in BST II</a>
     */
    public TreeNode inorderSuccessor(TreeNode tree, int node) {
        // todo
        return new TreeNode();
    }


    /**
     * 513. Find Bottom Left Tree Value (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-bottom-left-tree-value/">Find Bottom Left
     * Tree Value</a>
     */
    public int findBottomLeftValue(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 514. Freedom Trail (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/freedom-trail/">Freedom Trail</a>
     */
    public int findRotateSteps(String ring, String key) {
        // todo
        return 0;
    }

    /**
     * 515. Find Largest Value in Each Tree Row (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/">Find
     * Largest Value in Each Tree Row</a>
     */
    public int[] largestValues(TreeNode root) {
        // todo
        return new int[0];
    }

    /**
     * 516. Longest Palindromic Subsequence (Medium)
     *
     * @see Solution1#longestPalindrome(String)
     * @see Solution601#countSubstrings(String)
     * @see Solution701#countPalindromicSubsequences(String)
     * @see Solution1101#longestCommonSubsequence(String, String)
     * @see Solution1601#longestPalindromeSubseq(String)
     * @see Solution1701#longestPalindrome(String, String)
     * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-subsequence/">Longest
     * Palindromic Subsequence</a>
     */
    public int longestPalindromeSubseq(String s) {
        // todo
        return 0;
    }

    /**
     * 517. Super Washing Machines (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/super-washing-machines/">Super Washing
     * Machines</a>
     */
    public int findMinMoves(int[] machines) {
        // todo
        return 0;
    }

    /**
     * 518. Coin Change 2 (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/coin-change-2/">Coin Change 2</a>
     */
    public int change(int amount, int[] coins) {
        // todo
        return 0;
    }


    /**
     * 520. Detect Capital (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/detect-capital/">Detect Capital</a>
     */
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len == 1) {
            return true;
        }
        char[] chars = word.toCharArray();
        char first = chars[0];
        if (first > 'Z') {
            for (int i = 1; i < len; i++) {
                if (chars[i] < 'a') {
                    return false;
                }
            }
            return true;
        }
        boolean upper = chars[1] < 'a';
        for (int i = 2; i < len; i++) {
            if ((chars[i] < 'a') ^ upper) {
                return false;
            }
        }
        return true;
    }

    /**
     * 521. Longest Uncommon Subsequence I (Easy)
     *
     * @see Solution501#findLUSlength(String[])
     * @see <a href="https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/">Longest
     * Uncommon Subsequence I</a>
     */
    public int findLUSlength(String a, String b) {
        // todo
        return 0;
    }

    /**
     * 522. Longest Uncommon Subsequence II (Medium)
     *
     * @see Solution501#findLUSlength(String, String)
     * @see <a href="https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii/">Longest
     * Uncommon Subsequence II</a>
     */
    public int findLUSlength(String[] strs) {
        // todo
        return 0;
    }

    /**
     * 523. Continuous Subarray Sum (Medium)
     *
     * @see Solution501#subarraySum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/continuous-subarray-sum/">Continuous Subarray
     * Sum</a>
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        // todo
        return false;
    }

    /**
     * 524. Longest Word in Dictionary through Deleting (Medium)
     *
     * @see Solution701#longestWord(String[])
     * @see <a href="https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/">Longest
     * Word in Dictionary through Deleting</a>
     */
    public String findLongestWord(String s, String[] dictionary) {
        // todo
        return "";
    }

    /**
     * 525. Contiguous Array (Medium)
     *
     * @see Solution301#maxSubArrayLen(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/contiguous-array/">Contiguous Array</a>
     */
    public int findMaxLength(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 526. Beautiful Arrangement (Medium)
     *
     * @see Solution601#constructArray(int, int)
     * @see <a href="https://leetcode-cn.com/problems/beautiful-arrangement/">Beautiful
     * Arrangement</a>
     */
    public int countArrangement(int n) {
        // todo
        return 0;
    }

    /**
     * 527. Word Abbreviation (Hard)
     *
     * @see Solution401#validWordAbbreviation(String, String)
     * @see Solution401#minAbbreviation(String, String[])
     * @see <a href="https://leetcode-cn.com/problems/word-abbreviation/">Word Abbreviation</a>
     */
    public String[] wordsAbbreviation(String[] words) {
        // todo
        return new String[0];
    }


    /**
     * 529. Minesweeper (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/minesweeper/">Minesweeper</a>
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        // todo
        return new char[0][0];
    }

    /**
     * 530. Minimum Absolute Difference in BST (Easy)
     *
     * @see Solution501#findPairs(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/">Minimum
     * Absolute Difference in BST</a>
     */
    public int getMinimumDifference(TreeNode root) {
        return getDifference(root)[2];
    }

    private int[] getDifference(TreeNode node) {
        // return min, max, minDif
        int val = node.val;
        int[] res = new int[]{val, val, Integer.MAX_VALUE};
        if (node.left != null) {
            int[] left = getDifference(node.left);
            res[0] = left[0];
            res[2] = Math.min(left[2], val - left[1]);
        }
        if (node.right != null) {
            int[] right = getDifference(node.right);
            res[1] = right[1];
            res[2] = Math.min(res[2], Math.min(right[2], right[0] - val));
        }
        return res;
    }

    /**
     * 531. Lonely Pixel I (Medium)
     *
     * @see Solution501#findBlackPixel(char[][], int)
     * @see <a href="https://leetcode-cn.com/problems/lonely-pixel-i/">Lonely Pixel I</a>
     */
    public int findLonelyPixel(char[][] picture) {
        // todo
        return 0;
    }

    /**
     * 532. K-diff Pairs in an Array (Medium)
     *
     * @see Solution501#getMinimumDifference(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/">K-diff Pairs in an
     * Array</a>
     */
    public int findPairs(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 533. Lonely Pixel II (Medium)
     *
     * @see Solution501#findLonelyPixel(char[][])
     * @see <a href="https://leetcode-cn.com/problems/lonely-pixel-ii/">Lonely Pixel II</a>
     */
    public int findBlackPixel(char[][] picture, int target) {
        // todo
        return 0;
    }


    /**
     * 535. Encode and Decode TinyURL (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/encode-and-decode-tinyurl/">Encode and Decode
     * TinyURL</a>
     */
    public String CodecDriver(String url) {
        // todo
        return "";
    }

    /**
     * 536. Construct Binary Tree from String (Medium)
     *
     * @see Solution601#tree2str(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-string/">Construct
     * Binary Tree from String</a>
     */
    public TreeNode str2tree(String s) {
        // todo
        return new TreeNode();
    }

    /**
     * 537. Complex Number Multiplication (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/complex-number-multiplication/">Complex Number
     * Multiplication</a>
     */
    public String complexNumberMultiply(String num1, String num2) {
        // todo
        return "";
    }

    /**
     * 538. Convert BST to Greater Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/">Convert BST to
     * Greater Tree</a>
     */
    public TreeNode convertBST(TreeNode root) {
        // todo
        return new TreeNode();
    }

    /**
     * 539. Minimum Time Difference (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-time-difference/">Minimum Time
     * Difference</a>
     */
    public int findMinDifference(String[] timePoints) {
        // todo
        return 0;
    }

    /**
     * 540. Single Element in a Sorted Array (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/single-element-in-a-sorted-array/">Single
     * Element in a Sorted Array</a>
     */
    public int singleNonDuplicate(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 541. Reverse String II (Easy)
     *
     * @see Solution301#reverseString(char[])
     * @see Solution501#reverseWords(String)
     * @see <a href="https://leetcode-cn.com/problems/reverse-string-ii/">Reverse String II</a>
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int start = 0; start < len; start += 2 * k) {
            int left = start, right = Math.min(start + k, len) - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    /**
     * 542. 01 Matrix (Medium)
     *
     * @see Solution1701#getFood(char[][])
     * @see <a href="https://leetcode-cn.com/problems/01-matrix/">01 Matrix</a>
     */
    public int[][] updateMatrix(int[][] mat) {
        // todo
        return new int[0][0];
    }

    /**
     * 543. Diameter of Binary Tree (Easy)
     *
     * @see Solution101#maxDepth(TreeNode)
     * @see Solution1501#diameter(int)
     * @see <a href="https://leetcode-cn.com/problems/diameter-of-binary-tree/">Diameter of Binary
     * Tree</a>
     */
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterAndMaxDepth(root)[0] - 1;
    }

    /**
     * @return [counts of nodes on diameter, max depth]
     */
    private int[] diameterAndMaxDepth(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = diameterAndMaxDepth(node.left);
        int[] right = diameterAndMaxDepth(node.right);
        int count = Math.max(left[0], right[0]);
        count = Math.max(count, left[1] + right[1] + 1);
        int depth = Math.max(left[1], right[1]) + 1;
        return new int[]{count, depth};
    }

    /**
     * 544. Output Contest Matches (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/output-contest-matches/">Output Contest
     * Matches</a>
     */
    public String findContestMatch(int n) {
        // todo
        return "";
    }

    /**
     * 545. Boundary of Binary Tree (Medium)
     *
     * @see Solution101#rightSideView(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/boundary-of-binary-tree/">Boundary of Binary
     * Tree</a>
     */
    public int[] boundaryOfBinaryTree(TreeNode root) {
        // todo
        return new int[0];
    }

    /**
     * 546. Remove Boxes (Hard)
     *
     * @see Solution601#strangePrinter(String)
     * @see <a href="https://leetcode-cn.com/problems/remove-boxes/">Remove Boxes</a>
     */
    public int removeBoxes(int[] boxes) {
        // todo
        return 0;
    }

    /**
     * 547. Number of Provinces (Medium)
     *
     * @see Solution301#countComponents(int, int[][])
     * @see Solution601#judgeCircle(String)
     * @see Solution701#areSentencesSimilar(String[], String[], String[][])
     * @see Solution701#areSentencesSimilarTwo(String[], String[], String[][])
     * @see Solution1101#earliestAcq(int[][], int)
     * @see <a href="https://leetcode-cn.com/problems/number-of-provinces/">Number of Provinces</a>
     */
    public int findCircleNum(int[][] isConnected) {
        // todo
        return 0;
    }

    /**
     * 548. Split Array with Equal Sum (Medium)
     *
     * @see Solution1501#numWays(String)
     * @see <a href="https://leetcode-cn.com/problems/split-array-with-equal-sum/">Split Array with
     * Equal Sum</a>
     */
    public boolean splitArray(int[] nums) {
        // todo
        return false;
    }

    /**
     * 549. Binary Tree Longest Consecutive Sequence II (Medium)
     *
     * @see Solution201#longestConsecutive(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence-ii/">Binary
     * Tree Longest Consecutive Sequence II</a>
     */
    public int longestConsecutive(TreeNode root) {
        // todo
        return 0;
    }


    /**
     * 551. Student Attendance Record I (Easy)
     *
     * @see Solution501#checkRecord(int)
     * @see <a href="https://leetcode-cn.com/problems/student-attendance-record-i/">Student
     * Attendance Record I</a>
     */
    public boolean checkRecord(String s) {
        int totalAbsent = 0, consecutiveLate = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'L') {
                if (++consecutiveLate > 2) {
                    return false;
                }
            } else {
                consecutiveLate = 0;
                if (c == 'A') {
                    totalAbsent++;
                }
            }
        }
        return totalAbsent < 2;
    }

    /**
     * 552. Student Attendance Record II (Hard)
     *
     * @see Solution501#checkRecord(String)
     * @see <a href="https://leetcode-cn.com/problems/student-attendance-record-ii/">Student
     * Attendance Record II</a>
     */
    public int checkRecord(int n) {
        // todo
        return 0;
    }

    /**
     * 553. Optimal Division (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/optimal-division/">Optimal Division</a>
     */
    public String optimalDivision(int[] nums) {
        // todo
        return "";
    }

    /**
     * 554. Brick Wall (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/brick-wall/">Brick Wall</a>
     */
    public int leastBricks(int[][] wall) {
        // todo
        return 0;
    }

    /**
     * 555. Split Concatenated Strings (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/split-concatenated-strings/">Split
     * Concatenated Strings</a>
     */
    public String splitLoopedString(String[] strs) {
        // todo
        return "";
    }

    /**
     * 556. Next Greater Element III (Medium)
     *
     * @see Solution401#nextGreaterElement(int[], int[])
     * @see Solution501#nextGreaterElements(int[])
     * @see Solution1801#nextPalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/next-greater-element-iii/">Next Greater
     * Element III</a>
     */
    public int nextGreaterElement(int n) {
        // todo
        return 0;
    }

    /**
     * 557. Reverse Words in a String III (Easy)
     *
     * @see Solution501#reverseStr(String, int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/">Reverse Words
     * in a String III</a>
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int start = 0;
        do {
            int end = start + 1;
            while (end < len && chars[end] != ' ') {
                end++;
            }
            int left = start, right = end - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            start = end + 1;
        } while (start < len);
        return new String(chars);
    }

    /**
     * 558. Logical OR of Two Binary Grids Represented as Quad-Trees (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/">Logical
     * OR of Two Binary Grids Represented as Quad-Trees</a>
     */
    public int[][] intersect(int[][] quadTree1, int[][] quadTree2) {
        // todo
        return new int[0][0];
    }

    /**
     * 559. Maximum Depth of N-ary Tree (Easy)
     *
     * @see Solution101#maxDepth(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/">Maximum Depth of
     * N-ary Tree</a>
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
    }

    /**
     * 560. Subarray Sum Equals K (Medium)
     *
     * @see Solution1#twoSum(int[], int)
     * @see Solution501#checkSubarraySum(int[], int)
     * @see Solution701#numSubarrayProductLessThanK(int[], int)
     * @see Solution701#pivotIndex(int[])
     * @see Solution901#subarraysDivByK(int[], int)
     * @see Solution1601#minOperations(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/subarray-sum-equals-k/">Subarray Sum Equals
     * K</a>
     */
    public int subarraySum(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 561. Array Partition I (Easy)
     * <p>
     * Assume that min[i] is the ith minimum of the array. Then there exists a pair (min[0], x). If
     * x != min[1], there exists a pair (min[1], y). Exchange x and min[1], then sum will be larger.
     * So the maximized group is (min[0], min[1]), ..., (min[2n-2], min[2n-1]).
     *
     * @see <a href="https://leetcode-cn.com/problems/array-partition-i/">Array Partition I</a>
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 562. Longest Line of Consecutive One in Matrix (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/longest-line-of-consecutive-one-in-matrix/">Longest
     * Line of Consecutive One in Matrix</a>
     */
    public int longestLine(int[][] mat) {
        // todo
        return 0;
    }

    /**
     * 563. Binary Tree Tilt (Easy)
     *
     * @see Solution1401#getLonelyNodes(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-tilt/">Binary Tree Tilt</a>
     */
    public int findTilt(TreeNode root) {
        return findTiltAndSum(root)[0];
    }

    /**
     * @return [sum of tilts, sum of nodes]
     */
    private int[] findTiltAndSum(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = findTiltAndSum(node.left);
        int[] right = findTiltAndSum(node.right);
        int tilt = Math.abs(left[1] - right[1]);
        return new int[]{tilt + left[0] + right[0], left[1] + right[1] + node.val};
    }

    /**
     * 564. Find the Closest Palindrome (Hard)
     *
     * @see Solution1801#nextPalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/find-the-closest-palindrome/">Find the Closest
     * Palindrome</a>
     */
    public String nearestPalindromic(String n) {
        // todo
        return "";
    }

    /**
     * 566. Reshape the Matrix (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/reshape-the-matrix/">Reshape the Matrix</a>
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int i = 0, j = 0;
        for (int[] nums : mat) {
            for (int num : nums) {
                res[i][j++] = num;
                if (j == c) {
                    i++;
                    j = 0;
                }
            }
        }
        return res;
    }

    /**
     * 567. Permutation in String (Medium)
     *
     * @see Solution1#minWindow(String, String)
     * @see Solution401#findAnagrams(String, String)
     * @see <a href="https://leetcode-cn.com/problems/permutation-in-string/">Permutation in
     * String</a>
     */
    public boolean checkInclusion(String s1, String s2) {
        // todo
        return false;
    }

    /**
     * 568. Maximum Vacation Days (Hard)
     *
     * @see Solution701#findCheapestPrice(int, int[][], int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/maximum-vacation-days/">Maximum Vacation
     * Days</a>
     */
    public int maxVacationDays(int[][] flights, int[][] days) {
        // todo
        return 0;
    }


    /**
     * 572. Subtree of Another Tree (Easy)
     *
     * @see Solution1#isSameTree(TreeNode, TreeNode)
     * @see Solution201#countUnivalSubtrees(TreeNode)
     * @see Solution501#findFrequentTreeSum(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/subtree-of-another-tree/">Subtree of Another
     * Tree</a>
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return root != null && (isSameTree(root, subRoot)
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot));
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        return p != null && q != null && p.val == q.val
            && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 573. Squirrel Simulation (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/squirrel-simulation/">Squirrel Simulation</a>
     */
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        // todo
        return 0;
    }


    /**
     * 575. Distribute Candies (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/distribute-candies/">Distribute Candies</a>
     */
    public int distributeCandies(int[] candies) {
        BitSet set = new BitSet(200001);
        for (int candy : candies) {
            set.set(candy + 100000);
        }
        return Math.min(set.cardinality(), candies.length / 2);
    }

    /**
     * 576. Out of Boundary Paths (Medium)
     *
     * @see Solution601#knightProbability(int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/out-of-boundary-paths/">Out of Boundary
     * Paths</a>
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // todo
        return 0;
    }


    /**
     * 581. Shortest Unsorted Continuous Subarray (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/">Shortest
     * Unsorted Continuous Subarray</a>
     */
    public int findUnsortedSubarray(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 582. Kill Process (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/kill-process/">Kill Process</a>
     */
    public int[] killProcess(int[] pid, int[] ppid, int kill) {
        // todo
        return new int[0];
    }

    /**
     * 583. Delete Operation for Two Strings (Medium)
     *
     * @see Solution1#minDistance(String, String)
     * @see Solution701#minimumDeleteSum(String, String)
     * @see Solution1101#longestCommonSubsequence(String, String)
     * @see <a href="https://leetcode-cn.com/problems/delete-operation-for-two-strings/">Delete
     * Operation for Two Strings</a>
     */
    public int minDistance(String word1, String word2) {
        // todo
        return 0;
    }


    /**
     * 587. Erect the Fence (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/erect-the-fence/">Erect the Fence</a>
     */
    public int[][] outerTrees(int[][] trees) {
        // todo
        return new int[0][0];
    }


    /**
     * 589. N-ary Tree Preorder Traversal (Easy)
     * <p>
     * todo iteration
     *
     * @see Solution101#preorderTraversal(TreeNode)
     * @see Solution401#levelOrder(int)
     * @see Solution501#postorder(Node)
     * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/">N-ary Tree
     * Preorder Traversal</a>
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            for (Node child : node.children) {
                preorder(child, list);
            }
        }
    }

    /**
     * 590. N-ary Tree Postorder Traversal (Easy)
     * <p>
     * todo iteration
     *
     * @see Solution101#postorderTraversal(TreeNode)
     * @see Solution401#levelOrder(int)
     * @see Solution501#preorder(Node)
     * @see Solution501#preorder(Node)
     * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/">N-ary Tree
     * Postorder Traversal</a>
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Node node, List<Integer> list) {
        if (node != null) {
            for (Node child : node.children) {
                postorder(child, list);
            }
            list.add(node.val);
        }
    }

    /**
     * 591. Tag Validator (Hard)
     *
     * @see Solution601#addBoldTag(String, String[])
     * @see <a href="https://leetcode-cn.com/problems/tag-validator/">Tag Validator</a>
     */
    public boolean isValid(String code) {
        // todo
        return false;
    }

    /**
     * 592. Fraction Addition and Subtraction (Medium)
     *
     * @see Solution601#solveEquation(String)
     * @see <a href="https://leetcode-cn.com/problems/fraction-addition-and-subtraction/">Fraction
     * Addition and Subtraction</a>
     */
    public String fractionAddition(String expression) {
        // todo
        return "";
    }

    /**
     * 593. Valid Square (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/valid-square/">Valid Square</a>
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // todo
        return false;
    }

    /**
     * 594. Longest Harmonious Subsequence (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/longest-harmonious-subsequence/">Longest
     * Harmonious Subsequence</a>
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        int lhs = 0;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            Integer fre = frequencies.get(entry.getKey() + 1);
            if (fre != null) {
                lhs = Math.max(lhs, fre + entry.getValue());
            }
        }
        return lhs;
    }


    /**
     * 598. Range Addition II (Easy)
     *
     * @see Solution301#getModifiedArray(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/range-addition-ii/">Range Addition II</a>
     */
    public int maxCount(int m, int n, int[][] ops) {
        int aMin = m, bMin = n;
        for (int[] op : ops) {
            if (op[0] < aMin) {
                aMin = op[0];
            }
            if (op[1] < bMin) {
                bMin = op[1];
            }
        }
        return aMin * bMin;
    }

    /**
     * 599. Minimum Index Sum of Two Lists (Easy)
     *
     * @see Solution101#getIntersectionNode(ListNode, ListNode)
     * @see <a href="https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/">Minimum Index
     * Sum of Two Lists</a>
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indices = new HashMap<>(list1.length);
        for (int i = list1.length - 1; i >= 0; i--) {
            indices.put(list1[i], i);
        }
        List<String> common = new ArrayList<>();
        int minSum = list1.length + list2.length;
        for (int i2 = list2.length - 1; i2 >= 0; i2--) {
            String s = list2[i2];
            Integer i1 = indices.get(s);
            if (i1 != null) {
                int sum = i1 + i2;
                if (sum < minSum) {
                    common.clear();
                    common.add(s);
                    minSum = sum;
                } else if (sum == minSum) {
                    common.add(s);
                }
            }
        }
        return common.toArray(new String[0]);
    }

    /**
     * 600. Non-negative Integers without Consecutive Ones (Hard)
     *
     * @see Solution101#rob(int[])
     * @see Solution201#rob(int[])
     * @see Solution401#findMaxForm(String[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/">Non-negative
     * Integers without Consecutive Ones</a>
     */
    public int findIntegers(int n) {
        // todo
        return 0;
    }

    /**
     * @author Kingen
     * @since 2021/6/19
     */
    static class Node {

        int val;
        List<Node> children;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}