package cn.kingen.oj.leetcode.problem.p1400;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/design-browser-history/">1472. Design Browser History</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2254

 */
@Question(
        tags = {Tag.STACK, Tag.DESIGN, Tag.ARRAY, Tag.LINKED_LIST, Tag.DATA_STREAM, Tag.DOUBLY_LINKED_LIST},
        difficulty = Difficulty.MEDIUM,
        date = "2025-02-26"
)
public class BrowserHistory {

    private final List<String> history;
    private int current;
    private int last;

    public BrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        this.history.add(homepage);
        this.current = 0;
        this.last = 0;
    }

    public void visit(String url) {
        this.current++;
        this.last = this.current;
        if (this.current >= this.history.size()) {
            this.history.add(url);
        } else {
            this.history.set(this.current, url);
        }
    }

    public String back(int steps) {
        this.current = Math.max(0, this.current - steps);
        return this.history.get(this.current);
    }

    public String forward(int steps) {
        this.current = Math.min(this.current + steps, this.last);
        return this.history.get(this.current);
    }
}