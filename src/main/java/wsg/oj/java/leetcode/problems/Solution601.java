package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * Solutions to problems No.601-No.700.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution601 implements Solution {


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
     * 690. Employee Importance (Easy)
     *
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