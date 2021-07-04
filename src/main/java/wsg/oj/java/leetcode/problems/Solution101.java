package wsg.oj.java.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.Solution116.Node;
import wsg.oj.java.leetcode.problems.base.ListNode;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * @author Kingen
 * @since 2021/6/25
 */
public class Solution101 extends Solution {

    /**
     * 101. Symmetric Tree (Easy)
     *
     * @see <a href="https://leetcode-cn.com/problems/symmetric-tree/">Symmetric Tree</a>
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        return right != null && left.val == right.val
            && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 102. Binary Tree Level Order Traversal (Medium)
     *
     * @see #BFS
     * @see Solution101#zigzagLevelOrder(TreeNode)
     * @see Solution101#levelOrderBottom(TreeNode)
     * @see Solution101#minDepth(TreeNode)
     * @see Solution301#verticalOrder(TreeNode)
     * @see Solution601#averageOfLevels(TreeNode)
     * @see Solution401#levelOrder(int)
     * @see Solution901#isCousins(TreeNode, int, int)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">Binary
     * Tree Level Order Traversal</a>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    /**
     * 103. Binary Tree Zigzag Level Order Traversal (Medium)
     *
     * @see #BFS
     * @see Solution101#levelOrder(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">Binary
     * Tree Zigzag Level Order Traversal</a>
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean inverted = false;
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (inverted) {
                Collections.reverse(level);
            }
            res.add(level);
            inverted = !inverted;
        }
        return res;
    }

    /**
     * 104. Maximum Depth of Binary Tree (Easy)
     *
     * @see Solution101#isBalanced(TreeNode)
     * @see Solution101#minDepth(TreeNode)
     * @see Solution501#maxDepth(Solution501.Node)
     * @see Solution1301#numOfMinutes(int, int, int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">Maximum Depth
     * of Binary Tree</a>
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 105. Construct Binary Tree from Preorder and Inorder Traversal (Medium)
     *
     * @see Solution101#buildTree(int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct
     * Binary Tree from Preorder and Inorder Traversal</a>
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }

    /**
     * Builds a subtree.
     *
     * @param sp  the start index of the subtree in the preorder
     * @param si  the start index of the subtree in the inorder
     * @param len the total numbers of nodes in the subtree
     * @return the root of the subtree
     */
    private TreeNode buildTree(int[] preorder, int sp, int[] inorder, int si, int len) {
        TreeNode node = new TreeNode(preorder[sp]);
        // find the index of the root node in the inorder
        int ri = si;
        while (inorder[ri] != node.val) {
            ri++;
        }
        int leftLen = ri - si;
        if (leftLen > 0) {
            // there is left child node
            node.left = buildTree(preorder, sp + 1, inorder, si, leftLen);
        }
        int rightLen = len - leftLen - 1;
        if (rightLen > 0) {
            // there is right child node
            node.right = buildTree(preorder, sp + 1 + leftLen, inorder, si + leftLen + 1, rightLen);
        }
        return node;
    }

    /**
     * 105.2 Construct Binary Tree from Preorder and Inorder Traversal (Medium) (Inorder)
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int len = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        int inIdx = 0;
        stack.push(root);
        for (int i = 1; i < len; i++) {
            TreeNode node = stack.peek();
            if (inorder[inIdx] != node.val) {
                // there is a left child node
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                // reach the leftmost leaf node, rollback to ancestor node that has right subtree
                do {
                    node = stack.pop();
                    inIdx++;
                } while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]);
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 106. Construct Binary Tree from Inorder and Postorder Traversal (Medium)
     *
     * @see Solution101#buildTree(int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Construct
     * Binary Tree from Inorder and Postorder Traversal</a>
     */
    public TreeNode buildTreeII(int[] inorder, int[] postorder) {
        return buildTreeII(inorder, 0, postorder, 0, postorder.length);
    }

    /**
     * Builds a subtree.
     *
     * @param si  the start index of the subtree in the inorder
     * @param sp  the start index of the subtree in the postorder
     * @param len the total numbers of nodes in the subtree
     * @return the root of the subtree
     */
    private TreeNode buildTreeII(int[] inorder, int si, int[] postorder, int sp, int len) {
        TreeNode node = new TreeNode(postorder[sp + len - 1]);
        // find the index of the root node in the inorder
        int ri = si;
        while (inorder[ri] != node.val) {
            ri++;
        }
        int leftLen = ri - si;
        if (leftLen > 0) {
            // there is left child node
            node.left = buildTreeII(inorder, si, postorder, sp, leftLen);
        }
        int rightLen = len - leftLen - 1;
        if (rightLen > 0) {
            // there is right child node
            node.right = buildTreeII(inorder, si + leftLen + 1, postorder, sp + leftLen, rightLen);
        }
        return node;
    }

