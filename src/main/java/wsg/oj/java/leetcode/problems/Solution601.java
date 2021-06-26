package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.impl.Trie;

/**
 * Solutions to problems No.601-No.700.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution601 extends Solution {


    /**
     * 605. Can Place Flowers (Easy)
     *
     * @see Solution401#findPoisonedDuration(int[], int)
     * @see Solution701#asteroidCollision(int[])
     * @see <a href="https://leetcode-cn.com/problems/can-place-flowers/">Can Place Flowers</a>
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length - 1;
        if (len == 0) {
            return n <= (flowerbed[0] ^ 1);
        }
        int count = 0;
        // the first one
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            count++;
        }
        for (int i = 1; i < len; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        // the last one
        if (flowerbed[len] == 0 && flowerbed[len - 1] == 0) {
            count++;
        }
        return n <= count;
    }

    /**
     * 606. Construct String from Binary Tree (Easy)
     *
     * @see Solution501#str2tree(String)
     * @see Solution601#findDuplicateSubtrees(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/construct-string-from-binary-tree/">Construct
     * String from Binary Tree</a>
     */
    public String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        tree2str(root, builder);
        return builder.toString();
    }

    private void tree2str(TreeNode node, StringBuilder builder) {
        builder.append(node.val);
        if (node.right != null) {
            builder.append("(");
            if (node.left != null) {
                tree2str(node.left, builder);
            }
            builder.append(")(");
            tree2str(node.right, builder);
            builder.append(")");
        } else if (node.left != null) {
            builder.append("(");
            tree2str(node.left, builder);
            builder.append(")");
        }
    }


    /**
     * 609. Find Duplicate File in System (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-duplicate-file-in-system/">Find Duplicate
     * File in System</a>
     */
    public String[][] findDuplicate(String[] paths) {
        // todo
        return new String[0][0];
    }


    /**
     * 611. Valid Triangle Number (Medium)
     *
     * @see Solution201#threeSumSmaller(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/valid-triangle-number/">Valid Triangle
     * Number</a>
     */
    public int triangleNumber(int[] nums) {
        // todo
        return 0;
    }


    /**
     * 616. Add Bold Tag in String (Medium)
     *
     * @see Solution1#merge(int[][])
     * @see Solution501#isValid(String)
     * @see <a href="https://leetcode-cn.com/problems/add-bold-tag-in-string/">Add Bold Tag in
     * String</a>
     */
    public String addBoldTag(String s, String[] words) {
        // todo
        return "";
    }

    /**
     * 617. Merge Two Binary Trees (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/merge-two-binary-trees/">Merge Two Binary
     * Trees</a>
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);
        return new TreeNode(root1.val + root2.val, left, right);
    }


    /**
     * 621. Task Scheduler (Medium)
     *
     * @see Solution301#rearrangeString(String, int)
     * @see Solution701#reorganizeString(String)
     * @see <a href="https://leetcode-cn.com/problems/task-scheduler/">Task Scheduler</a>
     */
    public int leastInterval(char[] tasks, int n) {
        // todo
        return 0;
    }


    /**
     * 623. Add One Row to Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/add-one-row-to-tree/">Add One Row to Tree</a>
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // todo
        return new TreeNode();
    }

    /**
     * 624. Maximum Distance in Arrays (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/maximum-distance-in-arrays/">Maximum Distance
     * in Arrays</a>
     */
    public int maxDistance(int[][] arrays) {
        // todo
        return 0;
    }

    /**
     * 625. Minimum Factorization (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/minimum-factorization/">Minimum
     * Factorization</a>
     */
    public int smallestFactorization(int num) {
        // todo
        return 0;
    }


    /**
     * 628. Maximum Product of Three Numbers (Easy)
     *
     * @see Solution101#maxProduct(int[])
     * @see <a href="https://leetcode-cn.com/problems/maximum-product-of-three-numbers/">Maximum
     * Product of Three Numbers</a>
     */
    public int maximumProduct(int[] nums) {
        int[] max = new int[]{-1000, -1000, -1000};
        int[] min = new int[]{1000, 1000};
        for (int num : nums) {
            if (num < min[0]) {
                min[1] = min[0];
                min[0] = num;
            } else if (num < min[1]) {
                min[1] = num;
            }
            if (num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (num > max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (num > max[2]) {
                max[2] = num;
            }
        }
        return Math.max(max[0] * max[1] * max[2], min[0] * min[1] * max[0]);
    }

    /**
     * 629. K Inverse Pairs Array (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/k-inverse-pairs-array/">K Inverse Pairs
     * Array</a>
     */
    public int kInversePairs(int n, int k) {
        // todo
        return 0;
    }

    /**
     * 630. Course Schedule III (Hard)
     *
     * @see Solution201#canFinish(int, int[][])
     * @see Solution201#findOrder(int, int[][])
     * @see <a href="https://leetcode-cn.com/problems/course-schedule-iii/">Course Schedule III</a>
     */
    public int scheduleCourse(int[][] courses) {
        // todo
        return 0;
    }


    /**
     * 632. Smallest Range Covering Elements from K Lists (Hard)
     *
     * @see Solution1#minWindow(String, String)
     * @see <a href="https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/">Smallest
     * Range Covering Elements from K Lists</a>
     */
    public int[] smallestRange(int[][] nums) {
        // todo
        return new int[0];
    }

    /**
     * 633. Sum of Square Numbers (Medium)
     *
     * @see Solution301#isPerfectSquare(int)
     * @see <a href="https://leetcode-cn.com/problems/sum-of-square-numbers/">Sum of Square
     * Numbers</a>
     */
    public boolean judgeSquareSum(int c) {
        // todo
        return false;
    }

    /**
     * 634. Find the Derangement of An Array (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/find-the-derangement-of-an-array/">Find the
     * Derangement of An Array</a>
     */
    public int findDerangement(int n) {
        // todo
        return 0;
    }


    /**
     * 636. Exclusive Time of Functions (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/exclusive-time-of-functions/">Exclusive Time
     * of Functions</a>
     */
    public int[] exclusiveTime(int n, String[] logs) {
        // todo
        return new int[0];
    }

    /**
     * 637. Average of Levels in Binary Tree (Easy)
     *
     * @see Solution101#levelOrder(TreeNode)
     * @see Solution101#levelOrderBottom(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/">Average of
     * Levels in Binary Tree</a>
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        double sum = 0;
        int count = 0;
        do {
            TreeNode node = queue.remove();
            if (node != null) {
                sum += node.val;
                count++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                // finish a level
                res.add(sum / count);
                sum = 0;
                count = 0;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }
        } while (!queue.isEmpty());
        return res;
    }

    /**
     * 637.2 Average of Levels in Binary Tree (Easy) (Recursion)
     *
     * @see Solution101#maxDepth(TreeNode)
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        int depth = maxDepth(root);
        long[] sums = new long[depth];
        int[] counts = new int[depth];
        sum(root, 0, sums, counts);
        List<Double> res = new ArrayList<>(depth);
        for (int i = 0; i < depth; i++) {
            res.add(((double) sums[i]) / counts[i]);
        }
        return res;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private void sum(TreeNode node, int level, long[] sums, int[] counts) {
        sums[level] += node.val;
        counts[level]++;
        if (node.left != null) {
            sum(node.left, level + 1, sums, counts);
        }
        if (node.right != null) {
            sum(node.right, level + 1, sums, counts);
        }
    }

    /**
     * 638. Shopping Offers (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/shopping-offers/">Shopping Offers</a>
     */
    public int shoppingOffers(int[] price, int[][] special, int[] needs) {
        // todo
        return 0;
    }

    /**
     * 639. Decode Ways II (Hard)
     *
     * @see Solution1#numDecodings(String)
     * @see <a href="https://leetcode-cn.com/problems/decode-ways-ii/">Decode Ways II</a>
     */
    public int numDecodings(String s) {
        // todo
        return 0;
    }

    /**
     * 640. Solve the Equation (Medium)
     *
     * @see Solution501#fractionAddition(String)
     * @see <a href="https://leetcode-cn.com/problems/solve-the-equation/">Solve the Equation</a>
     */
    public String solveEquation(String equation) {
        // todo
        return "";
    }


    /**
     * 643. Maximum Average Subarray I (Easy)
     *
     * @see Solution601#findMaxAverage(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/maximum-average-subarray-i/">Maximum Average
     * Subarray I</a>
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int n = nums.length;
        int max = sum;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > max) {
                max = sum;
            }
        }
        return (double) max / k;
    }

    /**
     * 644. Maximum Average Subarray II (Hard)
     *
     * @see Solution601#findMaxAverage(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/maximum-average-subarray-ii/">Maximum Average
     * Subarray II</a>
     */
    public double findMaxAverageII(int[] nums, int k) {
        // todo
        return 0.0;
    }

    /**
     * 645. Set Mismatch (Easy)
     *
     * @see Solution201#findDuplicate(int[])
     * @see <a href="https://leetcode-cn.com/problems/set-mismatch/">Set Mismatch</a>
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, duplicate = 0;
        boolean[] appear = new boolean[n + 1];
        for (int num : nums) {
            if (appear[num]) {
                duplicate = num;
            } else {
                appear[num] = true;
            }
        }
        int missing = 0;
        for (int i = 1; i <= n; i++) {
            if (!appear[i]) {
                missing = i;
                break;
            }
        }
        return new int[]{duplicate, missing};
    }

    /**
     * 646. Maximum Length of Pair Chain (Medium)
     *
     * @see Solution201#lengthOfLIS(int[])
     * @see Solution401#findSubsequences(int[])
     * @see <a href="https://leetcode-cn.com/problems/maximum-length-of-pair-chain/">Maximum Length
     * of Pair Chain</a>
     */
    public int findLongestChain(int[][] pairs) {
        // todo
        return 0;
    }

    /**
     * 647. Palindromic Substrings (Medium)
     *
     * @see Solution1#longestPalindrome(String)
     * @see Solution501#longestPalindromeSubseq(String)
     * @see <a href="https://leetcode-cn.com/problems/palindromic-substrings/">Palindromic
     * Substrings</a>
     */
    public int countSubstrings(String s) {
        // todo
        return 0;
    }

    /**
     * 648. Replace Words (Medium)
     *
     * @see Trie
     * @see <a href="https://leetcode-cn.com/problems/replace-words/">Replace Words</a>
     */
    public String replaceWords(String[] dictionary, String sentence) {
        // todo
        return "";
    }

    /**
     * 649. Dota2 Senate (Medium)
     *
     * @see Solution401#findPoisonedDuration(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/dota2-senate/">Dota2 Senate</a>
     */
    public String predictPartyVictory(String senate) {
        // todo
        return "";
    }

    /**
     * 650. 2 Keys Keyboard (Medium)
     *
     * @see Solution601#maxA(int)
     * @see Solution901#brokenCalc(int, int)
     * @see <a href="https://leetcode-cn.com/problems/2-keys-keyboard/">2 Keys Keyboard</a>
     */
    public int minSteps(int n) {
        // todo
        return 0;
    }

    /**
     * 651. 4 Keys Keyboard (Medium)
     *
     * @see Solution601#minSteps(int)
     * @see <a href="https://leetcode-cn.com/problems/4-keys-keyboard/">4 Keys Keyboard</a>
     */
    public int maxA(int n) {
        // todo
        return 0;
    }

    /**
     * 652. Find Duplicate Subtrees (Medium)
     *
     * @see Solution201#Codec(TreeNode)
     * @see Solution401#CodecDriver(TreeNode)
     * @see Solution601#tree2str(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/find-duplicate-subtrees/">Find Duplicate
     * Subtrees</a>
     */
    public TreeNode[] findDuplicateSubtrees(TreeNode root) {
        // todo
        return new TreeNode[0];
    }

    /**
     * 653. Two Sum IV - Input is a BST (Easy)
     *
     * @see Solution1#twoSum(int[], int)
     * @see Solution101#twoSumII(int[], int)
     * @see Solution101#twoSumII(int[], int)
     * @see TwoSum
     * @see Solution1201#twoSumBSTs(TreeNode, TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/">Two Sum IV - Input
     * is a BST</a>
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
    }

    /**
     * 654. Maximum Binary Tree (Medium)
     *
     * @see Solution901#insertIntoMaxTree(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/maximum-binary-tree/">Maximum Binary Tree</a>
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // todo
        return new TreeNode();
    }

    /**
     * 655. Print Binary Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/print-binary-tree/">Print Binary Tree</a>
     */
    public String[][] printTree(TreeNode root) {
        // todo
        return new String[0][0];
    }

    /**
     * 656. Coin Path (Hard)
     *
     * @see Solution101#rob(int[])
     * @see Solution201#rob(int[])
     * @see <a href="https://leetcode-cn.com/problems/coin-path/">Coin Path</a>
     */
    public int[] cheapestJump(int[] coins, int maxJump) {
        // todo
        return new int[0];
    }

    /**
     * 657. Robot Return to Origin (Easy)
     *
     * @see Solution501#findCircleNum(int[][])
     * @see <a href="https://leetcode-cn.com/problems/robot-return-to-origin/">Robot Return to
     * Origin</a>
     */
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] chars = moves.toCharArray();
        for (char ch : chars) {
            if (ch == 'U') {
                x++;
            } else if (ch == 'D') {
                x--;
            } else if (ch == 'L') {
                y--;
            } else {
                y++;
            }
        }
        return x == 0 && y == 0;
    }

    /**
     * 658. Find K Closest Elements (Medium)
     *
     * @see Solution301#guessNumber(int)
     * @see Solution301#getMoneyAmount(int)
     * @see Solution701#smallestDistancePair(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/find-k-closest-elements/">Find K Closest
     * Elements</a>
     */
    public int[] findClosestElements(int[] arr, int k, int x) {
        // todo
        return new int[0];
    }

    /**
     * 659. Split Array into Consecutive Subsequences (Medium)
     *
     * @see Solution301#topKFrequent(int[], int)
     * @see Solution1201#isPossibleDivide(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/">Split
     * Array into Consecutive Subsequences</a>
     */
    public boolean isPossible(int[] nums) {
        // todo
        return false;
    }

    /**
     * 660. Remove 9 (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/remove-9/">Remove 9</a>
     */
    public int newInteger(int n) {
        // todo
        return 0;
    }

    /**
     * 661. Image Smoother (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/image-smoother/">Image Smoother</a>
     */
    public int[][] imageSmoother(int[][] img) {
        // todo
        return null;
    }

    /**
     * 662. Maximum Width of Binary Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/maximum-width-of-binary-tree/">Maximum Width
     * of Binary Tree</a>
     */
    public int widthOfBinaryTree(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 663. Equal Tree Partition (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/equal-tree-partition/">Equal Tree
     * Partition</a>
     */
    public boolean checkEqualTree(TreeNode root) {
        // todo
        return false;
    }

    /**
     * 664. Strange Printer (Hard)
     *
     * @see Solution501#removeBoxes(int[])
     * @see Solution1501#isPrintable(int[][])
     * @see <a href="https://leetcode-cn.com/problems/strange-printer/">Strange Printer</a>
     */
    public int strangePrinter(String s) {
        // todo
        return 0;
    }

    /**
     * 665. Non-decreasing Array (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/non-decreasing-array/">Non-decreasing
     * Array</a>
     */
    public boolean checkPossibility(int[] nums) {
        // todo
        return false;
    }

    /**
     * 666. Path Sum IV (Medium)
     *
     * @see Solution101#hasPathSum(TreeNode, int)
     * @see Solution101#pathSum(TreeNode, int)
     * @see Solution101#maxPathSum(TreeNode)
     * @see Solution401#pathSum(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/path-sum-iv/">Path Sum IV</a>
     */
    public int pathSum(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 667. Beautiful Arrangement II (Medium)
     *
     * @see Solution501#countArrangement(int)
     * @see <a href="https://leetcode-cn.com/problems/beautiful-arrangement-ii/">Beautiful
     * Arrangement II</a>
     */
    public int[] constructArray(int n, int k) {
        // todo
        return new int[0];
    }

    /**
     * 668. Kth Smallest Number in Multiplication Table (Hard)
     *
     * @see Solution301#kthSmallest(int[][], int)
     * @see Solution701#smallestDistancePair(int[], int)
     * @see Solution701#kthSmallestPrimeFraction(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/">Kth
     * Smallest Number in Multiplication Table</a>
     */
    public int findKthNumber(int m, int n, int k) {
        // todo
        return 0;
    }

    /**
     * 669. Trim a Binary Search Tree (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/trim-a-binary-search-tree/">Trim a Binary
     * Search Tree</a>
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // todo
        return new TreeNode();
    }

    /**
     * 670. Maximum Swap (Medium)
     *
     * @see Solution301#maxNumber(int[], int[], int)
     * @see <a href="https://leetcode-cn.com/problems/maximum-swap/">Maximum Swap</a>
     */
    public int maximumSwap(int num) {
        // todo
        return 0;
    }

    /**
     * 671. Second Minimum Node In a Binary Tree (Easy)
     *
     * @see Solution201#kthSmallest(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/">Second
     * Minimum Node In a Binary Tree</a>
     */
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        if (root.left != null) {
            int left = root.left.val, right = root.right.val;
            if (left == min) {
                left = findSecondMinimumValue(root.left);
            }
            if (right == min) {
                right = findSecondMinimumValue(root.right);
            }
            if (left == -1) {
                return right;
            }
            if (right == -1) {
                return left;
            }
            return Math.min(left, right);
        }
        return -1;
    }

    /**
     * 672. Bulb Switcher II (Medium)
     *
     * @see Solution301#bulbSwitch(int)
     * @see Solution1301#numTimesAllBlue(int[])
     * @see <a href="https://leetcode-cn.com/problems/bulb-switcher-ii/">Bulb Switcher II</a>
     */
    public int flipLights(int n, int presses) {
        // todo
        return 0;
    }

    /**
     * 673. Number of Longest Increasing Subsequence (Medium)
     *
     * @see Solution201#lengthOfLIS(int[])
     * @see Solution601#findLengthOfLCIS(int[])
     * @see <a href="https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/">Number
     * of Longest Increasing Subsequence</a>
     */
    public int findNumberOfLIS(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 674. Longest Continuous Increasing Subsequence (Easy)
     *
     * @see Solution601#findNumberOfLIS(int[])
     * @see Solution701#minWindow(String, String)
     * @see <a href="https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/">Longest
     * Continuous Increasing Subsequence</a>
     */
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int res = 1, count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                if (count > res) {
                    res = count;
                }
                count = 1;
            }
        }
        return Math.max(res, count);
    }

    /**
     * 675. Cut Off Trees for Golf Event (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/cut-off-trees-for-golf-event/">Cut Off Trees
     * for Golf Event</a>
     */
    public int cutOffTree(int[][] forest) {
        // todo
        return 0;
    }


    /**
     * 678. Valid Parenthesis String (Medium)
     *
     * @see Solution701#makeLargestSpecial(String)
     * @see <a href="https://leetcode-cn.com/problems/valid-parenthesis-string/">Valid Parenthesis
     * String</a>
     */
    public boolean checkValidString(String s) {
        // todo
        return false;
    }

    /**
     * 679. 24 Game (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/24-game/">24 Game</a>
     */
    public boolean judgePoint24(int[] cards) {
        // todo
        return false;
    }

    /**
     * 680. Valid Palindrome II (Easy)
     *
     * @see Solution101#isPalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/valid-palindrome-ii/">Valid Palindrome II</a>
     */
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right && chars[left] == chars[right]) {
            left++;
            right--;
        }
        return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right - 1);
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 681. Next Closest Time (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/next-closest-time/">Next Closest Time</a>
     */
    public String nextClosestTime(String time) {
        // todo
        return "";
    }

    /**
     * 682. Baseball Game (Easy)
     *
     * @see Solution1501#minOperations(String[])
     * @see <a href="https://leetcode-cn.com/problems/baseball-game/">Baseball Game</a>
     */
    public int calPoints(String[] ops) {
        int[] points = new int[ops.length];
        int i = 0;
        for (String op : ops) {
            if ("C".equals(op)) {
                points[--i] = 0;
            } else if ("D".equals(op)) {
                points[i] = 2 * points[i - 1];
                i++;
            } else if ("+".equals(op)) {
                points[i] = points[i - 1] + points[i - 2];
                i++;
            } else {
                points[i++] = Integer.parseInt(op);
            }
        }
        int sum = 0;
        for (int point : points) {
            sum += point;
        }
        return sum;
    }

    /**
     * 683. K Empty Slots (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/k-empty-slots/">K Empty Slots</a>
     */
    public int kEmptySlots(int[] bulbs, int k) {
        // todo
        return 0;
    }

    /**
     * 684. Redundant Connection (Medium)
     *
     * @see Solution601#findRedundantDirectedConnection(int[][])
     * @see Solution701#accountsMerge(String[][])
     * @see <a href="https://leetcode-cn.com/problems/redundant-connection/">Redundant
     * Connection</a>
     */
    public int[] findRedundantConnection(int[][] edges) {
        // todo
        return new int[0];
    }

    /**
     * 685. Redundant Connection II (Hard)
     *
     * @see Solution601#findRedundantConnection(int[][])
     * @see <a href="https://leetcode-cn.com/problems/redundant-connection-ii/">Redundant Connection
     * II</a>
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // todo
        return new int[0];
    }

    /**
     * 686. Repeated String Match (Medium)
     *
     * @see Solution401#repeatedSubstringPattern(String)
     * @see <a href="https://leetcode-cn.com/problems/repeated-string-match/">Repeated String
     * Match</a>
     */
    public int repeatedStringMatch(String a, String b) {
        // todo
        return 0;
    }

    /**
     * 687. Longest Univalue Path (Medium)
     *
     * @see Solution101#maxPathSum(TreeNode)
     * @see Solution201#countUnivalSubtrees(TreeNode)
     * @see Solution401#pathSum(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/longest-univalue-path/">Longest Univalue
     * Path</a>
     */
    public int longestUnivaluePath(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 688. Knight Probability in Chessboard (Medium)
     *
     * @see Solution501#findPaths(int, int, int, int, int)
     * @see <a href="https://leetcode-cn.com/problems/knight-probability-in-chessboard/">Knight
     * Probability in Chessboard</a>
     */
    public double knightProbability(int n, int k, int row, int column) {
        // todo
        return 0.0;
    }

    /**
     * 689. Maximum Sum of 3 Non-Overlapping Subarrays (Hard)
     *
     * @see Solution101#maxProfit(int[])
     * @see <a href="https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/">Maximum
     * Sum of 3 Non-Overlapping Subarrays</a>
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // todo
        return new int[0];
    }

    /**
     * 690. Employee Importance (Easy)
     *
     * @see Solution301#depthSum(NestedInteger[])
     * @see <a href="https://leetcode-cn.com/problems/employee-importance/">Employee Importance</a>
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        int res = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.remove();
            res += employee.importance;
            for (int sid : employee.subordinates) {
                queue.add(map.get(sid));
            }
        }
        return res;
    }

    /**
     * 691. Stickers to Spell Word (Hard)
     *
     * @see Solution301#canConstruct(String, String)
     * @see <a href="https://leetcode-cn.com/problems/stickers-to-spell-word/">Stickers to Spell
     * Word</a>
     */
    public int minStickers(String[] stickers, String target) {
        // todo
        return 0;
    }

    /**
     * 692. Top K Frequent Words (Medium)
     *
     * @see Solution301#topKFrequent(int[], int)
     * @see Solution901#kClosest(int[][], int)
     * @see Solution1701#sortFeatures(String[], String[])
     * @see <a href="https://leetcode-cn.com/problems/top-k-frequent-words/">Top K Frequent
     * Words</a>
     */
    public String[] topKFrequent(String[] words, int k) {
        // todo
        return new String[0];
    }

    /**
     * 693. Binary Number with Alternating Bits (Easy)
     *
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/binary-number-with-alternating-bits/">Binary
     * Number with Alternating Bits</a>
     */
    public boolean hasAlternatingBits(int n) {
        int bit = n & 1;
        n >>= 1;
        while (n > 0) {
            if ((n & 1) == bit) {
                return false;
            }
            bit = bit ^ 1;
            n >>= 1;
        }
        return true;
    }

    /**
     * 694. Number of Distinct Islands (Medium)
     *
     * @see Solution101#numIslands(char[][])
     * @see Solution701#numDistinctIslands2(int[][])
     * @see Solution1901#countSubIslands(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/number-of-distinct-islands/">Number of
     * Distinct Islands</a>
     */
    public int numDistinctIslands(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 695. Max Area of Island (Medium)
     *
     * @see Solution101#numIslands(char[][])
     * @see Solution401#islandPerimeter(int[][])
     * @see Solution1701#largestSubmatrix(int[][])
     * @see <a href="https://leetcode-cn.com/problems/max-area-of-island/">Max Area of Island</a>
     */
    public int maxAreaOfIsland(int[][] grid) {
        // todo
        return 0;
    }

    /**
     * 696. Count Binary Substrings (Easy)
     *
     * @see Solution201#encode(String[])
     * @see <a href="https://leetcode-cn.com/problems/count-binary-substrings/">Count Binary
     * Substrings</a>
     */
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = s.length(), preCount = 0, count = 0;
        char ch = '/';
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ch) {
                count++;
            } else {
                res += Math.min(preCount, count);
                preCount = count;
                count = 1;
                ch = chars[i];
            }
        }
        res += Math.min(preCount, count);
        return res;
    }

    /**
     * 697. Degree of an Array (Easy)
     *
     * @see Solution1#maxSubArray(int[])
     * @see <a href="https://leetcode-cn.com/problems/degree-of-an-array/">Degree of an Array</a>
     */
    public int findShortestSubArray(int[] nums) {
        // value: count of the key, first index, last index
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                value[0]++;
                value[2] = i;
            }
        }
        int degree = 0, res = nums.length;
        for (int[] value : map.values()) {
            if (value[0] > degree) {
                degree = value[0];
                res = value[2] - value[1];
            } else if (value[0] == degree) {
                res = Math.min(value[2] - value[1], res);
            }
        }
        return res + 1;
    }

    /**
     * 698. Partition to K Equal Sum Subsets (Medium)
     *
     * @see Solution401#canPartition(int[])
     * @see <a href="https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/">Partition
     * to K Equal Sum Subsets</a>
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // todo
        return false;
    }

    /**
     * 699. Falling Squares (Hard)
     *
     * @see Solution201#getSkyline(int[][])
     * @see <a href="https://leetcode-cn.com/problems/falling-squares/">Falling Squares</a>
     */
    public int[] fallingSquares(int[][] positions) {
        // todo
        return new int[0];
    }

    /**
     * 700. Search in a Binary Search Tree (Easy)
     *
     * @see Solution201#closestValue(TreeNode, double)
     * @see Solution701#insertIntoBST(TreeNode, int)
     * @see <a href="https://leetcode-cn.com/problems/search-in-a-binary-search-tree/">Search in a
     * Binary Search Tree</a>
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        int value = root.val;
        if (val == value) {
            return root;
        }
        if (val > value) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}