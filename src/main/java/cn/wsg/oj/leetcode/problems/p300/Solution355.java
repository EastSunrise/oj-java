package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 355. Design Twitter (Medium)
 *
 * @author Kingen
 * @see Solution1500
 * @see <a href="https://leetcode-cn.com/problems/design-twitter/">Design Twitter</a>
 */
class Solution355 implements Solution {

    static class Twitter {

        private static final int RECENT_COUNT = 10;
        private static int nextTweetId = 0;
        private final Map<Integer, Set<Integer>> follows;
        private final Map<Integer, TweetNode> tweets;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            this.follows = new HashMap<>(16);
            this.tweets = new HashMap<>(16);
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            tweets.put(userId, new TweetNode(tweetId, nextTweetId++, tweets.get(userId)));
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed
         * must be posted by users who the user followed or by the user herself. Tweets must be
         * ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            TweetNode head = new TweetNode();
            merge(head, tweets.get(userId));
            Set<Integer> followee = follows.get(userId);
            if (followee != null) {
                for (int id : followee) {
                    merge(head, tweets.get(id));
                }
            }
            List<Integer> res = new ArrayList<>(RECENT_COUNT);
            int count = RECENT_COUNT;
            TweetNode node = head.next;
            while (count > 0 && node != null) {
                res.add(node.id);
                count--;
                node = node.next;
            }
            return res;
        }

        private void merge(TweetNode head, TweetNode queue) {
            TweetNode prev = head, node = queue;
            int count = RECENT_COUNT;
            while (count > 0 && prev.next != null && node != null) {
                if (prev.next.order < node.order) {
                    prev.next = new TweetNode(node.id, node.order, prev.next);
                    node = node.next;
                }
                prev = prev.next;
                count--;
            }
            while (count > 0 && node != null) {
                prev.next = new TweetNode(node.id, node.order);
                node = node.next;
                prev = prev.next;
                count--;
            }
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            Set<Integer> followee = follows.computeIfAbsent(followerId, key -> new HashSet<>());
            followee.add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followee = follows.get(followerId);
            if (followee != null) {
                followee.remove(followeeId);
            }
        }

        static class TweetNode {

            int id;
            int order;
            TweetNode next;

            TweetNode() {
            }

            TweetNode(int id, int order) {
                this.id = id;
                this.order = order;
            }

            TweetNode(int id, int order, TweetNode next) {
                this.id = id;
                this.order = order;
                this.next = next;
            }
        }
    }
}
