package cn.kingen.oj.leetcode.problem.lcr;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.ArrayUtils.findKthSmallest;

/**
 * <a href="https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/">LCR 159. 库存管理 III</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DIVIDE_AND_CONQUER, Tag.QUICKSELECT, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.EASY
)
public class Lcr159 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] inventoryManagement(int[] stock, int cnt) {
        if (cnt == 0) {
            return new int[0];
        }
        findKthSmallest(stock, cnt);
        return Arrays.copyOf(stock, cnt);
    }
}