package io.github.cristianmanoliu.heap_priority_queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// https://neetcode.io/problems/design-twitter-feed?list=neetcode150
// https://leetcode.com/problems/design-twitter/
public class DesignTwitter {

  // For each user, store the head of their tweet list (most recent tweet first).
  private final Map<Integer, Tweet> tweetsByUser = new HashMap<>();
  // For each user, store the set of users they follow (including themselves).
  // Invariant: whenever a user is known, following.get(userId) contains userId.
  private final Map<Integer, Set<Integer>> following = new HashMap<>();
  // Global timestamp to maintain ordering across all users.
  // Incremented for every posted tweet.
  private int time = 0;

  // Constructor: nothing to initialize beyond the default field values.
  public DesignTwitter() {
  }

  // Helper: ensure that a user has an entry in the 'following' map
  // and follows themselves. This lets us always see our own tweets
  // in the news feed without special-case logic.
  private void ensureUserExists(int userId) {
    following.computeIfAbsent(userId, id -> {
      Set<Integer> followees = new HashSet<>();
      followees.add(id); // user follows themselves
      return followees;
    });
  }

  // Post a new tweet for 'userId' with the given 'tweetId'.
  // We prepend at the head of the user's tweet list:
  // - O(1) time.
  // - The newest tweet becomes the new head.
  public void postTweet(int userId, int tweetId) {
    ensureUserExists(userId);

    // Create a new tweet node pointing to the previous head.
    Tweet head = tweetsByUser.get(userId);
    Tweet newTweet = new Tweet(tweetId, ++time, head);
    tweetsByUser.put(userId, newTweet);
  }

  // Retrieve the 10 most recent tweet IDs in the user's news feed.
  //
  // Tweets come from:
  // - The user themselves.
  // - All users they follow.
  //
  // Strategy:
  // - For each followee, take their most recent tweet (list head) and push it
  //   into a max-heap ordered by 'time'.
  // - Repeatedly:
  //   * Pop the most recent tweet from the heap, add its id to the result.
  //   * If that tweet has 'next', push 'next' into the heap.
  //   * Stop once we have collected 10 tweets or the heap is empty.
  //
  // This is a k-way merge of sorted lists, where k is the number of followees.
  public List<Integer> getNewsFeed(int userId) {
    ensureUserExists(userId);

    List<Integer> result = new ArrayList<>(10);

    // Max-heap ordered by tweet time (most recent first).
    PriorityQueue<Tweet> maxHeap =
        new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

    // Seed the heap with the most recent tweet of each followee (including self).
    Set<Integer> followees = following.get(userId);
    if (followees != null) {
      for (Integer followeeId : followees) {
        Tweet head = tweetsByUser.get(followeeId);
        if (head != null) {
          maxHeap.offer(head);
        }
      }
    }

    // Extract up to 10 most recent tweets by k-way merging the lists.
    while (!maxHeap.isEmpty() && result.size() < 10) {
      Tweet current = maxHeap.poll();
      result.add(current.id);

      // Push the next tweet from the same user, if any.
      if (current.next != null) {
        maxHeap.offer(current.next);
      }
    }

    return result;
  }

  // Make followerId follow followeeId.
  // We ensure followerId exists and simply add followeeId to their set.
  // Self-follow is allowed but is effectively a no-op because we already
  // ensure that every user follows themselves.
  public void follow(int followerId, int followeeId) {
    ensureUserExists(followerId);
    ensureUserExists(followeeId);

    following.get(followerId).add(followeeId);
  }

  // Make followerId unfollow followeeId.
  // Self-unfollow is ignored to preserve the invariant that a user
  // always sees their own tweets.
  public void unfollow(int followerId, int followeeId) {
    if (followerId == followeeId) {
      // Do not allow self-unfollow; we always follow ourselves.
      return;
    }

    Set<Integer> followees = following.get(followerId);
    if (followees != null) {
      followees.remove(followeeId);
    }
  }

  // Internal tweet node:
  // - 'id' is the tweetId.
  // - 'time' is a global increasing counter so we can order tweets by recency.
  // - 'next' points to the previous tweet from the same user (reverse-chronological list).
  private static class Tweet {

    final int id;
    final int time;
    final Tweet next;

    Tweet(int id, int time, Tweet next) {
      this.id = id;
      this.time = time;
      this.next = next;
    }
  }
}
