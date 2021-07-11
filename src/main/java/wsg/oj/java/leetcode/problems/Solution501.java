package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * Solutions to problems No.501-No.600.
 *
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution501 implements Solution {

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