package wsg.oj.java.leetcode.problems.old;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Kingen
 */
public class TreeSolution {

    // 107. 二叉树的层次遍历 II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root == null) {
            return listList;
        }
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

    // 429. N叉树的层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root == null) {
            return listList;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                list.add(node.val);
                for (Node child : node.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            } else {
                listList.add(list);
                list = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return listList;
    }

    // 437. 路径总和 III
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFromRoot(root, sum);
    }

    private int pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int count = pathSumFromRoot(root.left, sum) + pathSumFromRoot(root.right, sum);
        if (sum == 0) {
            count++;
        }
        return count;
    }

    // wsg 687. 最长同值路径
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left, right = root.right;
        int leftLen = longestUnivaluePath(left), rightLen = longestUnivaluePath(right);
        if (left != null && left.val == root.val && right != null && right.val == root.val) {
            return leftLen + rightLen + 2;
        } else if (left != null && left.val == root.val) {
            return Math.max(leftLen + 1, rightLen);
        } else if (right != null && right.val == root.val) {
            return Math.max(leftLen, rightLen + 1);
        }
        return Math.max(leftLen, rightLen);
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
        if (root == null) {
            return 0;
        }
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
            while (!nextLevel.isEmpty() && nextLevel.peek() == null) {
                nextLevel.poll();
            }
            while (!nextLevel.isEmpty() && nextLevel.peekLast() == null) {
                nextLevel.pollLast();
            }
            if (nextLevel.size() > max) {
                max = nextLevel.size();
            }
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
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
            queue = cur;
        }
        return res;
    }

    // 117. 填充同一层的兄弟节点 II
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeLinkNode> cur = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeLinkNode node = queue.poll();
                node.next = queue.peek();
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
            queue = cur;
        }
    }

    // 951. 翻转等价二叉树
    public boolean flipEquiv(
        TreeNode root1,
        TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 != null) {
            if (root2 != null) {
                if (root1.val == root2.val) {
                    return
                        (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                            || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right,
                            root2.left));
                }
            }
        }
        return false;
    }

    class Entry {

        TreeNode node;
        int level;

        Entry(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
