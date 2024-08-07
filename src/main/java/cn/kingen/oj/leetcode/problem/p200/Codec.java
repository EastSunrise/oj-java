package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import cn.kingen.oj.leetcode.support.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">297. Serialize and Deserialize Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution271
 * @see cn.kingen.oj.leetcode.problem.p400.Codec
 * @see cn.kingen.oj.leetcode.problem.p600.Solution652
 * @see cn.kingen.oj.leetcode.problem.p400.Solution428
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.DESIGN, Tag.STRING, Tag.BINARY_TREE},
        difficulty = Difficulty.HARD
)
public class Codec {

    private static final char SEP = ',';
    private static final char NULL = '#';

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, TreeNode t) {
        if (t == null) {
            sb.append(NULL).append(SEP);
        } else {
            sb.append(t.val).append(SEP);
            dfs(sb, t.left);
            dfs(sb, t.right);
        }
    }

    public TreeNode deserialize(String data) {
        return dfs(data, new int[]{0});
    }

    private TreeNode dfs(String data, int[] p) {
        int i = p[0];
        int j = data.indexOf(SEP, i);
        if (j < 0) {
            return null;
        }
        if (i + 1 == j && data.charAt(i) == NULL) {
            return null;
        }
        TreeNode t = new TreeNode(Integer.parseInt(data.substring(i, j)));
        p[0] = j + 1;
        t.left = dfs(data, p);
        t.right = dfs(data, p);
        return t;
    }
}