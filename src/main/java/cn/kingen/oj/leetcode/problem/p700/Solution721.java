package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/accounts-merge/">721. Accounts Merge</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution684
 * @see cn.kingen.oj.leetcode.problem.p700.Solution734
 * @see cn.kingen.oj.leetcode.problem.p700.Solution737
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution721 {

    @Complexity(time = "O(n*log{n})", space = "O(n)", note = "n is the number of emails")
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> email2index = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                email2index.putIfAbsent(email, email2index.size());
            }
        }

        int n = email2index.size();
        int[] parents = new int[n];
        Arrays.setAll(parents, i -> i);
        Map<Integer, String> index2Name = new HashMap<>();
        for (List<String> account : accounts) {
            int root = findRoot(parents, email2index.get(account.get(1)));
            for (int i = 2; i < account.size(); i++) {
                int index = findRoot(parents, email2index.get(account.get(i)));
                parents[index] = root;
            }
            index2Name.put(root, account.get(0));
        }

        Map<Integer, List<String>> index2Emails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : email2index.entrySet()) {
            String email = entry.getKey();
            int root = findRoot(parents, entry.getValue());
            index2Emails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        return index2Emails.entrySet().stream()
                .map(entry -> {
                    List<String> emails = entry.getValue();
                    emails.sort(String::compareTo);
                    List<String> account = new ArrayList<>(emails.size() + 1);
                    account.add(index2Name.get(entry.getKey()));
                    account.addAll(emails);
                    return account;
                }).toList();
    }

    private int findRoot(int[] parents, int t) {
        int p;
        while (t != (p = parents[t])) {
            t = p;
        }
        return t;
    }
}