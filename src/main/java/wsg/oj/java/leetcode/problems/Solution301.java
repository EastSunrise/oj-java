package wsg.oj.java.leetcode.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.impl.NumArray;

/**
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution301 extends Solution {

    /**
     * 301. Remove Invalid Parentheses (Hard)
     *
     * @see Solution1#isValid(String)
     * @see <a href="https://leetcode-cn.com/problems/remove-invalid-parentheses/">Remove Invalid
     * Parentheses</a>
     */
    public String[] removeInvalidParentheses(String s) {
        // todo
        return new String[0];
    }

    /**
     * 302. Smallest Rectangle Enclosing Black Pixels (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/smallest-rectangle-enclosing-black-pixels/">Smallest
     * Rectangle Enclosing Black Pixels</a>
     */
    public int minArea(char[][] image, int x, int y) {
        // todo
        return 0;
    }


    /**
     * 305. Number of Islands II (Hard)
     *
     * @see Solution101#numIslands(char[][])
     * @see <a href="https://leetcode-cn.com/problems/number-of-islands-ii/">Number of Islands
     * II</a>
     */
    public int[] numIslands2(int m, int n, int[][] positions) {
        // todo
        return new int[0];
    }

    /**
     * 306. Additive Number (Medium)
     *
     * @see #DFS
     * @see BigInteger
     * @see Solution801#splitIntoFibonacci(String)
     * @see <a href="https://leetcode-cn.com/problems/additive-number/">Additive Number</a>
     */
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len <= 2) {
            return false;
        }
        char[] chars = num.toCharArray();
        for (int b = 1; b < len; b++) {
            for (int c = b + 1; c < len; c++) {
                if (isAdditiveNumber(chars, 0, b, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(char[] chars, int a, int b, int c) {
        if ((chars[a] == '0' && b - a > 1) || (chars[b] == '0' && c - b > 1)) {
            // leading zeros
            return false;
        }
        int cLen = Math.max(b - a, c - b);
        if (c + cLen > chars.length) {
            // not enough chars left
            return false;
        }
        int[] temp = new int[cLen];
        int i = b - 1, j = c - 1, k = cLen - 1, carry = 0;
        while (i >= a && j >= b) {
            int sum = chars[i--] - '0' + chars[j--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        while (i >= a) {
            int sum = chars[i--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        while (j >= b) {
            int sum = +chars[j--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        k = c;
        if (carry > 0) {
            if (chars[k++] - '0' != carry) {
                return false;
            }
        }
        for (int digit : temp) {
            if (chars[k++] - '0' != digit) {
                return false;
            }
        }
        if (k == chars.length) {
            return true;
        }
        return isAdditiveNumber(chars, b, c, k);
    }


    /**
     * 309. Best Time to Buy and Sell Stock with Cooldown (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see #TIME_N
     * @see #SPACE_N
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfitII(int[])
     * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Best
     * Time to Buy and Sell Stock with Cooldown</a>
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        // be holding a stock after i days
        int[] holding = new int[len];
        // be cooldown after i days
        int[] cooldown = new int[len];
        // not hold a stock and not cooldown after i days
        int[] free = new int[len];
        holding[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            holding[i] = Math.max(holding[i - 1], free[i - 1] - prices[i]);
            cooldown[i] = holding[i - 1] + prices[i];
            free[i] = Math.max(free[i - 1], cooldown[i - 1]);
        }
        return Math.max(cooldown[len - 1], free[len - 1]);
    }

    /**
     * 310. Minimum Height Trees (Medium)
     * <p>
     * todo
     *
     * @see Solution201#canFinish(int, int[][])
     * @see Solution201#findOrder(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/minimum-height-trees/">Minimum Height
     * Trees</a>
     */
    public int[] findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        // distances[i]: the distance between i and a given key
        int[] distances = new int[n];
        distances[0] = 1;
        // find one side of the longest path
        int left = findFurthest(map, 0, distances);
        Arrays.fill(distances, 0);
        distances[left] = 1;
        // find the other side of the longest path
        int right = findFurthest(map, left, distances);
        Arrays.fill(distances, 0);
        // find the longest path
        List<Integer> longestPath = new ArrayList<>();
        findPath(map, longestPath, left, right, distances);
        int mid = longestPath.size() / 2;
        if ((longestPath.size() & 1) == 0) {
            return new int[]{longestPath.get(mid - 1), longestPath.get(mid)};
        } else {
            return new int[]{longestPath.get(mid)};
        }
    }

    private int findFurthest(Map<Integer, List<Integer>> edges, int target, int[] distances) {
        int furthest = target;
        for (int vertex : edges.get(target)) {
            if (distances[vertex] == 0) {
                distances[vertex] = distances[target] + 1;
                int res = findFurthest(edges, vertex, distances);
                if (distances[res] > distances[furthest]) {
                    furthest = res;
                }
            }
        }
        return furthest;
    }

    private boolean findPath(Map<Integer, List<Integer>> edges, List<Integer> path, int cur,
        int target, int[] visited) {
        if (visited[cur] == 1) {
            return false;
        }
        if (cur == target) {
            path.add(cur);
            return true;
        }
        visited[cur] = 1;
        path.add(cur);
        for (int vertex : edges.get(cur)) {
            if (findPath(edges, path, vertex, target, visited)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * 311. Sparse Matrix Multiplication (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/sparse-matrix-multiplication/">Sparse Matrix
     * Multiplication</a>
     */
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        // todo
        return new int[0][0];
    }

    /**
     * 312. Burst Balloons (Hard)
     *
     * @see Solution901#mergeStones(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/burst-balloons/">Burst Balloons</a>
     */
    public int maxCoins(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 313. Super Ugly Number (Medium)
     *
     * @see Solution201#nthUglyNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/super-ugly-number/">Super Ugly Number</a>
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] indices = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = primes[0] * dp[indices[0]];
            int idx = 0;
            for (int p = 1; p < indices.length; p++) {
                int next = primes[p] * dp[indices[p]];
                if (next < dp[i]) {
                    dp[i] = next;
                    idx = p;
                }
            }
            indices[idx]++;
            if (dp[i] == dp[i - 1]) {
                i--;
            }
        }
        return dp[n - 1];
    }

    /**
     * 314. Binary Tree Vertical Order Traversal (Medium)
     *
     * @see Solution101#levelOrder(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-vertical-order-traversal/">Binary
     * Tree Vertical Order Traversal</a>
     */
    public int[][] verticalOrder(TreeNode root) {
        // todo
        return new int[0][0];
    }

    /**
     * 315. Count of Smaller Numbers After Self (Hard)
     *
     * @see Solution301#countRangeSum(int[], int, int)
     * @see Solution401#reconstructQueue(int[][])
     * @see Solution401#reversePairs(int[])
     * @see Solution1301#smallerNumbersThanCurrent(int[])
     * @see <a href="https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/">Count of
     * Smaller Numbers After Self</a>
     */
    public int[] countSmaller(int[] nums) {
        // todo
        return new int[0];
    }

    /**
     * 316. Remove Duplicate Letters (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/remove-duplicate-letters/">Remove Duplicate
     * Letters</a>
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] added = new boolean[26];
        int[] remaining = new int[26];
        for (char ch : s.toCharArray()) {
            remaining[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            remaining[idx]--;
            if (added[idx]) {
                // since the stack is increasing except the distinct ones
                // ignore this one of the duplicate character
                continue;
            }
            // think of the top of the stack: x
            // if there is another x after c, choose which x to be removed
            // if x>c, remove this x since x+c > c+x
            while (!stack.isEmpty() && remaining[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                added[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            added[idx] = true;
        }
        StringBuilder builder = new StringBuilder(stack.size());
        for (Character ch : stack) {
            builder.append(ch);
        }
        return builder.toString();
    }

    /**
     * 317. Shortest Distance from All Buildings (Hard)
     *
     * @see Solution201#wallsAndGates(int[][])
     * @see Solution201#minTotalDistance(int[][])
     * @see Solution1101#maxDistance(int[][])
     * @see <a href="https://leetcode-cn.com/problems/shortest-distance-from-all-buildings/">Shortest
     * Distance from All Buildings</a>
     */
    public int shortestDistance(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 318. Maximum Product of Word Lengths (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/maximum-product-of-word-lengths/">Maximum
     * Product of Word Lengths</a>
     */
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] hashes = new int[len];
        for (int i = 0; i < len; i++) {
            for (char ch : words[i].toCharArray()) {
                hashes[i] |= 1 << (ch - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if ((hashes[i] & hashes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    /**
     * 319. Bulb Switcher (Medium)
     *
     * @see Solution601#flipLights(int, int)
     * @see Solution901#minKBitFlips(int[], int)
     * @see Solution1301#numTimesAllBlue(int[])
     * @see <a href="https://leetcode-cn.com/problems/bulb-switcher/">Bulb Switcher</a>
     */
    public int bulbSwitch(int n) {
        // the count of switching ith bulb is represented as the count of factors of the number i
        // the bulb will be on if and only if the count of factors is odd
        // which means the number i is a square
        // so find the count of squares within n
        return (int) Math.sqrt(n);
    }

    /**
     * 320. Generalized Abbreviation (Medium)
     *
     * @see Solution1#subsets(int[])
     * @see ValidWordAbbr
     * @see Solution401#minAbbreviation(String, String[])
     * @see <a href="https://leetcode-cn.com/problems/generalized-abbreviation/">Generalized
     * Abbreviation</a>
     */
    public String[] generateAbbreviations(String word) {
        // todo
        return new String[0];
    }

    /**
     * 321. Create Maximum Number (Hard)
     *
     * @see Solution401#removeKdigits(String, int)
     * @see Solution601#maximumSwap(int)
     * @see <a href="https://leetcode-cn.com/problems/create-maximum-number/">Create Maximum
     * Number</a>
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // todo
        return new int[0];
    }

    /**
     * 323. Number of Connected Components in an Undirected Graph (Medium)
     *
     * @see Solution101#numIslands(char[][])
     * @see Solution201#validTree(int, int[][])
     * @see Solution501#findCircleNum(int[][])
     * @see <a href="https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph/">Number
     * of Connected Components in an Undirected Graph</a>
     */
    public int countComponents(int n, int[][] edges) {
        // todo
        return 0;
    }

    /**
     * 325. Maximum Size Subarray Sum Equals k (Medium)
     *
     * @see Solution201#minSubArrayLen(int, int[])
     * @see NumArray
     * @see Solution501#findMaxLength(int[])
     * @see Solution701#numSubarrayProductLessThanK(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k/">Maximum
     * Size Subarray Sum Equals k</a>
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 326. Power of Three (Easy)
     *
     * @see Solution201#isPowerOfTwo(int)
     * @see Solution301#isPowerOfFour(int)
     * @see Solution1701#checkPowersOfThree(int)
     * @see <a href="https://leetcode-cn.com/problems/power-of-three/">Power of Three</a>
     */
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 327. Count of Range Sum (Hard)
     *
     * @see Solution301#countSmaller(int[])
     * @see Solution401#reversePairs(int[])
     * @see <a href="https://leetcode-cn.com/problems/count-of-range-sum/">Count of Range Sum</a>
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        // todo
        return 0;
    }

    /**
     * 329. Longest Increasing Path in a Matrix (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/">Longest
     * Increasing Path in a Matrix</a>
     */
    public int longestIncreasingPath(int[][] matrix) {
        // todo
        return 0;
    }

    /**
     * 330. Patching Array (Hard)
     *
     * @see Solution1701#getMaximumConsecutive(int[])
     * @see <a href="https://leetcode-cn.com/problems/patching-array/">Patching Array</a>
     */
    public int minPatches(int[] nums, int n) {
        // todo
        return 0;
    }

    /**
     * 333. Largest BST Subtree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-bst-subtree/">Largest BST Subtree</a>
     */
    public int largestBSTSubtree(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 334. Increasing Triplet Subsequence (Medium)
     *
     * @see Solution201#lengthOfLIS(int[])
     * @see <a href="https://leetcode-cn.com/problems/increasing-triplet-subsequence/">Increasing
     * Triplet Subsequence</a>
     */
    public boolean increasingTriplet(int[] nums) {
        // todo
        return false;
    }

    /**
     * 335. Self Crossing (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/self-crossing/">Self Crossing</a>
     */
    public boolean isSelfCrossing(int[] distance) {
        // todo
        return false;
    }

    /**
     * 336. Palindrome Pairs (Hard)
     *
     * @see Solution1#longestPalindrome(String)
     * @see Solution201#shortestPalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/palindrome-pairs/">Palindrome Pairs</a>
     */
    public int[][] palindromePairs(String[] words) {
        // todo
        return new int[0][0];
    }

    /**
     * 338. Counting Bits (Easy)
     *
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/counting-bits/">Counting Bits</a>
     */
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        int start = 1;
        while (start <= n) {
            int maxLen = start;
            counts[start++] = 1;
            for (int len = 1; len < maxLen; len *= 2) {
                for (int i = 0; i < len; i++) {
                    if (start > n) {
                        return counts;
                    }
                    counts[start] = counts[start - len] + 1;
                    start++;
                }
            }
        }
        return counts;
    }

    /**
     * 338.2 Counting Bits (Easy) (Bit)
     */
    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = res[i >> 1] + (i % 2);
        }
        return res;
    }

    /**
     * 340. Longest Substring with At Most K Distinct Characters (Medium)
     *
     * @see Solution1#lengthOfLongestSubstring(String)
     * @see Solution101#lengthOfLongestSubstringTwoDistinct(String)
     * @see Solution401#characterReplacement(String, int)
     * @see Solution901#subarraysWithKDistinct(int[], int)
     * @see Solution1001#longestOnes(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/">Longest
     * Substring with At Most K Distinct Characters</a>
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // todo
        return 0;
    }

    /**
     * 342. Power of Four (Easy)
     *
     * @see Solution201#isPowerOfTwo(int)
     * @see Solution201#isPowerOfTwo2(int)
     * @see Solution301#isPowerOfThree(int)
     * @see <a href="https://leetcode-cn.com/problems/power-of-four/">Power of Four</a>
     */
    public boolean isPowerOfFour(int n) {
        // even not power of 2
        if (n < 1 || (n & (n - 1)) != 0) {
            return false;
        }
        // a power of 2 = (3-1)^n = 3k + (-1)^n
        return n % 3 == 1;
    }

    /**
     * 343. Integer Break (Medium)
     *
     * @see Solution1801#maxNiceDivisors(int)
     * @see <a href="https://leetcode-cn.com/problems/integer-break/">Integer Break</a>
     */
    public int integerBreak(int n) {
        // todo
        return 0;
    }

    /**
     * 344. Reverse String (Easy)
     *
     * @see Solution301#reverseVowels(String)
     * @see Solution501#reverseStr(String, int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-string/">Reverse String</a>
     */
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    /**
     * 345. Reverse Vowels of a String (Easy)
     *
     * @see Solution301#reverseString(char[])
     * @see Solution1101#removeVowels(String)
     * @see <a href="https://leetcode-cn.com/problems/reverse-vowels-of-a-string/">Reverse Vowels of
     * a String</a>
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && notVowel(chars[left])) {
                left++;
            }
            while (left < right && notVowel(chars[right])) {
                right--;
            }
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    private boolean notVowel(char ch) {
        if (ch > 'U') {
            ch -= 32;
        }
        return ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U';
    }


    /**
     * 347. Top K Frequent Elements (Medium)
     *
     * @see Solution201#findKthLargest(int[], int)
     * @see Solution401#frequencySort(String)
     * @see Solution601#isPossible(int[])
     * @see Solution601#topKFrequent(String[], int)
     * @see Solution901#kClosest(int[][], int)
     * @see Solution1701#sortFeatures(String[], String[])
     * @see <a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">Top K Frequent
     * Elements</a>
     */
    public int[] topKFrequent(int[] nums, int k) {
        // todo
        return new int[0];
    }


    /**
     * 349. Intersection of Two Arrays (Easy)
     *
     * @see Solution301#intersect(int[], int[])
     * @see Solution1201#arraysIntersection(int[], int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays/">Intersection of
     * Two Arrays</a>
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (Integer value : set1) {
            res[i++] = value;
        }
        return res;
    }

    /**
     * 350. Intersection of Two Arrays II (Easy)
     *
     * @see Solution301#intersection(int[], int[])
     * @see Solution1001#commonChars(String[])
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/">Intersection
     * of Two Arrays II</a>
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] frequency1 = new int[1001];
        for (int num : nums1) {
            frequency1[num]++;
        }
        int[] frequency2 = new int[1001];
        for (int num : nums2) {
            frequency2[num]++;
        }
        int len = 0;
        for (int i = 0; i < 1001; i++) {
            frequency1[i] = Math.min(frequency1[i], frequency2[i]);
            len += frequency1[i];
        }
        int[] res = new int[len];
        int i = 0;
        for (int j = 0; j < 1001; j++) {
            Arrays.fill(res, i, i + frequency1[j], j);
            i += frequency1[j];
        }
        return res;
    }

    /**
     * 351. Android Unlock Patterns (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/android-unlock-patterns/">Android Unlock
     * Patterns</a>
     */
    public int numberOfPatterns(int m, int n) {
        // todo
        return 0;
    }


    /**
     * 354. Russian Doll Envelopes (Hard)
     *
     * @see Solution201#lengthOfLIS(int[])
     * @see <a href="https://leetcode-cn.com/problems/russian-doll-envelopes/">Russian Doll
     * Envelopes</a>
     */
    public int maxEnvelopes(int[][] envelopes) {
        // todo
        return 0;
    }


    /**
     * 356. Line Reflection (Medium)
     *
     * @see Solution101#maxPoints(int[][])
     * @see Solution401#numberOfBoomerangs(int[][])
     * @see <a href="https://leetcode-cn.com/problems/line-reflection/">Line Reflection</a>
     */
    public boolean isReflected(int[][] points) {
        // todo
        return false;
    }

    /**
     * 357. Count Numbers with Unique Digits (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/count-numbers-with-unique-digits/">Count
     * Numbers with Unique Digits</a>
     */
    public int countNumbersWithUniqueDigits(int n) {
        // todo
        return 0;
    }

    /**
     * 358. Rearrange String k Distance Apart (Hard)
     *
     * @see Solution601#leastInterval(char[], int)
     * @see Solution701#reorganizeString(String)
     * @see <a href="https://leetcode-cn.com/problems/rearrange-string-k-distance-apart/">Rearrange
     * String k Distance Apart</a>
     */
    public String rearrangeString(String s, int k) {
        // todo
        return "";
    }


    /**
     * 360. Sort Transformed Array (Medium)
     *
     * @see Solution901#sortedSquares(int[])
     * @see <a href="https://leetcode-cn.com/problems/sort-transformed-array/">Sort Transformed
     * Array</a>
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // todo
        return new int[0];
    }

    /**
     * 361. Bomb Enemy (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/bomb-enemy/">Bomb Enemy</a>
     */
    public int maxKilledEnemies(char[][] grid) {
        // todo
        return 0;
    }


    /**
     * 363. Max Sum of Rectangle No Larger Than K (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/">Max
     * Sum of Rectangle No Larger Than K</a>
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // todo
        return 0;
    }

    /**
     * 365. Water and Jug Problem (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/water-and-jug-problem/">Water and Jug
     * Problem</a>
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // todo
        return false;
    }

    /**
     * 366. Find Leaves of Binary Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-leaves-of-binary-tree/">Find Leaves of
     * Binary Tree</a>
     */
    public int[][] findLeaves(TreeNode root) {
        // todo
        return new int[0][0];
    }

    /**
     * 367. Valid Perfect Square (Easy)
     *
     * @see Solution1#mySqrt(int)
     * @see Solution601#judgeSquareSum(int)
     * @see <a href="https://leetcode-cn.com/problems/valid-perfect-square/">Valid Perfect
     * Square</a>
     */
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left < right) {
            right = (left + right) >> 1;
            left = num / right;
        }
        return right * right == num;
    }

    /**
     * 368. Largest Divisible Subset (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-divisible-subset/">Largest Divisible
     * Subset</a>
     */
    public int[] largestDivisibleSubset(int[] nums) {
        // todo
        return new int[0];
    }

    /**
     * 369. Plus One Linked List (Medium)
     *
     * @see Solution1#plusOne(int[])
     * @see <a href="https://leetcode-cn.com/problems/plus-one-linked-list/">Plus One Linked
     * List</a>
     */
    public ListNode plusOne(ListNode head) {
        // todo
        return new ListNode();
    }

    /**
     * 370. Range Addition (Medium)
     *
     * @see Solution501#maxCount(int, int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/range-addition/">Range Addition</a>
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // todo
        return new int[0];
    }

    /**
     * 371. Sum of Two Integers (Medium)
     *
     * @see Solution1#addTwoNumbers(ListNode, ListNode)
     * @see <a href="https://leetcode-cn.com/problems/sum-of-two-integers/">Sum of Two Integers</a>
     */
    public int getSum(int a, int b) {
        // todo
        return 0;
    }

    /**
     * 372. Super Pow (Medium)
     *
     * @see Solution1#myPow(double, int)
     * @see <a href="https://leetcode-cn.com/problems/super-pow/">Super Pow</a>
     */
    public int superPow(int a, int[] b) {
        // todo
        return 0;
    }

    /**
     * 373. Find K Pairs with Smallest Sums (Medium)
     *
     * @see Solution301#kthSmallest(int[][], int)
     * @see Solution701#smallestDistancePair(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/">Find K Pairs
     * with Smallest Sums</a>
     */
    public int[][] kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // todo
        return new int[0][0];
    }

    /**
     * 374. Guess Number Higher or Lower (Easy)
     *
     * @see Solution201#firstBadVersion(int)
     * @see Solution301#getMoneyAmount(int)
     * @see Solution601#findClosestElements(int[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower/">Guess Number
     * Higher or Lower</a>
     */
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int res = guess(mid);
            if (res < 0) {
                high = mid - 1;
            } else if (res > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return Integer.compare(num, 6);
    }

    /**
     * 375. Guess Number Higher or Lower II (Medium)
     *
     * @see Solution201#canWin(String)
     * @see Solution301#guessNumber(int)
     * @see Solution401#canIWin(int, int)
     * @see Solution601#findClosestElements(int[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/">Guess Number
     * Higher or Lower II</a>
     */
    public int getMoneyAmount(int n) {
        // todo
        return 0;
    }

    /**
     * 376. Wiggle Subsequence (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/wiggle-subsequence/">Wiggle Subsequence</a>
     */
    public int wiggleMaxLength(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 377. Combination Sum IV (Medium)
     *
     * @see Solution1#combinationSum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/combination-sum-iv/">Combination Sum IV</a>
     */
    public int combinationSum4(int[] nums, int target) {
        // todo
        return 0;
    }

    /**
     * 378. Kth Smallest Element in a Sorted Matrix (Medium)
     *
     * @see Solution301#kSmallestPairs(int[], int[], int)
     * @see Solution601#findKthNumber(int, int, int)
     * @see Solution701#smallestDistancePair(int[], int)
     * @see Solution701#kthSmallestPrimeFraction(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/">Kth
     * Smallest Element in a Sorted Matrix</a>
     */
    public int kthSmallest(int[][] matrix, int k) {
        // todo
        return 0;
    }


    /**
     * 383. Ransom Note (Easy)
     *
     * @see Solution601#minStickers(String[], String)
     * @see <a href="https://leetcode-cn.com/problems/ransom-note/">Ransom Note</a>
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counts = new int[26];
        char[] ms = magazine.toCharArray();
        for (char ch : ms) {
            counts[ch - 'a']++;
        }
        char[] rs = ransomNote.toCharArray();
        for (char ch : rs) {
            if (counts[ch - 'a'] == 0) {
                return false;
            } else {
                counts[ch - 'a']--;
            }
        }
        return true;
    }


    /**
     * 386. Lexicographical Numbers (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/lexicographical-numbers/">Lexicographical
     * Numbers</a>
     */
    public int[] lexicalOrder(int n) {
        // todo
        return new int[0];
    }

    /**
     * 387. First Unique Character in a String (Easy)
     *
     * @see Solution401#frequencySort(String)
     * @see <a href="https://leetcode-cn.com/problems/first-unique-character-in-a-string/">First
     * Unique Character in a String</a>
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        // [i][0]: count of char i+'a', [i][1]: first index of char i+'a'
        int[][] counts = new int[26][2];
        for (int i = chars.length - 1; i >= 0; i--) {
            int ch = chars[i] - 'a';
            counts[ch][0]++;
            counts[ch][1] = i;
        }
        int first = chars.length;
        for (int[] count : counts) {
            if (count[0] == 1 && count[1] < first) {
                first = count[1];
            }
        }
        return first == chars.length ? -1 : first;
    }

    /**
     * 388. Longest Absolute File Path (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/longest-absolute-file-path/">Longest Absolute
     * File Path</a>
     */
    public int lengthLongestPath(String input) {
        // todo
        return 0;
    }

    /**
     * 389. Find the Difference (Easy)
     *
     * @see Solution101#singleNumber(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-the-difference/">Find the Difference</a>
     */
    public char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        int sum = 0;
        for (char c : sChars) {
            sum ^= c;
        }
        for (char c : tChars) {
            sum ^= c;
        }
        return (char) sum;
    }

    /**
     * 390. Elimination Game (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/elimination-game/">Elimination Game</a>
     */
    public int lastRemaining(int n) {
        // todo
        return 0;
    }

    /**
     * 391. Perfect Rectangle (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/perfect-rectangle/">Perfect Rectangle</a>
     */
    public boolean isRectangleCover(int[][] rectangles) {
        // todo
        return false;
    }

    /**
     * 392. Is Subsequence (Easy)
     *
     * @see Solution701#numMatchingSubseq(String, String[])
     * @see Solution1001#shortestWay(String, String)
     * @see <a href="https://leetcode-cn.com/problems/is-subsequence/">Is Subsequence</a>
     */
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int si = sChars.length - 1, ti = tChars.length - 1;
        while (si >= 0 && ti >= 0) {
            if (sChars[si] == tChars[ti]) {
                si--;
            }
            ti--;
        }
        return si < 0;
    }

    /**
     * 393. UTF-8 Validation (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/utf-8-validation/">UTF-8 Validation</a>
     */
    public boolean validUtf8(int[] data) {
        // todo
        return false;
    }

    /**
     * 394. Decode String (Medium)
     *
     * @see Solution401#encode(String)
     * @see Solution701#countOfAtoms(String)
     * @see Solution1001#expand(String)
     * @see <a href="https://leetcode-cn.com/problems/decode-string/">Decode String</a>
     */
    public String decodeString(String s) {
        // todo
        return "";
    }

    /**
     * 395. Longest Substring with At Least K Repeating Characters (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/">Longest
     * Substring with At Least K Repeating Characters</a>
     */
    public int longestSubstring(String s, int k) {
        // todo
        return 0;
    }

    /**
     * 396. Rotate Function (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/rotate-function/">Rotate Function</a>
     */
    public int maxRotateFunction(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 397. Integer Replacement (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/integer-replacement/">Integer Replacement</a>
     */
    public int integerReplacement(int n) {
        // todo
        return 0;
    }


    /**
     * 399. Evaluate Division (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/evaluate-division/">Evaluate Division</a>
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // todo
        return new double[0];
    }

    /**
     * 400. Nth Digit (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/nth-digit/">Nth Digit</a>
     */
    public int findNthDigit(int n) {
        // todo
        return 0;
    }
}