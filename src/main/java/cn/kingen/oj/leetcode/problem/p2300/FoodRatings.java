package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/design-a-food-rating-system/">2353. Design a Food Rating System</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2300.NumberContainers
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2456

 */
@Question(
        tags = {Tag.DESIGN, Tag.HASH_TABLE, Tag.ORDERED_SET, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM,
        date = "2025-02-28"
)
public class FoodRatings {

    private final Map<String, PriorityQueue<Object[]>> rank;
    private final Map<String, Object[]> foods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.rank = new HashMap<>();
        this.foods = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i], cuisine = cuisines[i];
            Object[] item = new Object[]{cuisine, food, ratings[i], false}; // [food, rating, removed]
            rank.computeIfAbsent(cuisine, k -> new PriorityQueue<>((a, b) -> b[2].equals(a[2]) ? ((String) a[1]).compareTo((String) b[1]) : ((int) b[2] - (int) a[2]))).offer(item);
            this.foods.put(food, item);
        }
    }

    public void changeRating(String food, int newRating) {
        Object[] item = this.foods.get(food);
        if (item != null) {
            item[3] = true; // mark as removed
            Object[] newItem = new Object[]{item[0], item[1], newRating, false};
            this.rank.get((String) item[0]).offer(newItem);
            this.foods.put(food, newItem);
        }
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Object[]> queue = this.rank.get(cuisine);
        while (!queue.isEmpty() && ((boolean) queue.peek()[3])) {
            queue.poll();
        }
        return queue.isEmpty() ? "" : (String) queue.peek()[1];
    }
}