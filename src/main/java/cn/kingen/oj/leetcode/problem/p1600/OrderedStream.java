package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/design-an-ordered-stream/">1656. Design an Ordered Stream</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2400.LUPrefix

 */
@Question(
        tags = {Tag.DESIGN, Tag.ARRAY, Tag.HASH_TABLE, Tag.DATA_STREAM},
        difficulty = Difficulty.EASY,
        date = "2025-02-24"
)
public class OrderedStream {

    private final String[] stream;
    private int ptr = 1;

    public OrderedStream(int n) {
        this.stream = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        if (stream[ptr] == null) {
            return Collections.emptyList();
        }

        List<String> ans = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            ans.add(stream[ptr++]);
        }
        return ans;
    }
}