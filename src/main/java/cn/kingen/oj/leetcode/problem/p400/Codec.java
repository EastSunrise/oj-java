package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import cn.kingen.oj.leetcode.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-bst/">449. Serialize and Deserialize BST</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Codec
 * @see cn.kingen.oj.leetcode.problem.p600.Solution652
 * @see cn.kingen.oj.leetcode.problem.p400.Solution428
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.DESIGN, Tag.BINARY_SEARCH_TREE, Tag.STRING, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Codec {

    private static final char SEP = ',';

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, TreeNode t) {
        if (t != null) {
            sb.append(t.val).append(SEP);
            dfs(sb, t.left);
            dfs(sb, t.right);
        }
    }

    public TreeNode deserialize(String data) {
        List<Integer> values = new ArrayList<>();
        int i = 0, j;
        while ((j = data.indexOf(SEP, i)) >= 0) {
            values.add(Integer.parseInt(data.substring(i, j)));
            i = j + 1;
        }
        return dfs(values, Integer.MIN_VALUE, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode dfs(List<Integer> values, int lower, int upper, int[] p) {
        int i = p[0];
        if (i >= values.size()) {
            return null;
        }
        int val = values.get(i);
        if (val < lower || val > upper) {
            return null;
        }
        TreeNode t = new TreeNode(val);
        p[0]++;
        t.left = dfs(values, lower, val, p);
        t.right = dfs(values, val, upper, p);
        return t;
    }
}