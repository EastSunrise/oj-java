package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/frequency-tracker/">2671. Frequency Tracker</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DESIGN, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM
)
public class FrequencyTracker {

    private final Map<Integer, Integer> numbers;
    private final Map<Integer, Integer> frequencies;

    public FrequencyTracker() {
        numbers = new HashMap<>();
        frequencies = new HashMap<>();
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public void add(int number) {
        int oldCount = numbers.getOrDefault(number, 0);
        numbers.put(number, oldCount + 1);
        frequencies.merge(oldCount + 1, 1, Integer::sum);
        if (oldCount > 0) {
            frequencies.compute(oldCount, (key, oldV) -> oldV == null || oldV == 1 ? null : oldV - 1);
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public void deleteOne(int number) {
        Integer oldCount = numbers.get(number);
        if (oldCount == null) {
            return;
        }
        frequencies.compute(oldCount, (key, oldV) -> oldV == null || oldV == 1 ? null : oldV - 1);
        if (oldCount == 1) {
            numbers.remove(number);
        } else {
            numbers.put(number, oldCount - 1);
            frequencies.merge(oldCount - 1, 1, Integer::sum);
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean hasFrequency(int frequency) {
        return frequencies.containsKey(frequency);
    }
}