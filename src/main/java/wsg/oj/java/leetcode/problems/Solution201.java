package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import wsg.oj.java.leetcode.problems.impl.MinStack;

/**
 * Solutions to problems No.201-No.300.
 *
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
        // todo
        return 0;
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
        Set<Integer> unhappy = Set.of(
            2, 4, 16, 37, 58, 89, 145, 42, 20
        );
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
     * @see Solution201#findOrder(int, int[][])
     * @see Solution201#validTree(int, int[][])
     * @see Solution301#findMinHeightTrees(int, int[][])
     * @see Solution601#scheduleCourse(int[][])
     * @see <a href="https://leetcode-cn.com/problems/course-schedule/">Course Schedule</a>
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // todo
        return false;
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
        // todo
        return 0;
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
        // todo
        return new int[0];
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
     * 213. House Robber II (Medium)
     *
     * @see Solution101#rob(int[])
     * @see Solution201#minCost(int[][])
     * @see Solution201#numWays(int, int)
     * @see Solution301#rob(TreeNode)
     * @see Solution501#findIntegers(int)
     * @see Solution601#cheapestJump(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/house-robber-ii/">House Robber II</a>
     */
    public int rob(int[] nums) {
        // todo
        return 0;
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
     * 215. Kth Largest Element in an Array (Medium)
     *
     * @see Solution301#wiggleSort(int[])
     * @see Solution301#topKFrequent(int[], int)
     * @see Solution401#thirdMax(int[])
     * @see KthLargest
     * @see Solution901#kClosest(int[][], int)
     * @see <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">Kth Largest
     * Element in an Array</a>
     */
    public int findKthLargest(int[] nums, int k) {
        // todo
        return 0;
    }

    /**
     * 216. Combination Sum III (Medium)
     *
     * @see Solution1#combinationSum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/combination-sum-iii/">Combination Sum III</a>
     */
    public int[][] combinationSum3(int k, int n) {
        // todo
        return new int[0][0];
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
        // todo
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
        // todo
        return 0;
    }

    /**
     * 222. Count Complete Tree Nodes (Medium)
     *
     * @see Solution201#closestValue(TreeNode, double)
     * @see <a href="https://leetcode-cn.com/problems/count-complete-tree-nodes/">Count Complete
     * Tree Nodes</a>
     */
    public int countNodes(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 223. Rectangle Area (Medium)
     *
     * @see Solution801#isRectangleOverlap(int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/rectangle-area/">Rectangle Area</a>
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // todo
        return 0;
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
        // todo
        return 0;
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
     *
     * @see Solution101#majorityElement(int[])
     * @see Solution1101#isMajorityElement(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/majority-element-ii/">Majority Element II</a>
     */
    public int[] majorityElement(int[] nums) {
        // todo
        return new int[0];
    }

    /**
     * 230. Kth Smallest Element in a BST (Medium)
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see Solution601#findSecondMinimumValue(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest
     * Element in a BST</a>
     */
    public int kthSmallest(TreeNode root, int k) {
        // todo
        return 0;
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
     * @see Solution201#lowestCommonAncestorII(TreeNode, int, int)
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
     *
     * @see Solution201#lowestCommonAncestor(TreeNode, TreeNode, TreeNode)
     * @see Solution1201#findSmallestRegion(String[][], String, String)
     * @see Solution1601#lowestCommonAncestor(TreeNode, int, int)
     * @see Solution1601#lowestCommonAncestor(int[], int, int)
     * @see Solution1601#lowestCommonAncestor(TreeNode, int[])
     * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest
     * Common Ancestor of a Binary Tree</a>
     */
    public TreeNode lowestCommonAncestorII(TreeNode root, int p, int q) {
        // todo
        return new TreeNode();
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
     * @see Solution1#trap(int[])
     * @see Solution101#maxProduct(int[])
     * @see Solution201#minCostII(int[][])
     * @see <a href="https://leetcode-cn.com/problems/product-of-array-except-self/">Product of
     * Array Except Self</a>
     */
    public int[] productExceptSelf(int[] nums) {
        // todo
        return new int[0];
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
     * @see Solution1#searchMatrix(int[][], int)
     * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix
     * II</a>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // todo
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
     * @see Solution1#groupAnagrams(String[])
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
     * @see Solution1#groupAnagrams(String[])
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
     * @see Solution101#singleNumber(int[])
     * @see <a href="https://leetcode-cn.com/problems/single-number-iii/">Single Number III</a>
     */
    public int[] singleNumber(int[] nums) {
        // todo
        return new int[0];
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
     * @see Solution1#mergeKLists(ListNode[])
     * @see Solution201#countPrimes(int)
     * @see Solution201#isUgly(int)
     * @see Solution201#numSquares(int)
     * @see Solution301#nthSuperUglyNumber(int, int[])
     * @see Solution1201#nthUglyNumber(int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/ugly-number-ii/">Ugly Number II</a>
     */
    public int nthUglyNumber(int n) {
        // todo
        return 0;
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
     */
    public int hIndex(int[] citations) {
        // todo
        return 0;
    }

    /**
     * 275. H-Index II (Medium)
     *
     * @see Solution201#hIndex(int[])
     * @see <a href="https://leetcode-cn.com/problems/h-index-ii/">H-Index II</a>
     */
    public int hIndexII(int[] citations) {
        // todo
        return 0;
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
     * @see Solution201#countPrimes(int)
     * @see Solution201#nthUglyNumber(int)
     * @see <a href="https://leetcode-cn.com/problems/perfect-squares/">Perfect Squares</a>
     */
    public int numSquares(int n) {
        // todo
        return 0;
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
     * @see Solution201#PeekingIterator(int[], int[])
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
     * 284. Peeking Iterator (Medium)
     *
     * @see BSTIterator
     * @see Vector2D
     * @see Solution201#ZigzagIterator(int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/peeking-iterator/">Peeking Iterator</a>
     */
    public String[] PeekingIterator(int[] nums, int[] commands) {
        // todo
        return new String[0];
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
     * @see Solution101#detectCycle(ListNode, int)
     * @see Solution201#missingNumber(int[])
     * @see Solution601#findErrorNums(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-the-duplicate-number/">Find the Duplicate
     * Number</a>
     */
    public int findDuplicate(int[] nums) {
        // todo
        return 0;
    }


    /**
     * 289. Game of Life (Medium)
     *
     * @see Solution1#setZeroes(int[][])
     * @see <a href="https://leetcode-cn.com/problems/game-of-life/">Game of Life</a>
     */
    public void gameOfLife(int[][] board) {
        // todo
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
        // todo
        return "";
    }

    /**
     * 300. Longest Increasing Subsequence (Medium)
     *
     * @see Solution301#increasingTriplet(int[])
     * @see Solution301#maxEnvelopes(int[][])
     * @see Solution601#findLongestChain(int[][])
     * @see Solution601#findNumberOfLIS(int[])
     * @see Solution701#minimumDeleteSum(String, String)
     * @see Solution1601#minimumMountainRemovals(int[])
     * @see <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">Longest
     * Increasing Subsequence</a>
     */
    public int lengthOfLIS(int[] nums) {
        // todo
        return 0;
    }
}