    /**
     * 106.2 Construct Binary Tree from Inorder and Postorder Traversal (Medium) (Inorder)
     *
     * @see #TIME_N
     * @see #SPACE_LOG_N
     * @see #buildTree2(int[], int[])
     */
    public TreeNode buildTreeII2(int[] inorder, int[] postorder) {
        int len = postorder.length;
        TreeNode root = new TreeNode(postorder[len - 1]);
        Stack<TreeNode> stack = new Stack<>();
        int inIdx = inorder.length - 1;
        stack.push(root);
        for (int i = len - 2; i >= 0; i--) {
            TreeNode node = stack.peek();
            if (inorder[inIdx] != node.val) {
                // there is a right child node
                node.right = new TreeNode(postorder[i]);
                stack.push(node.right);
            } else {
                // reach the rightmost leaf node, rollback to ancestor node that has left subtree
                do {
                    node = stack.pop();
                    inIdx--;
                } while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]);
                node.left = new TreeNode(postorder[i]);
                stack.push(node.left);
            }
        }
        return root;
    }

    /**
     * 107. Binary Tree Level Order Traversal II (Medium)
     *
     * @see Solution101#levelOrder(TreeNode)
     * @see Solution601#averageOfLevels(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">Binary
     * Tree Level Order Traversal II</a>
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = levelOrder(root);
        Collections.reverse(res);
        return res;
    }

    /**
     * 108. Convert Sorted Array to Binary Search Tree (Easy)
     *
     * @see Solution101#sortedListToBST(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/">Convert
     * Sorted Array to Binary Search Tree</a>
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) >> 1;
        TreeNode left = sortedArrayToBST(nums, low, mid - 1);
        TreeNode right = sortedArrayToBST(nums, mid + 1, high);
        return new TreeNode(nums[mid], left, right);
    }

    /**
     * 109. Convert Sorted List to Binary Search Tree (Medium)
     *
     * @see #TIME_N
     * @see Solution101#sortedArrayToBST(int[])
     * @see <a href="https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/">Convert
     * Sorted List to Binary Search Tree</a>
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode cursor = head.next;
        while (cursor != null) {
            cursor = cursor.next;
            len++;
        }
        TreeNode root = new TreeNode();
        buildTree(root, head, len);
        return root;
    }

    /**
     * @param node the tree to be built
     * @param len  the total numbers of nodes of the tree
     * @return remaining list nodes
     */
    private ListNode buildTree(TreeNode node, ListNode remaining, int len) {
        int mid = len >>> 1;
        if (mid > 0) {
            // there is left subtree
            node.left = new TreeNode();
            remaining = buildTree(node.left, remaining, mid);
        }
        node.val = remaining.val;
        remaining = remaining.next;
        int rightLen = len - mid - 1;
        if (rightLen > 0) {
            // there is right subtree
            node.right = new TreeNode();
            remaining = buildTree(node.right, remaining, rightLen);
        }
        return remaining;
    }

    /**
     * 110. Balanced Binary Tree (Easy)
     *
     * @see Solution101#maxDepth(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/balanced-binary-tree/">Balanced Binary
     * Tree</a>
     */
    public boolean isBalanced(TreeNode root) {
        return balancedAndHeight(root) >= 0;
    }

    /**
     * @return the height of the node, or -1 if the node is not balanced
     */
    private int balancedAndHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = balancedAndHeight(node.left);
        if (left < 0) {
            // not balanced subtree
            return -1;
        }
        int right = balancedAndHeight(node.right);
        if (right < 0) {
            // not balanced subtree
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            // not balanced
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 111. Minimum Depth of Binary Tree (Easy)
     *
     * @see Solution101#levelOrder(TreeNode)
     * @see Solution101#maxDepth(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">Minimum Depth
     * of Binary Tree</a>
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    /**
     * 112. Path Sum (Easy)
     *
     * @see Solution101#pathSum(TreeNode, int)
     * @see Solution101#maxPathSum(TreeNode)
     * @see Solution101#sumNumbers(TreeNode)
     * @see Solution401#pathSum(TreeNode, int)
     * @see Solution601#pathSum(int[])
     * @see <a href="https://leetcode-cn.com/problems/path-sum/">Path Sum</a>
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            // leaf
            return root.val == targetSum;
        }
        int subSum = targetSum - root.val;
        return hasPathSum(root.left, subSum) || hasPathSum(root.right, subSum);
    }

    /**
     * 113. Path Sum II (Medium)
     *
     * @see #PREORDER
     * @see Solution101#hasPathSum(TreeNode, int)
     * @see Solution201#binaryTreePaths(TreeNode)
     * @see Solution401#pathSum(TreeNode, int)
     * @see Solution601#pathSum(int[])
     * @see <a href="https://leetcode-cn.com/problems/path-sum-ii/">Path Sum II</a>
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(res, root, new ArrayList<>(), targetSum);
        return res;
    }

    private void pathSum(List<List<Integer>> res, TreeNode node, List<Integer> temp, int target) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            // find a path
            res.add(new ArrayList<>(temp));
        }
        pathSum(res, node.left, temp, target);
        pathSum(res, node.right, temp, target);
        temp.remove(temp.size() - 1);
    }

    /**
     * 114. Flatten Binary Tree to Linked List (Medium)
     *
     * @see Solution401#flatten(ListNode)
     * @see Solution1601#correctBinaryTree(TreeNode, int, int)
     * @see <a href="https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/">Flatten
     * Binary Tree to Linked List</a>
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // store the right nodes
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                if (node.right == null) {
                    if (stack.isEmpty()) {
                        // reach the end
                        break;
                    }
                    // switch the branch
                    node.right = stack.pop();
                }
            } else {
                if (node.right != null) {
                    // cache the right node
                    stack.push(node.right);
                }
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

    /**
     * 114.2 Flatten Binary Tree to Linked List (Medium)
     */
    public void flatten2(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                if (node.right != null) {
                    // append the right subtree after the rightmost of the left subtree
                    TreeNode cursor = node.left;
                    while (cursor.right != null) {
                        cursor = cursor.right;
                    }
                    cursor.right = node.right;
                }
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

    /**
     * 115. Distinct Subsequences (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/distinct-subsequences/">Distinct
     * Subsequences</a>
     */
    public int numDistinct(String s, String t) {
        // todo
        return 0;
    }

    /**
     * 118. Pascal's Triangle (Easy)
     *
     * @see Solution101#getRow(int)
     * @see <a href="https://leetcode-cn.com/problems/pascals-triangle/">Pascal's Triangle</a>
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<>(numRows);
        List<Integer> last = List.of(1);
        listList.add(last);
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>(last.size() + 1);
            current.add(1);
            for (int j = 1, lastSize = last.size(); j < lastSize; j++) {
                current.add(last.get(j - 1) + last.get(j));
            }
            current.add(1);
            listList.add(current);
            last = current;
        }
        return listList;
    }

    /**
     * 119. Pascal's Triangle II (Easy)
     *
     * @see Solution101#generate(int)
     * @see <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = List.of(1);
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> current = new ArrayList<>(last.size() + 1);
            current.add(1);
            for (int j = 1, lastSize = last.size(); j < lastSize; j++) {
                current.add(last.get(j - 1) + last.get(j));
            }
            current.add(1);
            last = current;
        }
        return last;
    }

    /**
     * 119.2 Pascal's Triangle II (Easy)
     * <p>
     * Each row is a group of binomial coefficients.
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long last = 1;
        res.add((int) last);
        for (int i = 0; i < rowIndex; i++) {
            last = last * (rowIndex - i) / (i + 1);
            res.add((int) last);
        }
        return res;
    }

    /**
     * 120. Triangle (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see #TIME_N
     * @see #SPACE_LOG_N
     * @see <a href="https://leetcode-cn.com/problems/triangle/">Triangle</a>
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] res = new int[size];
        List<Integer> bottom = triangle.get(size - 1);
        for (int i = 0; i < size; i++) {
            res[i] = bottom.get(i);
        }
        for (int level = size - 2; level >= 0; level--) {
            List<Integer> values = triangle.get(level);
            for (int i = 0; i <= level; i++) {
                // res[i]: the minimum path sum of the triangle with vertex [level, i]
                res[i] = Math.min(res[i], res[i + 1]) + values.get(i);
            }
        }
        return res[0];
    }

    /**
     * 121. Best Time to Buy and Sell Stock (Easy)
     *
     * @see Solution1#maxSubArray(int[])
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfit(int, int[])
     * @see Solution301#maxProfit(int[])
     * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">Best Time to
     * Buy and Sell Stock</a>
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }

    /**
     * 122. Best Time to Buy and Sell Stock II (Easy)
     *
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfit(int, int[])
     * @see Solution301#maxProfit(int[])
     * @see Solution701#maxProfit(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time
     * to Buy and Sell Stock II</a>
     */
    public int maxProfitII(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - min;
                min = prices[i];
            }
        }
        profit += prices[prices.length - 1] - min;
        return profit;
    }

    /**
     * 123. Best Time to Buy and Sell Stock III (Hard)
     *
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfit(int, int[])
     * @see Solution601#maxSumOfThreeSubarrays(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/">Best
     * Time to Buy and Sell Stock III</a>
     */
    public int maxProfitIII(int[] prices) {
        // todo
        return 0;
    }

    /**
     * 124. Binary Tree Maximum Path Sum (Hard)
     *
     * @see Solution101#hasPathSum(TreeNode, int)
     * @see Solution101#sumNumbers(TreeNode)
     * @see Solution601#pathSum(int[])
     * @see Solution601#longestUnivaluePath(TreeNode)
     * @see Solution1301#numOfMinutes(int, int, int[], int[])
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">Binary Tree
     * Maximum Path Sum</a>
     */
    public int maxPathSum(TreeNode root) {
        // todo
        return 0;
    }

    /**
     * 125. Valid Palindrome (Easy)
     *
     * @see Solution201#isPalindrome(ListNode)
     * @see Solution601#validPalindrome(String)
     * @see <a href="https://leetcode-cn.com/problems/valid-palindrome/">Valid Palindrome</a>
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (notAlphanumeric(chars[left])) {
                left++;
            } else if (notAlphanumeric(chars[right])) {
                right--;
            } else {
                if (Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean notAlphanumeric(char aChar) {
        return (aChar < '0' || aChar > '9')
            && (aChar < 'A' || aChar > 'Z')
            && (aChar < 'a' || aChar > 'z');
    }

    /**
     * 126. Word Ladder II (Hard)
     *
     * @see Solution101#ladderLength(String, String, String[])
     * @see <a href="https://leetcode-cn.com/problems/word-ladder-ii/">Word Ladder II</a>
     */
    public String[][] findLadders(String beginWord, String endWord, String[] wordList) {
        // todo
        return new String[0][0];
    }

    /**
     * 127. Word Ladder (Hard)
     *
     * @see Solution101#findLadders(String, String, String[])
     * @see Solution401#minMutation(String, String, String[])
     * @see <a href="https://leetcode-cn.com/problems/word-ladder/">Word Ladder</a>
     */
    public int ladderLength(String beginWord, String endWord, String[] wordList) {
        // todo
        return 0;
    }

    /**
     * 128. Longest Consecutive Sequence (Medium)
     *
     * @see #TIME_N_LOG_N
     * @see #SPACE_CONSTANT
     * @see Solution201#longestConsecutive(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/longest-consecutive-sequence/">Longest
     * Consecutive Sequence</a>
     */
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1, count = 1, last = nums[0];
        for (int i = 1; i < len; i++) {
            int dif = nums[i] - last;
            if (dif > 0) {
                if (dif > 1) {
                    max = Math.max(max, count);
                    count = 1;
                } else {
                    count++;
                }
                last = nums[i];
            }
        }
        return Math.max(max, count);
    }

    /**
     * 129. Sum Root to Leaf Numbers (Medium)
     *
     * @see #BACKTRACKING
     * @see Solution101#hasPathSum(TreeNode, int)
     * @see Solution101#maxPathSum(TreeNode)
     * @see Solution901#smallestFromLeaf(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">Sum Root to Leaf
     * Numbers</a>
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int temp) {
        if (node.left == null && node.right == null) {
            // find a path
            return temp * 10 + node.val;
        }
        int sum = 0;
        temp = temp * 10 + node.val;
        if (node.left != null) {
            sum += sumNumbers(node.left, temp);
        }
        if (node.right != null) {
            sum += sumNumbers(node.right, temp);
        }
        return sum;
    }

    /**
     * 130. Surrounded Regions (Medium)
     *
     * @see #BACKTRACKING
     * @see Solution101#numIslands(char[][])
     * @see Solution201#wallsAndGates(int[][])
     * @see <a href="https://leetcode-cn.com/problems/surrounded-regions/">Surrounded Regions</a>
     */
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        // the first and last columns
        for (int i = 0; i < m; i++) {
            flip(board, i, 0);
        }
        if (n > 1) {
            int j = n - 1;
            for (int i = 0; i < m; i++) {
                flip(board, i, j);
            }
        }
        // the first and last rows
        for (int j = 0; j < n; j++) {
            flip(board, 0, j);
        }
        if (m > 1) {
            int i = m - 1;
            for (int j = 0; j < n; j++) {
                flip(board, i, j);
            }
        }
        // flip all left 'O's
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        // flip 'N's back to 'O's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void flip(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            // out of range
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        // mark as not-flipped
        board[i][j] = 'N';
        flip(board, i - 1, j);
        flip(board, i + 1, j);
        flip(board, i, j - 1);
        flip(board, i, j + 1);
    }

    /**
     * 131. Palindrome Partitioning (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see #BACKTRACKING
     * @see Solution101#minCut(String)
     * @see Solution1701#checkPartitioning(String)
     * @see <a href="https://leetcode-cn.com/problems/palindrome-partitioning/">Palindrome
     * Partitioning</a>
     */
    public List<List<String>> partition(String s) {
        int len = s.length();
        // i: the start index of the substring
        // c: the length of the substring
        // res[i][c]: whether s[i,i+c) is palindrome
        boolean[][] flags = new boolean[len][len + 1];
        for (int i = 0; i < len; i++) {
            // the length of the substring is 1
            flags[i][0] = true;
            flags[i][1] = true;
        }
        for (int c = 2; c <= len; c++) {
            for (int i = 0, n = len - c; i <= n; i++) {
                flags[i][c] = s.charAt(i) == s.charAt(i + c - 1) && flags[i + 1][c - 2];
            }
        }

        List<List<String>> res = new ArrayList<>();
        partition(res, s.toCharArray(), flags, new ArrayList<>(), 0);
        return res;
    }

    private void partition(List<List<String>> res, char[] chars, boolean[][] flags,
        List<String> temp, int start) {
        if (start == chars.length) {
            // reach the end
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int c = 1, maxCount = chars.length - start; c <= maxCount; c++) {
            if (flags[start][c]) {
                temp.add(new String(chars, start, c));
                partition(res, chars, flags, temp, start + c);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * 132. Palindrome Partitioning II (Hard)
     *
     * @see Solution101#partition(String)
     * @see Solution1701#checkPartitioning(String)
     * @see <a href="https://leetcode-cn.com/problems/palindrome-partitioning-ii/">Palindrome
     * Partitioning II</a>
     */
    public int minCut(String s) {
        // todo
        return 0;
    }

    /**
     * 134. Gas Station (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/gas-station/">Gas Station</a>
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // todo
        return 0;
    }

    /**
     * 135. Candy (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/candy/">Candy</a>
     */
    public int candy(int[] ratings) {
        // todo
        return 0;
    }

    /**
     * 136. Single Number (Easy)
     *
     * @see Solution101#singleNumber(int[])
     * @see Solution201#singleNumber(int[])
     * @see Solution201#missingNumber(int[])
     * @see Solution201#findDuplicate(int[])
     * @see Solution301#findTheDifference(String, String)
     * @see <a href="https://leetcode-cn.com/problems/single-number/">Single Number</a>
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }

    /**
     * 137. Single Number II (Medium)
     *
     * @see Solution101#singleNumber(int[])
     * @see Solution201#singleNumber(int[])
     * @see <a href="https://leetcode-cn.com/problems/single-number-ii/">Single Number II</a>
     */
    public int singleNumberII(int[] nums) {
        // x->(x,0)->(0,x)->(0,0)
        int a = 0, b = 0;
        for (int num : nums) {
            a = (num ^ a) & ~b;
            b = (num ^ b) & ~a;
        }
        return a;
    }

    /**
     * 139. Word Break (Medium)
     *
     * @see #DYNAMIC_PROGRAMMING
     * @see Solution101#wordBreakII(String, String[])
     * @see <a href="https://leetcode-cn.com/problems/word-break/">Word Break</a>
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // dp[i]: whether the substring s[0,i) can be broken to dict
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= len; i++) {
            // split s[0,i) into s[0,j)+s[j,i)
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    /**
     * 140. Word Break II (Hard)
     *
     * @see Solution101#wordBreak(String, List)
     * @see Solution401#findAllConcatenatedWordsInADict(String[])
     * @see <a href="https://leetcode-cn.com/problems/word-break-ii/">Word Break II</a>
     */
    public String[] wordBreakII(String s, String[] wordDict) {
        // todo
        return new String[0];
    }

    /**
     * 141. Linked List Cycle (Easy)
     *
     * @see Solution101#detectCycle(ListNode)
     * @see Solution201#isHappy(int)
     * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/">Linked List Cycle</a>
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 142. Linked List Cycle II (Medium)
     *
     * @see #TIME_N
     * @see #SPACE_CONSTANT
     * @see Solution101#hasCycle(ListNode)
     * @see Solution201#findDuplicate(int[])
     * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/">Linked List Cycle
     * II</a>
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 143. Reorder List (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/reorder-list/">Reorder List</a>
     */
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        // cut the list at the middle
        slow.next = null;
        // reverse the right half
        ListNode right = null, cur = mid, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = right;
            right = cur;
            cur = temp;
        }
        // merge the two lists
        ListNode left = head;
        while (right != null) {
            temp = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = temp;
        }
    }

    /**
     * 144. Binary Tree Preorder Traversal (Easy)
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see Solution101#postorderTraversal(TreeNode)
     * @see Solution201#verifyPreorder(int[])
     * @see Solution501#preorder(Solution501.Node)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal/">Binary Tree
     * Preorder Traversal</a>
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(res, root);
        return res;
    }

    private void preorderTraversal(List<Integer> res, TreeNode node) {
        if (node != null) {
            res.add(node.val);
            preorderTraversal(res, node.left);
            preorderTraversal(res, node.right);
        }
    }

    /**
     * 144.2 Binary Tree Preorder Traversal (Easy) (Stack)
     *
     * @see Solution1#inorderTraversal2(TreeNode)
     * @see Solution101#postorderTraversal2(TreeNode)
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                res.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop().right;
        }
        return res;
    }

    /**
     * 145. Binary Tree Postorder Traversal (Easy)
     *
     * @see Solution1#inorderTraversal(TreeNode)
     * @see Solution501#postorder(Solution501.Node)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-postorder-traversal/">Binary Tree
     * Postorder Traversal</a>
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(res, root);
        return res;
    }

    private void postorderTraversal(List<Integer> res, TreeNode node) {
        if (node != null) {
            postorderTraversal(res, node.left);
            postorderTraversal(res, node.right);
            res.add(node.val);
        }
    }

    /**
     * 145.2 Binary Tree Postorder Traversal (Easy) (Stack)
     * <p>
     * todo explain
     *
     * @see Solution101#preorderTraversal2(TreeNode)
     * @see Solution1#inorderTraversal2(TreeNode)
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if (current.right == null || current.right == last) {
                res.add(current.val);
                stack.pop();
                last = current;
                current = null;
            } else {
                current = current.right;
            }
        }
        return res;
    }

    /**
     * 147. Insertion Sort List (Medium)
     *
     * @see Solution101#sortList(ListNode)
     * @see Solution701#insert(ListNode, int)
     * @see <a href="https://leetcode-cn.com/problems/insertion-sort-list/">Insertion Sort List</a>
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode prev = head, cur = prev.next;
        while (cur != null) {
            prev.next = null;
            ListNode node = res;
            while (node.next != null && node.next.val < cur.val) {
                node = node.next;
            }
            if (node == prev) {
                prev.next = cur;
                prev = cur;
            } else {
                prev.next = cur.next;
                cur.next = node.next;
                node.next = cur;
            }
            cur = prev.next;
        }
        return res.next;
    }

    /**
     * 148. Sort List (Medium)
     *
     * @see Solution1#mergeTwoLists(ListNode, ListNode)
     * @see Solution1#sortColors(int[])
     * @see Solution101#insertionSortList(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/sort-list/">Sort List</a>
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0, head);
        ListNode slow = res;
        for (ListNode fast = res; fast != null && fast.next != null; fast = fast.next.next) {
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        slow = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                slow.next = right;
                right = right.next;
            } else {
                slow.next = left;
                left = left.next;
            }
            slow = slow.next;
        }
        if (left != null) {
            slow.next = left;
        }
        if (right != null) {
            slow.next = right;
        }
        return res.next;
    }

    /**
     * 149. Max Points on a Line (Hard)
     *
     * @see Solution301#isReflected(int[][])
     * @see <a href="https://leetcode-cn.com/problems/max-points-on-a-line/">Max Points on a
     * Line</a>
     */
    public int maxPoints(int[][] points) {
        // todo
        return 0;
    }

    /**
     * 150. Evaluate Reverse Polish Notation (Medium)
     *
     * @see Solution201#calculate(String)
     * @see Solution201#addOperators(String, int)
     * @see <a href="https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/">Evaluate
     * Reverse Polish Notation</a>
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            char ch = token.charAt(token.length() - 1);
            if ('+' == ch) {
                stack.push(stack.pop() + stack.pop());
            } else if ('-' == ch) {
                stack.push(-stack.pop() + stack.pop());
            } else if ('*' == ch) {
                stack.push(stack.pop() * stack.pop());
            } else if ('/' == ch) {
                int divisor = stack.pop();
                int dividend = stack.pop();
                stack.push(dividend / divisor);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    /**
     * 151. Reverse Words in a String (Medium)
     *
     * @see Solution101#reverseWords(char[])
     * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string/">Reverse Words in a
     * String</a>
     */
    public String reverseWords(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (builder.length() > 0) {
                    res.add(builder.toString());
                    builder = new StringBuilder();
                }
            } else {
                builder.append(ch);
            }
        }
        if (builder.length() > 0) {
            res.add(builder.toString());
        }
        Collections.reverse(res);
        return String.join(" ", res);
    }

    /**
     * 152. Maximum Product Subarray (Medium)
     *
     * @see Solution1#maxSubArray(int[])
     * @see Solution101#rob(int[])
     * @see Solution201#productExceptSelf(int[])
     * @see Solution601#maximumProduct(int[])
     * @see Solution701#numSubarrayProductLessThanK(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/maximum-product-subarray/">Maximum Product
     * Subarray</a>
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    /**
     * 153. Find Minimum in Rotated Sorted Array (Medium)
     *
     * @see Solution1#search(int[], int)
     * @see Solution101#findMin(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">Find
     * Minimum in Rotated Sorted Array</a>
     */

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                return nums[left];
            }
        }
        return nums[left];
    }

    /**
     * 154. Find Minimum in Rotated Sorted Array II (Hard)
     *
     * @see Solution101#findMin(int[])
     * @see <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/">Find
     * Minimum in Rotated Sorted Array II</a>
     */
    public int findMinII(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 156. Binary Tree Upside Down (Medium)
     *
     * @see Solution201#reverseList(ListNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-upside-down/">Binary Tree Upside
     * Down</a>
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // todo
        return new TreeNode();
    }

    /**
     * 157. Read N Characters Given Read4 (Easy)
     *
     * @see Solution101#read(String, int[])
     * @see <a href="https://leetcode-cn.com/problems/read-n-characters-given-read4/">Read N
     * Characters Given Read4</a>
     */
    public String read(String file, int n) {
        // todo
        return "";
    }

    /**
     * 158. Read N Characters Given Read4 II - Call multiple times (Hard)
     *
     * @see Solution101#read(String, int)
     * @see <a href="https://leetcode-cn.com/problems/read-n-characters-given-read4-ii-call-multiple-times/">Read
     * N Characters Given Read4 II - Call multiple times</a>
     */
    public String[] read(String file, int[] queries) {
        // todo
        return new String[0];
    }

    /**
     * 159. Longest Substring with At Most Two Distinct Characters (Medium)
     *
     * @see Solution1#lengthOfLongestSubstring(String)
     * @see Solution201#maxSlidingWindow(int[], int)
     * @see Solution301#lengthOfLongestSubstringKDistinct(String, int)
     * @see Solution901#subarraysWithKDistinct(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/">Longest
     * Substring with At Most Two Distinct Characters</a>
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // todo
        return 0;
    }

    /**
     * 160. Intersection of Two Linked Lists (Easy)
     *
     * @see Solution501#findRestaurant(String[], String[])
     * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">Intersection
     * of Two Linked Lists</a>
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursorA = headA, cursorB = headB;
        while (cursorA != cursorB) {
            cursorA = cursorA == null ? headB : cursorA.next;
            cursorB = cursorB == null ? headA : cursorB.next;
        }
        return cursorA;
    }

    /**
     * 161. One Edit Distance (Medium)
     *
     * @see Solution1#minDistance(String, String)
     * @see <a href="https://leetcode-cn.com/problems/one-edit-distance/">One Edit Distance</a>
     */
    public boolean isOneEditDistance(String s, String t) {
        // todo
        return false;
    }

    /**
     * 162. Find Peak Element (Medium)
     *
     * @see Solution801#peakIndexInMountainArray(int[])
     * @see Solution1901#findPeakGrid(int[][])
     * @see <a href="https://leetcode-cn.com/problems/find-peak-element/">Find Peak Element</a>
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     * 163. Missing Ranges (Easy)
     *
     * @see Solution201#summaryRanges(int[])
     * @see <a href="https://leetcode-cn.com/problems/missing-ranges/">Missing Ranges</a>
     */
    public String[] findMissingRanges(int[] nums, int lower, int upper) {
        // todo
        return new String[0];
    }

    /**
     * 164. Maximum Gap (Hard)
     *
     * @see <a href="https://leetcode-cn.com/problems/maximum-gap/">Maximum Gap</a>
     */
    public int maximumGap(int[] nums) {
        // todo
        return 0;
    }

    /**
     * 165. Compare Version Numbers (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/compare-version-numbers/">Compare Version
     * Numbers</a>
     */
    public int compareVersion(String version1, String version2) {
        int i1 = 0, i2 = 0, len1 = version1.length(), len2 = version2.length();
        while (i1 < len1 || i2 < len2) {
            int v1 = 0;
            if (i1 < len1) {
                int j1 = i1;
                while (j1 < len1 && version1.charAt(j1) != '.') {
                    j1++;
                }
                v1 = Integer.parseInt(version1, i1, j1, 10);
                i1 = j1 + 1;
            }
            int v2 = 0;
            if (i2 < len2) {
                int j2 = i2;
                while (j2 < len2 && version2.charAt(j2) != '.') {
                    j2++;
                }
                v2 = Integer.parseInt(version2, i2, j2, 10);
                i2 = j2 + 1;
            }
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 166. Fraction to Recurring Decimal (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/fraction-to-recurring-decimal/">Fraction to
     * Recurring Decimal</a>
     */
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if (numerator != 0 && (numerator < 0 ^ denominator < 0)) {
            // negative
            res.append("-");
        }
        // the integer part
        res.append(Math.abs(((long) numerator / denominator)));
        long remainder = numerator % denominator;
        if (remainder == 0) {
            return res.toString();
        }
        res.append(".");
        // appeared remainders
        List<Long> remainders = new ArrayList<>();
        // fraction part
        List<Integer> fractions = new ArrayList<>();
        do {
            int idx = remainders.lastIndexOf(remainder);
            if (idx >= 0) {
                // recurring decimal
                for (int i = 0; i < idx; i++) {
                    res.append(fractions.get(i));
                }
                res.append("(");
                for (int i = idx; i < remainders.size(); i++) {
                    res.append(fractions.get(i));
                }
                return res.append(")").toString();
            }
            remainders.add(remainder);
            remainder *= 10;
            fractions.add((int) Math.abs(remainder / denominator));
            remainder = remainder % denominator;
        } while (remainder != 0);
        for (int fraction : fractions) {
            res.append(fraction);
        }
        return res.toString();
    }

    /**
     * 167. Two Sum II - Input array is sorted (Easy)
     *
     * @see Solution1#twoSum(int[], int)
     * @see Solution601#findTarget(TreeNode, int)
     * @see Solution1001#twoSumLessThanK(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II
     * - Input array is sorted</a>
     */
    public int[] twoSumII(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    /**
     * 168. Excel Sheet Column Title (Easy)
     *
     * @see Solution101#titleToNumber(String)
     * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-title/">Excel Sheet Column
     * Title</a>
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0) {
            int mod = columnNumber % 26;
            if (mod == 0) {
                mod = 26;
            }
            str.insert(0, (char) (64 + mod));
            columnNumber = (columnNumber - mod) / 26;
        }
        return str.toString();
    }

    /**
     * 169. Majority Element (Easy)
     * <p>
     * Boyer–Moore majority vote algorithm: delete/nullify two different numbers from the array
     * every time, then the only left number is the majority one.
     *
     * @see Solution201#majorityElement(int[])
     * @see Solution1101#isMajorityElement(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/majority-element/">Majority Element</a>
     */
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else if (count == 0) {
                count++;
                major = nums[i];
            } else {
                count--;
            }
        }
        return major;
    }

    /**
     * 171. Excel Sheet Column Number (Easy)
     *
     * @see Solution101#convertToTitle(int)
     * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-number/">Excel Sheet Column
     * Number</a>
     */
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (char c : columnTitle.toCharArray()) {
            sum = (c - 64) + sum * 26;
        }
        return sum;
    }

    /**
     * 172. Factorial Trailing Zeroes (Easy)
     *
     * @see Solution201#countDigitOne(int)
     * @see Solution701#preimageSizeFZF(int)
     * @see <a href="https://leetcode-cn.com/problems/factorial-trailing-zeroes/">Factorial Trailing
     * Zeroes</a>
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    /**
     * 174. Dungeon Game (Hard)
     *
     * @see Solution1#uniquePaths(int, int)
     * @see Solution1#minPathSum(int[][])
     * @see Solution701#cherryPickup(int[][])
     * @see <a href="https://leetcode-cn.com/problems/dungeon-game/">Dungeon Game</a>
     */
    public int calculateMinimumHP(int[][] dungeon) {
        // todo
        return 0;
    }

    /**
     * 179. Largest Number (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/largest-number/">Largest Number</a>
     */
    public String largestNumber(int[] nums) {
        boolean positive = false;
        for (int num : nums) {
            if (num > 0) {
                positive = true;
                break;
            }
        }
        if (!positive) {
            // all zeros
            return "0";
        }
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            }
            return (o2 + o1).compareTo(o1 + o2);
        });
        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            res.append(s);
        }
        return res.toString();
    }

    /**
     * 186. Reverse Words in a String II (Medium)
     *
     * @see Solution101#reverseWords(String)
     * @see Solution101#rotate(int[], int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-ii/">Reverse Words
     * in a String II</a>
     */
    public void reverseWords(char[] s) {
        // todo
    }

    /**
     * 187. Repeated DNA Sequences (Medium)
     *
     * @see <a href="https://leetcode-cn.com/problems/repeated-dna-sequences/">Repeated DNA
     * Sequences</a>
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len <= 10) {
            return new ArrayList<>();
        }
        int value = 0;
        // the value of the first 9 digits
        for (int i = 0; i < 9; i++) {
            value = (value << 2) + charToQuaternary(s.charAt(i));
        }
        // key: the quaternary value of the 10-letter-long sequence
        // value: count of same values
        byte[] counts = new byte[1 << 20];
        List<String> res = new ArrayList<>();
        // (1<<(c*2-1))-1
        int base = 0x3ffff;
        // start: the start index of the 10-letter-long sequence
        for (int start = 0, sLen = len - 10; start <= sLen; start++) {
            value = (value << 2) + charToQuaternary(s.charAt(start + 9));
            counts[value]++;
            if (counts[value] == 2) {
                // more than one
                res.add(s.substring(start, start + 10));
            }
            // remove the first digit
            value = value & base;
        }
        return res;
    }

    private int charToQuaternary(char ch) {
        switch (ch) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            default:
                return 3;
        }
    }

    /**
     * 188. Best Time to Buy and Sell Stock IV (Hard)
     *
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfit(int[])
     * @see Solution101#maxProfit(int[])
     * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/">Best Time
     * to Buy and Sell Stock IV</a>
     */
    public int maxProfit(int k, int[] prices) {
        // todo
        return 0;
    }

    /**
     * 189. Rotate Array (Medium)
     *
     * @see Solution1#rotateRight(ListNode, int)
     * @see Solution101#reverseWords(char[])
     * @see <a href="https://leetcode-cn.com/problems/rotate-array/">Rotate Array</a>
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 190. Reverse Bits (Easy)
     * <p>
     * todo study bits
     *
     * @see Integer#reverse(int)
     * @see Solution1#reverse(int)
     * @see Solution101#hammingWeight(int)
     * @see <a href="https://leetcode-cn.com/problems/reverse-bits/">Reverse Bits</a>
     */
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    /**
     * 191. Number of 1 Bits (Easy)
     *
     * @see Solution101#reverseBits(int)
     * @see Solution201#isPowerOfTwo(int)
     * @see Solution301#countBits(int)
     * @see Solution401#readBinaryWatch(int)
     * @see Solution401#hammingDistance(int, int)
     * @see Solution601#hasAlternatingBits(int)
     * @see Solution701#countPrimeSetBits(int, int)
     * @see <a href="https://leetcode-cn.com/problems/number-of-1-bits/">Number of 1 Bits</a>
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 199. Binary Tree Right Side View (Medium)
     *
     * @see #LEVEL_ORDER
     * @see #TIME_N
     * @see #SPACE_LOG_N
     * @see Solution116#connect(Node)
     * @see Solution501#boundaryOfBinaryTree(TreeNode)
     * @see <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">Binary Tree
     * Right Side View</a>
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return res;
    }

    /**
     * 200. Number of Islands (Medium)
     *
     * @see #DFS
     * @see Solution101#solve(char[][])
     * @see Solution201#wallsAndGates(int[][])
     * @see Solution301#numIslands2(int, int, int[][])
     * @see Solution301#countComponents(int, int[][])
     * @see Solution601#numDistinctIslands(int[][])
     * @see Solution601#maxAreaOfIsland(int[][])
     * @see Solution1901#countSubIslands(int[][], int[][])
     * @see <a href="https://leetcode-cn.com/problems/number-of-islands/">Number of Islands</a>
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    sinkIsland(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void sinkIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
            // out of index
            return;
        }
        if (grid[i][j] == '0') {
            // water or sank
            return;
        }
        grid[i][j] = '0';
        sinkIsland(grid, i - 1, j);
        sinkIsland(grid, i + 1, j);
        sinkIsland(grid, i, j - 1);
        sinkIsland(grid, i, j + 1);
    }
}