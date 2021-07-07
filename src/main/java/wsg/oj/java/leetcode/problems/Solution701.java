package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * Solutions to problems No.701-No.800.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution701 extends Solution {

    int[] goods = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    /**
     * 701. Insert into a Binary Search Tree (Medium)
     *
     * @see Solution601#searchBST(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/">Insert into
     * a Binary Search Tree</a>
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // todo
        return new TreeNode();
    }

    /**
     * 702. Search in a Sorted Array of Unknown Size (Medium)
     *
     * @see Solution701#search(int[], int)
     * @see Solution1501#getIndex(int[])
     * @see <a href="https://leetcode-cn.com/problems/search-in-a-sorted-array-of-unknown-size/">Search
     * in a Sorted Array of Unknown Size</a>
     */
    public int search(int[] secret, int target) {
        // todo
        return 0;
    }


    /**
     * 704. Binary Search (Easy)
     *
     * @see Arrays#binarySearch(int[], int)
     * @see Solution1#searchInsert(int[], int)
     * @see Solution701#search(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/binary-search/">Binary Search</a>
     */
    public int searchII(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            if (midVal < target) {
                left = mid + 1;
            } else if (midVal > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 708. Insert into a Sorted Circular Linked List (Medium)
     *
     * @see Solution101#insertionSortList(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/">Insert
     * into a Sorted Circular Linked List</a>
     */
    public ListNode insert(ListNode head, int insertVal) {
        // todo
        return new ListNode();
    }

    /**
     * 709. To Lower Case (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/to-lower-case/">To Lower Case</a>
     */
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }


    /**
     * 711. Number of Distinct Islands II (Hard)
     *
     * @see Solution601#numDistinctIslands(int[][])
     * @see <a href="https://leetcode-cn.com/problems/number-of-distinct-islands-ii/">Number of
     * Distinct Islands II</a>
     */
    public int numDistinctIslands2(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 712. Minimum ASCII Delete Sum for Two Strings (Medium)
     *
     * @see Solution1#minDistance(String, String)
     * @see Solution201#lengthOfLIS(int[])
     * @see Solution501#minDistance(String, String)
     * @see <a href="https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/">Minimum
     * ASCII Delete Sum for Two Strings</a>
     */
    public int minimumDeleteSum(String s1, String s2) {
        // todo
        return 0;
    }

    /**
     * 713. Subarray Product Less Than K (Medium)
     *
     * @see Solution101#maxProduct(int[])
     * @see Solution301#maxSubArrayLen(int[], int)
     * @see Solution501#subarraySum(int[], int)
     * @see Solution1001#twoSumLessThanK(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/subarray-product-less-than-k/">Subarray
     * Product Less Than K</a>
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 714. Best Time to Buy and Sell Stock with Transaction Fee (Medium)
     *
     * @see Solution101#maxProfit(int[])
     * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">Best
     * Time to Buy and Sell Stock with Transaction Fee</a>
     */
    public int maxProfit(int[] prices, int fee) {
        // todo
        return 0;
    }


    /**
     * 717. 1-bit and 2-bit Characters (Easy)
     *
     * @see Solution1#grayCode(int)
     * @see <a href="https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/">1-bit and 2-bit
     * Characters</a>
     */
    public boolean isOneBitCharacter(int[] bits) {
        // count the number of contiguous 1 before the last 0
        int i = bits.length - 2;
        while (i >= 0 && bits[i] == 1) {
            i--;
        }
        return ((bits.length - i) & 1) == 0;
    }

    /**
     * 718. Maximum Length of Repeated Subarray (Medium)
     *
     * @see Solution201#minSubArrayLen(int, int[])
     * @see <a href="https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/">Maximum
     * Length of Repeated Subarray</a>
     */
    public int findLength(int[] nums1, int[] nums2) {
        // todo
        return 0;
    }

    /**
     * 719. Find K-th Smallest Pair Distance (Hard)
     *
     * @see Solution301#kSmallestPairs(int[], int[], int)
     * @see Solution301#kthSmallest(int[][], int)
     * @see Solution601#findClosestElements(int[], int, int)
     * @see Solution601#findKthNumber(int, int, int)
     * @see Solution701#kthSmallestPrimeFraction(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/">Find K-th
     * Smallest Pair Distance</a>
     */
    public int smallestDistancePair(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 720. Longest Word in Dictionary (Easy)
     *
     * @see Solution501#findLongestWord(String, String[])
     * @see MagicDictionary
     * @see Solution1801#longestWord(String[])
     * @see <a href="https://leetcode-cn.com/problems/longest-word-in-dictionary/">Longest Word in
     * Dictionary</a>
     */
    public String longestWord(String[] words) {
        // todo
        return "";
    }

    /**
     * 721. Accounts Merge (Medium)
     *
     * @see Solution601#findRedundantConnection(int[][])
     * @see Solution701#areSentencesSimilar(String[], String[], String[][])
     * @see Solution701#areSentencesSimilarTwo(String[], String[], String[][])
     * @see <a href="https://leetcode-cn.com/problems/accounts-merge/">Accounts Merge</a>
     */
    public String[][] accountsMerge(String[][] accounts) {
        // todo
        return new String[0][0];
    }

    /**
     * 722. Remove Comments (Medium)
     *
     * @see Solution301#deserialize(String)
     * @see Solution401#parseTernary(String)
     * @see <a href="https://leetcode-cn.com/problems/remove-comments/">Remove Comments</a>
     */
    public String[] removeComments(String[] source) {
        // todo
        return new String[0];
    }

    /**
     * 723. Candy Crush (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/candy-crush/">Candy Crush</a>
     */
    public int[][] candyCrush(int[][] board) {
        // todo
        return new int[0][0];
    }

    /**
     * 724. Find Pivot Index (Easy)
     *
     * @see Solution501#subarraySum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/find-pivot-index/">Find Pivot Index</a>
     */
    public int pivotIndex(int[] nums) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 1; i < nums.length; i++) {
            sumRight += nums[i];
        }
        int i = 0, end = nums.length - 1;
        while (i < end) {
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft += nums[i];
            i++;
            sumRight -= nums[i];
        }
        return sumLeft == sumRight ? i : -1;
    }

    /**
     * 725. Split Linked List in Parts (Medium)
     *
     * @see Solution1#rotateRight(ListNode, int)
     * @see Solution301#oddEvenList(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/split-linked-list-in-parts/">Split Linked List
     * in Parts</a>
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        // todo
        return new ListNode[0];
    }

    /**
     * 726. Number of Atoms (Hard)
     *
     * @see Solution301#decodeString(String)
     * @see Solution401#encode(String)
     * @see Solution701#evaluate(String)
     * @see <a href="https://leetcode-cn.com/problems/number-of-atoms/">Number of Atoms</a>
     */
    public String countOfAtoms(String formula) {
        // todo
        return "";
    }

    /**
     * 727. Minimum Window Subsequence (Hard)
     *
     * @see Solution1#minWindow(String, String)
     * @see Solution601#findLengthOfLCIS(int[])
     * @see <a href="https://leetcode-cn.com/problems/minimum-window-subsequence/">Minimum Window
     * Subsequence</a>
     */
    public String minWindow(String s1, String s2) {
        // todo
        return "";
    }

    /**
     * 728. Self Dividing Numbers (Easy)
     *
     * @see Solution501#checkPerfectNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/self-dividing-numbers/">Self Dividing
     * Numbers</a>
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDividingNumber(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }


    /**
     * 730. Count Different Palindromic Subsequences (Hard)
     *
     * @see Solution501#longestPalindromeSubseq(String)
     * @see <a href="https://leetcode-cn.com/problems/count-different-palindromic-subsequences/">Count
     * Different Palindromic Subsequences</a>
     */
    public int countPalindromicSubsequences(String s) {
        // todo
        return 0;
    }


    /**
     * 733. Flood Fill (Easy)
     *
     * @see Solution401#islandPerimeter(int[][])
     * @see <a href="https://leetcode-cn.com/problems/flood-fill/">Flood Fill</a>
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // todo
        return new int[0][0];
    }

    /**
     * 734. Sentence Similarity (Easy)
     *
     * @see Solution501#findCircleNum(int[][])
     * @see Solution701#accountsMerge(String[][])
     * @see Solution701#areSentencesSimilarTwo(String[], String[], String[][])
     * @see <a href="https://leetcode-cn.com/problems/sentence-similarity/">Sentence Similarity</a>
     */
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2,
        String[][] similarPairs) {
        // todo
        return false;
    }

    /**
     * 735. Asteroid Collision (Medium)
     *
     * @see Solution601#canPlaceFlowers(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/asteroid-collision/">Asteroid Collision</a>
     */
    public int[] asteroidCollision(int[] asteroids) {
        // todo
        return new int[0];
    }

    /**
     * 736. Parse Lisp Expression (Hard)
     *
     * @see Solution401#parseTernary(String)
     * @see Solution701#countOfAtoms(String)
     * @see Solution701#basicCalculatorIV(String, String[], int[])
     * @see <a href="https://leetcode-cn.com/problems/parse-lisp-expression/">Parse Lisp
     * Expression</a>
     */
    public int evaluate(String expression) {
        // todo
        return 0;
    }

    /**
     * 737. Sentence Similarity II (Medium)
     *
     * @see Solution501#findCircleNum(int[][])
     * @see Solution701#accountsMerge(String[][])
     * @see Solution701#areSentencesSimilar(String[], String[], String[][])
     * @see <a href="https://leetcode-cn.com/problems/sentence-similarity-ii/">Sentence Similarity
     * II</a>
     */
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2,
        String[][] similarPairs) {
        // todo
        return false;
    }

    /**
     * 738. Monotone Increasing Digits (Medium)
     *
     * @see Solution401#removeKdigits(String, int)
     * @see <a href="https://leetcode-cn.com/problems/monotone-increasing-digits/">Monotone
     * Increasing Digits</a>
     */
    public int monotoneIncreasingDigits(int n) {
        // todo
        return 0;
    }

    /**
     * 739. Daily Temperatures (Medium)
     *
     * @see Solution401#nextGreaterElement(int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/daily-temperatures/">Daily Temperatures</a>
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // todo
        return new int[0];
    }

    /**
     * 740. Delete and Earn (Medium)
     *
     * @see Solution101#rob(int[])
     * @see <a href="https://leetcode-cn.com/problems/delete-and-earn/">Delete and Earn</a>
     */
    public int deleteAndEarn(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 741. Cherry Pickup (Hard)
     *
     * @see Solution1#minPathSum(int[][])
     * @see Solution101#calculateMinimumHP(int[][])
     * @see <a href="https://leetcode-cn.com/problems/cherry-pickup/">Cherry Pickup</a>
     */
    public int cherryPickup(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 742. Closest Leaf in a Binary Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/closest-leaf-in-a-binary-tree/">Closest Leaf
     * in a Binary Tree</a>
     */
    public int findClosestLeaf(TreeNode root, int k) {
        // todo
        return 0;
    }

    /**
     * 743. Network Delay Time (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/network-delay-time/">Network Delay Time</a>
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // todo
        return 0;
    }

    /**
     * 744. Find Smallest Letter Greater Than Target (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/">Find
     * Smallest Letter Greater Than Target</a>
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }


    /**
     * 746. Min Cost Climbing Stairs (Easy)
     *
     * @see Solution1#climbStairs(int)
     * @see <a href="https://leetcode-cn.com/problems/min-cost-climbing-stairs/">Min Cost Climbing
     * Stairs</a>
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] sum = new int[len];
        sum[0] = cost[0];
        sum[1] = cost[1];
        for (int i = 2; i < len; i++) {
            sum[i] = Math.min(sum[i - 2] + cost[i], sum[i - 1] + cost[i]);
        }
        return Math.min(sum[len - 1], sum[len - 2]);
    }

    /**
     * 747. Largest Number At Least Twice of Others (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/">Largest
     * Number At Least Twice of Others</a>
     */
    public int dominantIndex(int[] nums) {
        int res = 0, max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > max && i != res) {
                return -1;
            }
        }
        return res;
    }

    /**
     * 748. Shortest Completing Word (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/shortest-completing-word/">Shortest Completing
     * Word</a>
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] frequency = new int[26];
        for (char ch : licensePlate.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                frequency[ch - 'a']++;
            } else if (ch >= 'A' && ch <= 'Z') {
                frequency[ch - 'A']++;
            }
        }
        String target = null;
        int len = 16;
        for (String word : words) {
            int[] copy = Arrays.copyOf(frequency, 26);
            if (isCompleted(word, copy) && word.length() < len) {
                target = word;
                len = word.length();
            }
        }
        return target;
    }

    private boolean isCompleted(String word, int[] frequency) {
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            frequency[i]--;
        }
        for (int i : frequency) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 749. Contain Virus (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/contain-virus/">Contain Virus</a>
     */
    public int containVirus(int[][] isInfected) {
        // todo
        return 0;
    }

    /**
     * 750. Number Of Corner Rectangles (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/number-of-corner-rectangles/">Number Of Corner
     * Rectangles</a>
     */
    public int countCornerRectangles(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 751. IP to CIDR (Medium)
     *
     * @see Solution1#restoreIpAddresses(String)
     * @see Solution401#validIPAddress(String)
     * @see <a href="https://leetcode-cn.com/problems/ip-to-cidr/">IP to CIDR</a>
     */
    public String[] ipToCIDR(String ip, int n) {
        // todo
        return new String[0];
    }

    /**
     * 752. Open the Lock (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/open-the-lock/">Open the Lock</a>
     */
    public int openLock(String[] deadends, String target) {
        // todo
        return 0;
    }

    /**
     * 753. Cracking the Safe (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/cracking-the-safe/">Cracking the Safe</a>
     */
    public String crackSafe(int n, int k) {
        // todo
        return "";
    }

    /**
     * 754. Reach a Number (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/reach-a-number/">Reach a Number</a>
     */
    public int reachNumber(int target) {
        // todo
        return 0;
    }

    /**
     * 755. Pour Water (Medium)
     *
     * @see Solution1#trap(int[])
     * @see <a href="https://leetcode-cn.com/problems/pour-water/">Pour Water</a>
     */
    public int[] pourWater(int[] heights, int volume, int k) {
        // todo
        return new int[0];
    }

    /**
     * 756. Pyramid Transition Matrix (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/pyramid-transition-matrix/">Pyramid Transition
     * Matrix</a>
     */
    public boolean pyramidTransition(String bottom, String[] allowed) {
        // todo
        return false;
    }

    /**
     * 757. Set Intersection Size At Least Two (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/set-intersection-size-at-least-two/">Set
     * Intersection Size At Least Two</a>
     */
    public int intersectionSizeTwo(int[][] intervals) {
        // todo
        return 0;
    }

    /**
     * 758. Bold Words in String (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/bold-words-in-string/">Bold Words in
     * String</a>
     */
    public String boldWords(String[] words, String s) {
        // todo
        return "";
    }

    /**
     * 759. Employee Free Time (Hard)
     *
     * @see Solution1#merge(int[][])
     * @see Solution901#intervalIntersection(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/employee-free-time/">Employee Free Time</a>
     */
    public int employeeFreeTime(int schedule) {
        // todo
        return 0;
    }

    /**
     * 760. Find Anagram Mappings (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-anagram-mappings/">Find Anagram
     * Mappings</a>
     */
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        // todo
        return new int[0];
    }

    /**
     * 761. Special Binary String (Hard)
     *
     * @see Solution601#checkValidString(String)
     * @see <a href="https://leetcode-cn.com/problems/special-binary-string/">Special Binary
     * String</a>
     */
    public String makeLargestSpecial(String s) {
        // todo
        return "";
    }

    /**
     * 762. Prime Number of Set Bits in Binary Representation (Easy)
     *
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/">Prime
     * Number of Set Bits in Binary Representation</a>
     */
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 763. Partition Labels (Medium)
     *
     * @see Solution1#merge(int[][])
     * @see <a href="https://leetcode-cn.com/problems/partition-labels/">Partition Labels</a>
     */
    public int[] partitionLabels(String s) {
        // todo
        return new int[0];
    }

    /**
     * 764. Largest Plus Sign (Medium)
     *
     * @see Solution201#maximalSquare(char[][])
     * @see <a href="https://leetcode-cn.com/problems/largest-plus-sign/">Largest Plus Sign</a>
     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // todo
        return 0;
    }

    /**
     * 765. Couples Holding Hands (Hard)
     *
     * @see Solution1#firstMissingPositive(int[])
     * @see Solution201#missingNumber(int[])
     * @see Solution801#kSimilarity(String, String)
     * @see <a href="https://leetcode-cn.com/problems/couples-holding-hands/">Couples Holding
     * Hands</a>
     */
    public int minSwapsCouples(int[] row) {
        // todo
        return 0;
    }

    /**
     * 766. Toeplitz Matrix (Easy)
     *
     * @see Solution401#validWordSquare(String[])
     * @see <a href="https://leetcode-cn.com/problems/toeplitz-matrix/">Toeplitz Matrix</a>
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // todo
        return false;
    }

    /**
     * 767. Reorganize String (Medium)
     *
     * @see Solution301#rearrangeString(String, int)
     * @see Solution601#leastInterval(char[], int)
     * @see <a href="https://leetcode-cn.com/problems/reorganize-string/">Reorganize String</a>
     */
    public String reorganizeString(String s) {
        // todo
        return "";
    }

    /**
     * 768. Max Chunks To Make Sorted II (Hard)
     *
     * @see Solution701#maxChunksToSorted(int[])
     * @see <a href="https://leetcode-cn.com/problems/max-chunks-to-make-sorted-ii/">Max Chunks To
     * Make Sorted II</a>
     */
    public int maxChunksToSorted(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 769. Max Chunks To Make Sorted (Medium)
     *
     * @see Solution701#maxChunksToSorted(int[])
     * @see <a href="https://leetcode-cn.com/problems/max-chunks-to-make-sorted/">Max Chunks To Make
     * Sorted</a>
     */
    public int maxChunksToSortedII(int[] arr) {
        // todo
        return 0;
    }

    /**
     * 770. Basic Calculator IV (Hard)
     *
     * @see Solution701#evaluate(String)
     * @see Solution701#calculate(String)
     * @see <a href="https://leetcode-cn.com/problems/basic-calculator-iv/">Basic Calculator IV</a>
     */
    public String[] basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        // todo
        return new String[0];
    }

    /**
     * 771. Jewels and Stones (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/jewels-and-stones/">Jewels and Stones</a>
     */
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean['z' - 'A' + 1];
        for (char ch : jewels.toCharArray()) {
            isJewel[ch - 'A'] = true;
        }
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (isJewel[ch - 'A']) {
                count++;
            }
        }
        return count;
    }

    /**
     * 772. Basic Calculator III (Hard)
     *
     * @see Solution201#calculate(String)
     * @see Solution201#calculate(String)
     * @see Solution701#basicCalculatorIV(String, String[], int[])
     * @see Solution1501#expTree(String)
     * @see <a href="https://leetcode-cn.com/problems/basic-calculator-iii/">Basic Calculator
     * III</a>
     */
    public int calculate(String s) {
        // todo
        return 0;
    }

    /**
     * 773. Sliding Puzzle (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/sliding-puzzle/">Sliding Puzzle</a>
     */
    public int slidingPuzzle(int[][] board) {
        // todo
        return 0;
    }

    /**
     * 774. Minimize Max Distance to Gas Station (Hard)
     *
     * @see Solution801#minEatingSpeed(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/minimize-max-distance-to-gas-station/">Minimize
     * Max Distance to Gas Station</a>
     */
    public double minmaxGasDist(int[] stations, int k) {
        // todo
        return 0.0;
    }

    /**
     * 775. Global and Local Inversions (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/global-and-local-inversions/">Global and Local
     * Inversions</a>
     */
    public boolean isIdealPermutation(int[] nums) {
        // todo
        return false;
    }

    /**
     * 776. Split BST (Medium)
     *
     * @see Solution401#deleteNode(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/split-bst/">Split BST</a>
     */
    public TreeNode[] splitBST(TreeNode root, int target) {
        // todo
        return new TreeNode[0];
    }

    /**
     * 777. Swap Adjacent in LR String (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/swap-adjacent-in-lr-string/">Swap Adjacent in
     * LR String</a>
     */
    public boolean canTransform(String start, String end) {
        // todo
        return false;
    }

    /**
     * 778. Swim in Rising Water (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/swim-in-rising-water/">Swim in Rising
     * Water</a>
     */
    public int swimInWater(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 779. K-th Symbol in Grammar (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/k-th-symbol-in-grammar/">K-th Symbol in
     * Grammar</a>
     */
    public int kthGrammar(int n, int k) {
        // todo
        return 0;
    }

    /**
     * 780. Reaching Points (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/reaching-points/">Reaching Points</a>
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // todo
        return false;
    }

    /**
     * 781. Rabbits in Forest (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/rabbits-in-forest/">Rabbits in Forest</a>
     */
    public int numRabbits(int[] answers) {
        // todo
        return 0;
    }

    /**
     * 782. Transform to Chessboard (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/transform-to-chessboard/">Transform to
     * Chessboard</a>
     */
    public int movesToChessboard(int[][] board) {
        // todo
        return 0;
    }

    /**
     * 783. Minimum Distance Between BST Nodes (Easy) (Same as {@link Solution501#getMinimumDifference(TreeNode)})
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/">Minimum
     * Distance Between BST Nodes</a>
     */
    public int minDiffInBST(TreeNode root) {
        return 0;
    }

    /**
     * 784. Letter Case Permutation (Medium)
     *
     * @see Solution1#subsets(int[])
     * @see Solution1001#expand(String)
     * @see <a href="https://leetcode-cn.com/problems/letter-case-permutation/">Letter Case
     * Permutation</a>
     */
    public String[] letterCasePermutation(String s) {
        // todo
        return new String[0];
    }

    /**
     * 785. Is Graph Bipartite? (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/is-graph-bipartite/">Is Graph Bipartite?</a>
     */
    public boolean isBipartite(int[][] graph) {
        // todo
        return false;
    }

    /**
     * 786. K-th Smallest Prime Fraction (Hard)
     *
     * @see Solution301#kthSmallest(int[][], int)
     * @see Solution601#findKthNumber(int, int, int)
     * @see Solution701#smallestDistancePair(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/">K-th Smallest
     * Prime Fraction</a>
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // todo
        return new int[0];
    }

    /**
     * 787. Cheapest Flights Within K Stops (Medium)
     *
     * @see Solution501#maxVacationDays(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/">Cheapest
     * Flights Within K Stops</a>
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // todo
        return 0;
    }

    /**
     * 788. Rotated Digits (Easy)
     * <p>
     * Assumes that f(n) is the good numbers from 1 to 10^n. Then
     * <i>f(n+1) = 3f(n) + 4 * 7^n</i>
     *
     * @see <a href="https://leetcode-cn.com/problems/rotated-digits/">Rotated Digits</a>
     */
    public int rotatedDigits(int n) {
        int temp = n, left = 1, base = 0, power = 1;
        while (temp > 9) {
            temp /= 10;
            left *= 10;
            base = base * 3 + 4 * power;
            power *= 7;
        }
        int res = 0;
        for (int i = left + 1; i <= n; i++) {
            if (isGood(i)) {
                res++;
            }
        }
        return res + base;
    }

    private boolean isGood(int num) {
        boolean flag = false;
        while (num > 0) {
            int digit = num % 10;
            if (goods[digit] < 0) {
                return false;
            } else if (goods[digit] > 0) {
                flag = true;
            }
            num /= 10;
        }
        return flag;
    }

    /**
     * 789. Escape The Ghosts (Medium)
     *
     * @see Solution1701#canMouseWin(String[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/escape-the-ghosts/">Escape The Ghosts</a>
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // todo
        return false;
    }

    /**
     * 790. Domino and Tromino Tiling (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/domino-and-tromino-tiling/">Domino and Tromino
     * Tiling</a>
     */
    public int numTilings(int n) {
        // todo
        return 0;
    }

    /**
     * 791. Custom Sort String (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/custom-sort-string/">Custom Sort String</a>
     */
    public String customSortString(String order, String str) {
        // todo
        return "";
    }

    /**
     * 792. Number of Matching Subsequences (Medium)
     *
     * @see Solution301#isSubsequence(String, String)
     * @see Solution1001#shortestWay(String, String)
     * @see <a href="https://leetcode-cn.com/problems/number-of-matching-subsequences/">Number of
     * Matching Subsequences</a>
     */
    public int numMatchingSubseq(String s, String[] words) {
        // todo
        return 0;
    }

    /**
     * 793. Preimage Size of Factorial Zeroes Function (Hard)
     *
     * @see Solution101#trailingZeroes(int)
     * @see <a href="https://leetcode-cn.com/problems/preimage-size-of-factorial-zeroes-function/">Preimage
     * Size of Factorial Zeroes Function</a>
     */
    public int preimageSizeFZF(int k) {
        // todo
        return 0;
    }

    /**
     * 794. Valid Tic-Tac-Toe State (Medium)
     *
     * @see TicTacToe
     * @see <a href="https://leetcode-cn.com/problems/valid-tic-tac-toe-state/">Valid Tic-Tac-Toe
     * State</a>
     */
    public boolean validTicTacToe(String[] board) {
        // todo
        return false;
    }

    /**
     * 795. Number of Subarrays with Bounded Maximum (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/">Number
     * of Subarrays with Bounded Maximum</a>
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // todo
        return 0;
    }

    /**
     * 796. Rotate String (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/rotate-string/">Rotate String</a>
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int len = goal.length();
        if (len == 0) {
            return true;
        }
        return (goal + goal).substring(1, 2 * len - 1).contains(s);
    }

    /**
     * 797. All Paths From Source to Target (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/all-paths-from-source-to-target/">All Paths
     * From Source to Target</a>
     */
    public int[][] allPathsSourceTarget(int[][] graph) {
        // todo
        return new int[0][0];
    }

    /**
     * 798. Smallest Rotation with Highest Score (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/">Smallest
     * Rotation with Highest Score</a>
     */
    public int bestRotation(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 799. Champagne Tower (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/champagne-tower/">Champagne Tower</a>
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        // todo
        return 0.0;
    }

    /**
     * 800. Similar RGB Color (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/similar-rgb-color/">Similar RGB Color</a>
     */
    public String similarRGB(String color) {
        // todo
        return "";
    }
}