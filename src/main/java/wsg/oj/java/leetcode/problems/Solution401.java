package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Solutions to problems No.401-No.500.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution401 extends Solution {

    /**
     * 401. Binary Watch (Easy)
     *
     * @see Solution1#letterCombinations(String)
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/binary-watch/">Binary Watch</a>
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int hCount = 0; hCount < 4; hCount++) {
            int minCount = turnedOn - hCount;
            if (minCount >= 0 && minCount < 6) {
                List<Integer> hours = possibles(4, hCount);
                List<Integer> minutes = possibles(6, minCount);
                for (Integer h : hours) {
                    if (h < 12) {
                        for (Integer min : minutes) {
                            if (min < 60) {
                                res.add(String.format("%d:%02d", h, min));
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private List<Integer> possibles(int digits, int bitCount) {
        // digits >= bitCount >= 0
        if (bitCount == 0) {
            return List.of(0);
        }
        List<Integer> possibles = possibles(digits - 1, bitCount - 1);
        List<Integer> res = new ArrayList<>(possibles.size());
        int base = (int) Math.pow(2, digits - 1);
        for (Integer possible : possibles) {
            res.add(base + possible);
        }
        if (digits > bitCount) {
            res.addAll(possibles(digits - 1, bitCount));
        }
        return res;
    }

    /**
     * 402. Remove K Digits (Medium)
     *
     * @see Solution301#maxNumber(int[], int[], int)
     * @see Solution701#monotoneIncreasingDigits(int)
     * @see Solution1601#mostCompetitive(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/remove-k-digits/">Remove K Digits</a>
     */
    public String removeKdigits(String num, int k) {
        // todo
        return "";
    }

    /**
     * 403. Frog Jump (Hard)
     *
     * @see Solution1801#minSideJumps(int[])
     * @see <a href="https://leetcode-cn.com/problems/frog-jump/">Frog Jump</a>
     */
    public boolean canCross(int[] stones) {
        // todo
        return false;
    }

    /**
     * 404. Sum of Left Leaves (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root != null) {
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    /**
     * 405. Convert a Number to Hexadecimal (Easy)
     *
     * @see Integer#toHexString(int)
     * @see <a href="https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/">Convert a
     * Number to Hexadecimal</a>
     */
    public String toHex(int num) {
        return toNRadix(num, 4, 0xf);
    }

    private String toNRadix(int num, int shift, int base) {
        if (num == 0) {
            return "0";
        }
        // 0 < shift < 5
        char[] digits = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        StringBuilder builder = new StringBuilder(32 / shift);
        while (num != 0) {
            builder.insert(0, digits[num & base]);
            num >>>= shift;
        }
        return builder.toString();
    }

    /**
     * 406. Queue Reconstruction by Height (Medium)
     *
     * @see Solution301#countSmaller(int[])
     * @see <a href="https://leetcode-cn.com/problems/queue-reconstruction-by-height/">Queue
     * Reconstruction by Height</a>
     */
    public int[][] reconstructQueue(int[][] people) {
        // todo
        return new int[0][0];
    }

    /**
     * 407. Trapping Rain Water II (Hard)
     *
     * @see Solution1#trap(int[])
     * @see <a href="https://leetcode-cn.com/problems/trapping-rain-water-ii/">Trapping Rain Water
     * II</a>
     */
    public int trapRainWater(int[][] heightMap) {
        // todo
        return 0;
    }

    /**
     * 408. Valid Word Abbreviation (Easy)
     *
     * @see Solution401#minAbbreviation(String, String[])
     * @see Solution501#wordsAbbreviation(String[])
     * @see <a href="https://leetcode-cn.com/problems/valid-word-abbreviation/">Valid Word
     * Abbreviation</a>
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // todo
        return false;
    }

    /**
     * 409. Longest Palindrome (Easy)
     *
     * @see Solution201#canPermutePalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/longest-palindrome/">Longest Palindrome</a>
     */
    public int longestPalindrome(String s) {
        int[] single = new int[58];
        for (char c : s.toCharArray()) {
            int idx = c - 'A';
            single[idx] = 1 - single[idx];
        }
        int singles = 0;
        for (int i : single) {
            singles += i;
        }
        return s.length() - singles + (singles > 0 ? 1 : 0);
    }

    /**
     * 410. Split Array Largest Sum (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/split-array-largest-sum/">Split Array Largest
     * Sum</a>
     */
    public int splitArray(int[] nums, int m) {
        // todo
        return 0;
    }

    /**
     * 411. Minimum Unique Word Abbreviation (Hard)
     *
     * @see Solution301#generateAbbreviations(String)
     * @see Solution401#validWordAbbreviation(String, String)
     * @see Solution501#wordsAbbreviation(String[])
     * @see <a href="https://leetcode-cn.com/problems/minimum-unique-word-abbreviation/">Minimum
     * Unique Word Abbreviation</a>
     */
    public String minAbbreviation(String target, String[] dictionary) {
        // todo
        return "";
    }

    /**
     * 412. Fizz Buzz (Easy)
     *
     * @see Solution1101#foobar(int)
     * @see <a href="https://leetcode-cn.com/problems/fizz-buzz/">Fizz Buzz</a>
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0, mod5 = i % 5 == 0;
            if (mod3) {
                if (mod5) {
                    res.add("FizzBuzz");
                } else {
                    res.add("Fizz");
                }
            } else {
                if (mod5) {
                    res.add("Buzz");
                } else {
                    res.add(String.valueOf(i));
                }
            }
        }
        return res;
    }

    /**
     * 413. Arithmetic Slices (Medium)
     *
     * @see Solution401#numberOfArithmeticSlices(int[])
     * @see Solution1601#checkArithmeticSubarrays(int[], int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/arithmetic-slices/">Arithmetic Slices</a>
     */
    public int numberOfArithmeticSlices(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 414. Third Maximum Number (Easy)
     *
     * @see Solution201#findKthLargest(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/third-maximum-number/">Third Maximum
     * Number</a>
     */
    public int thirdMax(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
        }
        Integer max2 = maxLessThan(nums, max);
        if (max2 == null) {
            return max;
        }
        Integer max3 = maxLessThan(nums, max2);
        return max3 == null ? max : max3;
    }

    private Integer maxLessThan(int[] nums, int n) {
        Integer max = null;
        for (int num : nums) {
            if (num < n) {
                if (max == null || max < num) {
                    max = num;
                }
            }
        }
        return max;
    }

    /**
     * 415. Add Strings (Easy)
     *
     * @see Solution1#addBinary(String, String)
     * @see Solution1#addTwoNumbers(ListNode, ListNode)
     * @see Solution1#multiply(String, String)
     * @see Solution901#addToArrayForm(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/add-strings/">Add Strings</a>
     */
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int i1 = chars1.length - 1, i2 = chars2.length - 1;
        char[] res = new char[Math.max(i1, i2) + 2];
        int i = res.length - 1, carry = 0;
        while (i1 >= 0 && i2 >= 0) {
            int sum = chars1[i1--] - '0' + chars2[i2--] - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        while (i1 >= 0) {
            int sum = chars1[i1--] - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        while (i2 >= 0) {
            int sum = chars2[i2--] - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        if (carry == 0) {
            return String.valueOf(res, 1, res.length - 1);
        }
        res[i] = (char) (carry + '0');
        return new String(res);
    }

    /**
     * 416. Partition Equal Subset Sum (Medium)
     *
     * @see Solution601#canPartitionKSubsets(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/partition-equal-subset-sum/">Partition Equal
     * Subset Sum</a>
     */
    public boolean canPartition(int[] nums) {
        // todo
        return false;
    }

    /**
     * 417. Pacific Atlantic Water Flow (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/pacific-atlantic-water-flow/">Pacific Atlantic
     * Water Flow</a>
     */
    public int[][] pacificAtlantic(int[][] heights) {
        // todo
        return new int[0][0];
    }

    /**
     * 418. Sentence Screen Fitting (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/sentence-screen-fitting/">Sentence Screen
     * Fitting</a>
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // todo
        return 0;
    }

    /**
     * 419. Battleships in a Board (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/battleships-in-a-board/">Battleships in a
     * Board</a>
     */
    public int countBattleships(char[][] board) {
        // todo
        return 0;
    }

    /**
     * 420. Strong Password Checker (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/strong-password-checker/">Strong Password
     * Checker</a>
     */
    public int strongPasswordChecker(String password) {
        // todo
        return 0;
    }

    /**
     * 421. Maximum XOR of Two Numbers in an Array (Medium)
     *
     * @see Solution1701#maximizeXor(int[], int[][])
     * @see <a href="https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/">Maximum
     * XOR of Two Numbers in an Array</a>
     */
    public int findMaximumXOR(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 422. Valid Word Square (Easy)
     *
     * @see Solution401#wordSquares(String[])
     * @see Solution701#isToeplitzMatrix(int[][])
     * @see <a href="https://leetcode-cn.com/problems/valid-word-square/">Valid Word Square</a>
     */
    public boolean validWordSquare(String[] words) {
        // todo
        return false;
    }

    /**
     * 423. Reconstruct Original Digits from English (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/">Reconstruct
     * Original Digits from English</a>
     */
    public String originalDigits(String s) {
        // todo
        return "";
    }

    /**
     * 424. Longest Repeating Character Replacement (Medium)
     *
     * @see Solution301#lengthOfLongestSubstringKDistinct(String, int)
     * @see Solution1001#longestOnes(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/">Longest
     * Repeating Character Replacement</a>
     */
    public int characterReplacement(String s, int k) {
        // todo
        return 0;
    }

    /**
     * 425. Word Squares (Hard)
     *
     * @see Solution401#validWordSquare(String[])
     * @see <a href="https://leetcode-cn.com/problems/word-squares/">Word Squares</a>
     */
    public String[][] wordSquares(String[] words) {
        // todo
        return new String[0][0];
    }

    /**
     * 426. Convert Binary Search Tree to Sorted Doubly Linked List (Medium)
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">Convert
     * Binary Search Tree to Sorted Doubly Linked List</a>
     */
    public ListNode treeToDoublyList(TreeNode root) {
        // todo
        return new ListNode();
    }

    /**
     * 427. Construct Quad Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/construct-quad-tree/">Construct Quad Tree</a>
     */
    public int[][] construct(int[][] grid) {
        // todo
        return new int[0][0];
    }

    /**
     * 428. Serialize and Deserialize N-ary Tree (Hard)
     *
     * @see Solution201#Codec(TreeNode)
     * @see Solution401#CodecDriver(TreeNode)
     * @see Solution401#CodecDriver(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/serialize-and-deserialize-n-ary-tree/">Serialize
     * and Deserialize N-ary Tree</a>
     */
    public int CodecDriver(int root) {
        // todo
        return 0;
    }

    /**
     * 429. N-ary Tree Level Order Traversal (Medium)
     *
     * @see Solution101#levelOrder(TreeNode)
     * @see Solution501#preorder(Solution501.Node)
     * @see Solution501#postorder(Solution501.Node)
     * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/">N-ary Tree
     * Level Order Traversal</a>
     */
    public int[][] levelOrder(int root) {
        // todo
        return new int[0][0];
    }

    /**
     * 430. Flatten a Multilevel Doubly Linked List (Medium)
     *
     * @see Solution101#flatten(TreeNode)
     * @see Solution1601#correctBinaryTree(TreeNode, int, int)
     * @see <a href="https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/">Flatten
     * a Multilevel Doubly Linked List</a>
     */
    public ListNode flatten(ListNode head) {
        // todo
        return new ListNode();
    }

    /**
     * 431. Encode N-ary Tree to Binary Tree (Hard)
     *
     * @see Solution401#CodecDriver(int)
     * @see <a href="https://leetcode-cn.com/problems/encode-n-ary-tree-to-binary-tree/">Encode
     * N-ary Tree to Binary Tree</a>
     */
    public TreeNode CodecDriver(TreeNode root) {
        // todo
        return new TreeNode();
    }


    /**
     * 433. Minimum Genetic Mutation (Medium)
     *
     * @see Solution101#ladderLength(String, String, String[])
     * @see <a href="https://leetcode-cn.com/problems/minimum-genetic-mutation/">Minimum Genetic
     * Mutation</a>
     */
    public int minMutation(String start, String end, String[] bank) {
        // todo
        return 0;
    }

    /**
     * 434. Number of Segments in a String (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/number-of-segments-in-a-string/">Number of
     * Segments in a String</a>
     */
    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        int count = 0;
        while (i >= 0) {
            if (chars[i--] != ' ') {
                count++;
                while (i >= 0 && chars[i] != ' ') {
                    i--;
                }
            }
        }
        return count;
    }

    /**
     * 435. Non-overlapping Intervals (Medium)
     *
     * @see Solution401#findMinArrowShots(int[][])
     * @see <a href="https://leetcode-cn.com/problems/non-overlapping-intervals/">Non-overlapping
     * Intervals</a>
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // todo
        return 0;
    }

    /**
     * 436. Find Right Interval (Medium)
     *
     * @see SummaryRanges
     * @see <a href="https://leetcode-cn.com/problems/find-right-interval/">Find Right Interval</a>
     */
    public int[] findRightInterval(int[][] intervals) {
        // todo
        return new int[0];
    }

    /**
     * 437. Path Sum III (Medium)
     *
     * @see Solution101#hasPathSum(TreeNode, int)
     * @see Solution101#pathSum(TreeNode, int)
     * @see Solution601#pathSum(int[])
     * @see Solution601#longestUnivaluePath(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/path-sum-iii/">Path Sum III</a>
     */
    public int pathSum(TreeNode root, int targetSum) {
        // todo
        return 0;
    }

    /**
     * 438. Find All Anagrams in a String (Medium)
     *
     * @see Solution201#isAnagram(String, String)
     * @see Solution501#checkInclusion(String, String)
     * @see <a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/">Find All
     * Anagrams in a String</a>
     */
    public int[] findAnagrams(String s, String p) {
        // todo
        return new int[0];
    }

    /**
     * 439. Ternary Expression Parser (Medium)
     *
     * @see Solution301#deserialize(String)
     * @see Solution701#removeComments(String[])
     * @see Solution701#evaluate(String)
     * @see <a href="https://leetcode-cn.com/problems/ternary-expression-parser/">Ternary Expression
     * Parser</a>
     */
    public String parseTernary(String expression) {
        // todo
        return "";
    }

    /**
     * 440. K-th Smallest in Lexicographical Order (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/">K-th
     * Smallest in Lexicographical Order</a>
     */
    public int findKthNumber(int n, int k) {
        // todo
        return 0;
    }

    /**
     * 441. Arranging Coins (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/arranging-coins/">Arranging Coins</a>
     */
    public int arrangeCoins(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int dif = mid % 2 == 0 ? (mid / 2 - n / (mid + 1)) : ((mid + 1) / 2 - n / mid);
            if (dif > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    /**
     * 442. Find All Duplicates in an Array (Medium)
     *
     * @see Solution401#findDisappearedNumbers(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/">Find All
     * Duplicates in an Array</a>
     */
    public int[] findDuplicates(int[] nums) {
        // todo
        return new int[0];
    }

    /**
     * 443. String Compression (Medium)
     *
     * @see Solution1#countAndSay(int)
     * @see Solution201#encode(String[])
     * @see StringIterator
     * @see Solution1301#decompressRLElist(int[])
     * @see <a href="https://leetcode-cn.com/problems/string-compression/">String Compression</a>
     */
    public int compress(char[] chars) {
        // todo
        return 0;
    }

    /**
     * 444. Sequence Reconstruction (Medium)
     *
     * @see Solution201#findOrder(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/sequence-reconstruction/">Sequence
     * Reconstruction</a>
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // todo
        return false;
    }

    /**
     * 445. Add Two Numbers II (Medium)
     *
     * @see Solution1#addTwoNumbers(ListNode, ListNode)
     * @see Solution1601#addPoly(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/add-two-numbers-ii/">Add Two Numbers II</a>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // todo
        return new ListNode();
    }

    /**
     * 446. Arithmetic Slices II - Subsequence (Hard)
     *
     * @see Solution401#numberOfArithmeticSlices(int[])
     * @see <a href="https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/">Arithmetic
     * Slices II - Subsequence</a>
     */
    public int numberOfArithmeticSlicesII(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 447. Number of Boomerangs (Medium)
     *
     * @see Solution301#isReflected(int[][])
     * @see <a href="https://leetcode-cn.com/problems/number-of-boomerangs/">Number of
     * Boomerangs</a>
     */
    public int numberOfBoomerangs(int[][] points) {
        // todo
        return 0;
    }

    /**
     * 448. Find All Numbers Disappeared in an Array (Easy)
     *
     * @see Solution1#firstMissingPositive(int[])
     * @see Solution401#findDuplicates(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/">Find
     * All Numbers Disappeared in an Array</a>
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                int value = nums[i];
                nums[i] = 0;
                while (value != 0 && nums[value - 1] != value) {
                    int temp = nums[value - 1];
                    nums[value - 1] = value;
                    value = temp;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * 449. Serialize and Deserialize BST (Medium)
     *
     * @see Solution201#Codec(TreeNode)
     * @see Solution601#findDuplicateSubtrees(TreeNode)
     * @see Solution401#CodecDriver(int)
     * @see <a href="https://leetcode-cn.com/problems/serialize-and-deserialize-bst/">Serialize and
     * Deserialize BST</a>
     */
    public TreeNode CodecDriverII(TreeNode root) {
        // todo
        return new TreeNode();
    }

    /**
     * 450. Delete Node in a BST (Medium)
     *
     * @see Solution701#splitBST(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-bst/">Delete Node in a
     * BST</a>
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // todo
        return new TreeNode();
    }

    /**
     * 451. Sort Characters By Frequency (Medium)
     *
     * @see Solution301#topKFrequent(int[], int)
     * @see Solution301#firstUniqChar(String)
     * @see Solution1601#frequencySort(int[])
     * @see <a href="https://leetcode-cn.com/problems/sort-characters-by-frequency/">Sort Characters
     * By Frequency</a>
     */
    public String frequencySort(String s) {
        // todo
        return "";
    }

    /**
     * 452. Minimum Number of Arrows to Burst Balloons (Medium)
     *
     * @see Solution201#minMeetingRooms(int[][])
     * @see Solution401#eraseOverlapIntervals(int[][])
     * @see <a href="https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/">Minimum
     * Number of Arrows to Burst Balloons</a>
     */
    public int findMinArrowShots(int[][] points) {
        // todo
        return 0;
    }

    /**
     * 453. Minimum Moves to Equal Array Elements (Easy)
     *
     * @see Solution401#minMoves2(int[])
     * @see <a href="https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/">Minimum
     * Moves to Equal Array Elements</a>
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }

    /**
     * 454. 4Sum II (Medium)
     *
     * @see Solution1#fourSum(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/4sum-ii/">4Sum II</a>
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // todo
        return 0;
    }

    /**
     * 455. Assign Cookies (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/assign-cookies/">Assign Cookies</a>
     */
    public int findContentChildren(int[] g, int[] s) {
        // todo
        return 0;
    }

    /**
     * 456. 132 Pattern (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/132-pattern/">132 Pattern</a>
     */
    public boolean find132pattern(int[] nums) {
        // todo
        return false;
    }

    /**
     * 457. Circular Array Loop (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/circular-array-loop/">Circular Array Loop</a>
     */
    public boolean circularArrayLoop(int[] nums) {
        // todo
        return false;
    }

    /**
     * 458. Poor Pigs (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/poor-pigs/">Poor Pigs</a>
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // todo
        return 0;
    }

    /**
     * 459. Repeated Substring Pattern (Easy)
     *
     * @see Solution1#strStr(String, String)
     * @see Solution601#repeatedStringMatch(String, String)
     * @see <a href="https://leetcode-cn.com/problems/repeated-substring-pattern/">Repeated
     * Substring Pattern</a>
     */
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int subLen = len / 2; subLen > 0; subLen--) {
            if (len % subLen == 0 && repeatedSubstringPattern(chars, len, subLen)) {
                return true;
            }
        }
        return false;
    }

    private boolean repeatedSubstringPattern(char[] chars, int len, int subLen) {
        for (int i = subLen; i < len; i++) {
            if (chars[i] != chars[i - subLen]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 461. Hamming Distance (Easy)
     *
     * @see Solution101#hammingWeight(int)
     * @see Solution401#totalHammingDistance(int[])
     * @see <a href="https://leetcode-cn.com/problems/hamming-distance/">Hamming Distance</a>
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 462. Minimum Moves to Equal Array Elements II (Medium)
     *
     * @see Solution201#minTotalDistance(int[][])
     * @see Solution401#minMoves(int[])
     * @see <a href="https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/">Minimum
     * Moves to Equal Array Elements II</a>
     */
    public int minMoves2(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 463. Island Perimeter (Easy)
     *
     * @see Solution601#maxAreaOfIsland(int[][])
     * @see Solution701#floodFill(int[][], int, int, int)
     * @see Solution1001#colorBorder(int[][], int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/island-perimeter/">Island Perimeter</a>
     */
    public int islandPerimeter(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 464. Can I Win (Medium)
     *
     * @see Solution201#canWin(String)
     * @see Solution301#getMoneyAmount(int)
     * @see Solution401#PredictTheWinner(int[])
     * @see <a href="https://leetcode-cn.com/problems/can-i-win/">Can I Win</a>
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // todo
        return false;
    }

    /**
     * 465. Optimal Account Balancing (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/optimal-account-balancing/">Optimal Account
     * Balancing</a>
     */
    public int minTransfers(int[][] transactions) {
        // todo
        return 0;
    }

    /**
     * 466. Count The Repetitions (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/count-the-repetitions/">Count The
     * Repetitions</a>
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // todo
        return 0;
    }

    /**
     * 467. Unique Substrings in Wraparound String (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/unique-substrings-in-wraparound-string/">Unique
     * Substrings in Wraparound String</a>
     */
    public int findSubstringInWraproundString(String p) {
        // todo
        return 0;
    }

    /**
     * 468. Validate IP Address (Medium)
     *
     * @see Solution701#ipToCIDR(String, int)
     * @see <a href="https://leetcode-cn.com/problems/validate-ip-address/">Validate IP Address</a>
     */
    public String validIPAddress(String IP) {
        // todo
        return "";
    }

    /**
     * 469. Convex Polygon (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/convex-polygon/">Convex Polygon</a>
     */
    public boolean isConvex(int[][] points) {
        // todo
        return false;
    }

    /**
     * 470. Implement Rand10() Using Rand7() (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/implement-rand10-using-rand7/">Implement
     * Rand10() Using Rand7()</a>
     */
    public void rand10(int n) {
        // todo
    }

    /**
     * 471. Encode String with Shortest Length (Hard)
     *
     * @see Solution301#decodeString(String)
     * @see Solution701#countOfAtoms(String)
     * @see <a href="https://leetcode-cn.com/problems/encode-string-with-shortest-length/">Encode
     * String with Shortest Length</a>
     */
    public String encode(String s) {
        // todo
        return "";
    }

    /**
     * 472. Concatenated Words (Hard)
     *
     * @see Solution101#wordBreak(String, String[])
     * @see <a href="https://leetcode-cn.com/problems/concatenated-words/">Concatenated Words</a>
     */
    public String[] findAllConcatenatedWordsInADict(String[] words) {
        // todo
        return new String[0];
    }

    /**
     * 473. Matchsticks to Square (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/matchsticks-to-square/">Matchsticks to
     * Square</a>
     */
    public boolean makesquare(int[] matchsticks) {
        // todo
        return false;
    }

    /**
     * 474. Ones and Zeroes (Medium)
     *
     * @see Solution501#findIntegers(int)
     * @see <a href="https://leetcode-cn.com/problems/ones-and-zeroes/">Ones and Zeroes</a>
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // todo
        return 0;
    }

    /**
     * 475. Heaters (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/heaters/">Heaters</a>
     */
    public int findRadius(int[] houses, int[] heaters) {
        // todo
        return 0;
    }

    /**
     * 476. Number Complement (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/number-complement/">Number Complement</a>
     */
    public int findComplement(int num) {
        int fff = 0;
        while (fff < num) {
            fff = fff * 2 + 1;
        }
        return num ^ fff;
    }

    /**
     * 477. Total Hamming Distance (Medium)
     *
     * @see Solution401#hammingDistance(int, int)
     * @see <a href="https://leetcode-cn.com/problems/total-hamming-distance/">Total Hamming
     * Distance</a>
     */
    public int totalHammingDistance(int[] nums) {
        // todo
        return 0;
    }


    /**
     * 479. Largest Palindrome Product (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-palindrome-product/">Largest
     * Palindrome Product</a>
     */
    public int largestPalindrome(int n) {
        // todo
        return 0;
    }

    /**
     * 480. Sliding Window Median (Hard)
     *
     * @see MedianFinder
     * @see <a href="https://leetcode-cn.com/problems/sliding-window-median/">Sliding Window
     * Median</a>
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        // todo
        return new double[0];
    }

    /**
     * 481. Magical String (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/magical-string/">Magical String</a>
     */
    public int magicalString(int n) {
        // todo
        return 0;
    }

    /**
     * 482. License Key Formatting (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/license-key-formatting/">License Key
     * Formatting</a>
     */
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        int dashes = 0;
        for (char ch : chars) {
            if (ch == '-') {
                dashes++;
            }
        }
        int keysCount = chars.length - dashes;
        char[] res = new char[keysCount + (keysCount - 1) / k];
        int i = chars.length - 1, c = 0, j = res.length - 1;
        while (i >= 0) {
            char ch = chars[i--];
            if (ch != '-') {
                if (ch > 'Z') {
                    ch -= 32;
                }
                if (c == k) {
                    res[j--] = '-';
                    c = 0;
                }
                res[j--] = ch;
                c++;
            }
        }
        return new String(res);
    }

    /**
     * 483. Smallest Good Base (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/smallest-good-base/">Smallest Good Base</a>
     */
    public String smallestGoodBase(String n) {
        // todo
        return "";
    }

    /**
     * 484. Find Permutation (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-permutation/">Find Permutation</a>
     */
    public int[] findPermutation(String s) {
        // todo
        return new int[0];
    }

    /**
     * 485. Max Consecutive Ones (Easy)
     *
     * @see Solution401#findMaxConsecutiveOnes(int[])
     * @see Solution1001#longestOnes(int[], int)
     * @see Solution1401#maxPower(String)
     * @see Solution1801#checkZeroOnes(String)
     * @see <a href="https://leetcode-cn.com/problems/max-consecutive-ones/">Max Consecutive
     * Ones</a>
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }

    /**
     * 486. Predict the Winner (Medium)
     *
     * @see Solution401#canIWin(int, int)
     * @see <a href="https://leetcode-cn.com/problems/predict-the-winner/">Predict the Winner</a>
     */
    public boolean PredictTheWinner(int[] nums) {
        // todo
        return false;
    }

    /**
     * 487. Max Consecutive Ones II (Medium)
     *
     * @see Solution401#findMaxConsecutiveOnes(int[])
     * @see Solution1001#longestOnes(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/max-consecutive-ones-ii/">Max Consecutive Ones
     * II</a>
     */
    public int findMaxConsecutiveOnesII(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 488. Zuma Game (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/zuma-game/">Zuma Game</a>
     */
    public int findMinStep(String board, String hand) {
        // todo
        return 0;
    }

    /**
     * 489. Robot Room Cleaner (Hard)
     *
     * @see Solution201#wallsAndGates(int[][])
     * @see Solution1701#foobar(int[][])
     * @see Solution1801#findShortestPath(int[][], int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/robot-room-cleaner/">Robot Room Cleaner</a>
     */
    public void cleanRoom(int[][] room, int row, int col) {
        // todo
    }

    /**
     * 490. The Maze (Medium)
     *
     * @see Solution401#findShortestWay(int[][], int[], int[])
     * @see Solution501#shortestDistance(int[][], int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/the-maze/">The Maze</a>
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // todo
        return false;
    }

    /**
     * 491. Increasing Subsequences (Medium)
     *
     * @see Solution601#findLongestChain(int[][])
     * @see <a href="https://leetcode-cn.com/problems/increasing-subsequences/">Increasing
     * Subsequences</a>
     */
    public int[][] findSubsequences(int[] nums) {
        // todo
        return new int[0][0];
    }

    /**
     * 492. Construct the Rectangle (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/construct-the-rectangle/">Construct the
     * Rectangle</a>
     */
    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area);
        while (area % W != 0) {
            W--;
        }
        return new int[]{area / W, W};
    }

    /**
     * 493. Reverse Pairs (Hard)
     *
     * @see Solution301#countSmaller(int[])
     * @see Solution301#countRangeSum(int[], int, int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-pairs/">Reverse Pairs</a>
     */
    public int reversePairs(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 494. Target Sum (Medium)
     *
     * @see Solution201#addOperators(String, int)
     * @see <a href="https://leetcode-cn.com/problems/target-sum/">Target Sum</a>
     */
    public int findTargetSumWays(int[] nums, int target) {
        // todo
        return 0;
    }

    /**
     * 495. Teemo Attacking (Easy)
     *
     * @see Solution1#merge(int[][])
     * @see Solution601#canPlaceFlowers(int[], int)
     * @see Solution601#predictPartyVictory(String)
     * @see <a href="https://leetcode-cn.com/problems/teemo-attacking/">Teemo Attacking</a>
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int lastEnd = 0, notPoisoned = 0;
        for (int time : timeSeries) {
            if (time > lastEnd) {
                notPoisoned += time - lastEnd;
            }
            lastEnd = time + duration;
        }
        return timeSeries[timeSeries.length - 1] + duration - notPoisoned;
    }

    /**
     * 496. Next Greater Element I (Easy)
     *
     * @see Solution501#nextGreaterElements(int[])
     * @see Solution501#nextGreaterElement(int)
     * @see Solution701#dailyTemperatures(int[])
     * @see <a href="https://leetcode-cn.com/problems/next-greater-element-i/">Next Greater Element
     * I</a>
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterElements = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (top > num) {
                    break;
                } else {
                    nextGreaterElements.put(top, num);
                }
                stack.pop();
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = nums1.length - 1; i >= 0; i--) {
            res[i] = nextGreaterElements.getOrDefault(nums1[i], -1);
        }
        return res;
    }


    /**
     * 498. Diagonal Traverse (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/diagonal-traverse/">Diagonal Traverse</a>
     */
    public int[] findDiagonalOrder(int[][] mat) {
        // todo
        return new int[0];
    }

    /**
     * 499. The Maze III (Hard)
     *
     * @see Solution401#hasPath(int[][], int[], int[])
     * @see Solution501#shortestDistance(int[][], int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/the-maze-iii/">The Maze III</a>
     */
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        // todo
        return "";
    }

    /**
     * 500. Keyboard Row (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/keyboard-row/">Keyboard Row</a>
     */
    public String[] findWords(String[] words) {
        int[] rows = new int[26];
        for (char c : new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'}) {
            rows[c - 'a'] = 1;
        }
        for (char c : new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'}) {
            rows[c - 'a'] = 2;
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isSameRow(word, rows)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean isSameRow(String word, int[] rows) {
        char[] chars = word.toCharArray();
        int row = rows[chars[0] > 'Z' ? (chars[0] - 'a') : chars[0] - 'A'];
        for (int i = chars.length - 1; i > 0; i--) {
            char ch = chars[i];
            if (rows[ch > 'Z' ? ch - 'a' : ch - 'A'] != row) {
                return false;
            }
        }
        return true;
    }
}