package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/sparse-similarity-lcci/">面试题 17.26. Sparse Similarity LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Interview26 {

    @Complexity(time = "O(n^2+nk)", space = "O(n^2+nk)", note = "k is the average number of words in each document")
    public List<String> computeSimilarities(int[][] docs) {
        int n = docs.length;
        List<String> ans = new ArrayList<>();
        Map<Integer, List<Integer>> indices = new HashMap<>();
        int[][] intersects = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int key : docs[i]) {
                List<Integer> ids = indices.get(key);
                if (ids == null) {
                    ids = new ArrayList<>();
                    indices.put(key, ids);
                } else {
                    for (int j : ids) {
                        intersects[j][i]++;
                    }
                }
                ids.add(i);
            }

            for (int j = 0; j < i; j++) {
                if (intersects[j][i] == 0) {
                    continue;
                }
                int union = docs[i].length + docs[j].length - intersects[j][i];
                double similarity = (double) intersects[j][i] / union;
                ans.add(String.format("%d,%d: %.4f", j, i, similarity));
            }
        }
        return ans;
    }
}