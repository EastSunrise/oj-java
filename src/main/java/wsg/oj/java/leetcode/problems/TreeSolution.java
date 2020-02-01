package wsg.oj.java.leetcode.problems;

import java.util.*;

/**
 * @author Kingen
 */
public class TreeSolution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return p == q;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null && left.val == right.val)
            return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        return left == right;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (end - start == 0)
            return null;
        if (end - start == 1)
            return new TreeNode(nums[start]);
        int mid = (start + end) >> 1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, start, mid);
        treeNode.right = sortedArrayToBST(nums, mid + 1, end);
        return treeNode;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left * right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == sum;
        if (root.left == null)
            return hasPathSum(root.right, sum - root.val);
        if (root.right == null)
            return hasPathSum(root.left, sum - root.val);

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }

    // 235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node;
        if (p.val > q.val) {
            node = p;
            p = q;
            q = node;
        }
        node = root;
        while (node != null)
            if (node.val < p.val)
                node = node.right;
            else if (q.val < node.val)
                node = node.left;
            else
                return node;
        return null;
    }

    // 257. 二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<String> list = new LinkedList<>();
        for (String path : binaryTreePaths(root.left))
            list.add((root.val + "->" + path));
        for (String path : binaryTreePaths(root.right))
            list.add((root.val + "->" + path));
        if (list.size() == 0)
            list.add(String.valueOf(root.val));
        return list;
    }

    class Entry {
        TreeNode node;
        int level;

        Entry(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // 107. 二叉树的层次遍历 II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root == null)
            return listList;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(root, 0));
        List<Integer> list = new LinkedList<>();
        int curLevel = 0;
        while (!queue.isEmpty()) {
            Entry entry = queue.poll();
            TreeNode node = entry.node;
            int level = entry.level;
            if (node != null) {
                if (level != curLevel) {
                    curLevel = level;
                    listList.add(0, list);
                    list = new LinkedList<>();
                }
                list.add(node.val);
                queue.add(new Entry(node.left, level + 1));
                queue.add(new Entry(node.right, level + 1));
            }
        }
        listList.add(0, list);
        return listList;
    }

    // 404. 左叶子之和
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root != null) {
            if (root.left != null && root.left.left == null && root.left.right == null)
                sum += root.left.val;
            sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    // 429. N叉树的层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root == null)
            return listList;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                list.add(node.val);
                for (Node child : node.children)
                    if (child != null)
                        queue.add(child);
            } else {
                listList.add(list);
                list = new LinkedList<>();
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
        return listList;
    }

    // 437. 路径总和 III
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFromRoot(root, sum);
    }

    private int pathSumFromRoot(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum -= root.val;
        int count = pathSumFromRoot(root.left, sum) + pathSumFromRoot(root.right, sum);
        if (sum == 0)
            count++;
        return count;
    }

    // wsg 501. 二叉搜索树中的众数
    public int[] findMode(TreeNode root) {
        int[] last = new int[3];
        List<Integer> list = new LinkedList<>();
        midTraverseTree(root, last, list);
        if (last[2] > 0) {
            int[] result = new int[list.size()];
            int index = 0;
            for (Integer mode : list)
                result[index++] = mode;
            return result;
        }
        return null;
    }

    // last:lastNum,countOfLastNum,countOfEachMode; mode != null
    private void midTraverseTree(TreeNode root, int[] last, List<Integer> mode) {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            last = new int[]{root.val, 1, 1};
            mode.add(root.val);
        } else {
            midTraverseTree(root.left, last, mode);
            if (root.val == last[0]) {
                last[1]++;
                if (last[1] > last[2]) {
                    mode = new LinkedList<>();
                    mode.add(last[0]);
                    last[2] = 1;
                } else if (last[1] == last[2]) {
                    mode.add(last[0]);
                    last[2]++;
                }
            } else {
                last[0] = root.val;
                last[1] = 1;
            }
        }
        midTraverseTree(root.right, last, mode);
    }

    // 530. 二叉搜索树的最小绝对差
    public int getMinimumDifference(TreeNode root) {
        return getDifference(root)[2];
    }

    // return min,max,minDif
    private int[] getDifference(TreeNode root) {
        if (root == null)
            return null;
        int val = root.val;
        int[] left = getDifference(root.left);
        int[] right = getDifference(root.right);
        int min = val, max = val, minDif = -1;
        if (left != null) {
            min = left[0];
            minDif = val - left[1];
            if (left[2] != -1 && left[2] < minDif)
                minDif = left[2];
        }
        if (right != null) {
            max = right[1];
            int dif = right[0] - val;
            if (minDif == -1 || dif < minDif)
                minDif = dif;
            if (right[2] != -1 && right[2] < minDif)
                minDif = right[2];
        }
        return new int[]{min, max, minDif};
    }

    // 897. 递增顺序查找树
    public TreeNode increasingBST(TreeNode root) {
        return searchTree(root)[0];
    }

    // return first and last node
    private TreeNode[] searchTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode[] left = searchTree(root.left);
        TreeNode[] right = searchTree(root.right);
        TreeNode first = root, last = root;
        if (left != null) {
            first = left[0];
            root.left = null;
            left[1].right = root;
        }
        if (right != null) {
            root.right = right[0];
            last = right[1];
        }
        return new TreeNode[]{first, last};
    }

    // 965. 单值二叉树
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null)
            return true;
        return val == root.val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }

    // 872. 叶子相似的树
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> list1 = getLeaves(root1);
        List<TreeNode> list2 = getLeaves(root2);
        if (list1.size() != list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++)
            if (list1.get(i).val != list2.get(i).val)
                return false;
        return true;
    }

    private List<TreeNode> getLeaves(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<TreeNode> list = getLeaves(root.left);
        list.addAll(getLeaves(root.right));
        if (list.size() == 0)
            list.add(root);
        return list;
    }

    // 700. 二叉搜索树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        int value = root.val;
        if (val == value)
            return root;
        if (val > value)
            return searchBST(root.right, val);
        return searchBST(root.left, val);
    }

    // wsg 687. 最长同值路径
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root.left, right = root.right;
        int leftLen = longestUnivaluePath(left), rightLen = longestUnivaluePath(right);
        if (left != null && left.val == root.val && right != null && right.val == root.val)
            return leftLen + rightLen + 2;
        else if (left != null && left.val == root.val)
            return Math.max(leftLen + 1, rightLen);
        else if (right != null && right.val == root.val)
            return Math.max(leftLen, rightLen + 1);
        return Math.max(leftLen, rightLen);
    }

    // 671. 二叉树中第二小的节点
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        if (root.left != null) {
            int left = root.left.val, right = root.right.val;
            if (left == min)
                left = findSecondMinimumValue(root.left);
            if (right == min)
                right = findSecondMinimumValue(root.right);
            if (left == -1)
                return right;
            if (right == -1)
                return left;
            return Math.min(left, right);
        }
        return -1;
    }

    // wsg 589. N叉树的前序遍历
    public List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        list.add(root.val);
        for (Node child : root.children)
            list.addAll(preOrder(child));
        return list;
    }

    // 653. 两数之和 IV - 输入 BST
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        midTraverseTree(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum < k)
                left++;
            else if (sum > k)
                right--;
            else
                return true;
        }
        return false;
    }

    private void midTraverseTree(TreeNode root, List<Integer> list) {
        if (root != null) {
            midTraverseTree(root.left, list);
            list.add(root.val);
            midTraverseTree(root.right, list);
        }
    }

    // 637. 二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        double sum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sum += node.val;
                count++;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            } else {
                list.add(sum / count);
                sum = 0;
                count = 0;
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
        return list;
    }

    // 617. 合并二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode t = new TreeNode(t1.val + t2.val);
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }

    // 606. 根据二叉树创建字符串
    public String tree2str(TreeNode t) {
        StringBuilder builder = new StringBuilder();
        tree2str(t, builder);
        return builder.toString();
    }

    private void tree2str(TreeNode t, StringBuilder builder) {
        if (t != null) {
            builder.append(t.val);
            if (t.right != null) {
                builder.append("(");
                tree2str(t.left, builder);
                builder.append(")(");
                tree2str(t.right, builder);
                builder.append(")");
            } else if (t.left != null) {
                builder.append("(");
                tree2str(t.left, builder);
                builder.append(")");
            }
        }
    }

    // 572. 另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (s.val == t.val && isSameTree(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 563. 二叉树的坡度
    public int findTilt(TreeNode root) {
        return findTiltAndSum(root)[0];
    }

    // return sum of tilts and sum of nodes
    private int[] findTiltAndSum(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};
        int[] left = findTiltAndSum(node.left),
                right = findTiltAndSum(node.right);
        int sumLeft = left[1], sumRight = right[1];
        return new int[]{Math.abs(sumLeft - sumRight) + left[0] + right[0], sumLeft + sumRight + node.val};
    }

    // 559. N叉树的最大深度
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int max = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            if (depth > max)
                max = depth;
        }
        return max + 1;
    }

    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (null != current || !stack.empty()) {
            while (null != current) {
                System.out.println(current.val);
                stack.push(current);
                current = current.left;
            }
            if (!stack.empty()) {
                current = stack.peek();  //保存栈顶节点
                stack.pop();
                current = current.right;
            }
        }
    }

    // 662. 二叉树最大宽度
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 1;
        while (!queue.isEmpty()) {
            Deque<TreeNode> nextLevel = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }
            while (!nextLevel.isEmpty() && nextLevel.peek() == null)
                nextLevel.poll();
            while (!nextLevel.isEmpty() && nextLevel.peekLast() == null)
                nextLevel.pollLast();
            if (nextLevel.size() > max)
                max = nextLevel.size();
            queue = nextLevel;
        }
        return max;
    }

    // 513. 找树左下角的值
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res = queue.element().val;
            Queue<TreeNode> cur = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    cur.add(node.left);
                if (node.right != null)
                    cur.add(node.right);
            }
            queue = cur;
        }
        return res;
    }

    // 117. 填充同一层的兄弟节点 II
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeLinkNode> cur = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeLinkNode node = queue.poll();
                node.next = queue.peek();
                if (node.left != null)
                    cur.add(node.left);
                if (node.right != null)
                    cur.add(node.right);
            }
            queue = cur;
        }
    }

    public static void main(String[] args) {
        new TreeSolution().preOrderTraversal(ConvertUtils.stringToTreeNode("[1,null,2,3]"));
    }

    // 951. 翻转等价二叉树
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 != null) if (root2 != null)
            if (root1.val == root2.val)
                return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                        || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        return false;
    }

    // 144. 二叉树的前序遍历
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preOrderTraversal(list, root);
        return list;
    }

    private void preOrderTraversal(List<Integer> list, TreeNode node) {
        if (node != null) {
            list.add(node.val);
            preOrderTraversal(list, node.left);
            preOrderTraversal(list, node.right);
        }
    }
}
