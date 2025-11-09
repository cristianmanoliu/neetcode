package io.github.cristianmanoliu.heap_priority_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DesignTwitterTest {

  @Test
  @DisplayName("Empty news feed for a new user")
  void emptyFeedForNewUser() {
    DesignTwitter twitter = new DesignTwitter();

    // User 1 has no tweets and follows nobody else explicitly.
    List<Integer> feed = twitter.getNewsFeed(1);
    assertIterableEquals(Collections.emptyList(), feed);
  }

  @Test
  @DisplayName("Single user posts multiple tweets, feed is most recent first")
  void singleUserMultipleTweets() {
    DesignTwitter twitter = new DesignTwitter();

    twitter.postTweet(1, 101);
    twitter.postTweet(1, 102);
    twitter.postTweet(1, 103);

    List<Integer> feed = twitter.getNewsFeed(1);
    // Most recent first: 103, 102, 101
    assertIterableEquals(List.of(103, 102, 101), feed);
  }

  @Test
  @DisplayName("Follow another user and see their tweets in the feed")
  void followAndSeeTweets() {
    DesignTwitter twitter = new DesignTwitter();

    twitter.postTweet(1, 5);
    twitter.postTweet(2, 6);
    twitter.postTweet(1, 7);

    twitter.follow(3, 1); // user 3 follows user 1
    twitter.follow(3, 2); // and user 2

    List<Integer> feed = twitter.getNewsFeed(3);
    // Timeline order:
    // time1: user1 tweet 5
    // time2: user2 tweet 6
    // time3: user1 tweet 7
    // Most recent first: 7, 6, 5
    assertIterableEquals(List.of(7, 6, 5), feed);
  }

  @Test
  @DisplayName("Unfollow stops showing that user's tweets")
  void unfollowStopsShowingTweets() {
    DesignTwitter twitter = new DesignTwitter();

    twitter.postTweet(1, 11);
    twitter.postTweet(2, 21);

    twitter.follow(3, 1);
    twitter.follow(3, 2);

    // Initial feed: should include both 2 and 1.
    List<Integer> initialFeed = twitter.getNewsFeed(3);
    // Most recent first: tweet from user2 then user1
    assertIterableEquals(List.of(21, 11), initialFeed);

    // Now unfollow user 2.
    twitter.unfollow(3, 2);

    List<Integer> feedAfterUnfollow = twitter.getNewsFeed(3);
    // Only user1's tweets remain.
    assertIterableEquals(List.of(11), feedAfterUnfollow);
  }

  @Test
  @DisplayName("Feed is capped at 10 tweets even if more exist")
  void feedCappedAtTenTweets() {
    DesignTwitter twitter = new DesignTwitter();

    // User 1 posts 15 tweets: ids 1..15
    for (int i = 1; i <= 15; i++) {
      twitter.postTweet(1, i);
    }

    List<Integer> feed = twitter.getNewsFeed(1);

    // Expect the 10 most recent: 15 down to 6
    assertEquals(10, feed.size());
    assertIterableEquals(List.of(15, 14, 13, 12, 11, 10, 9, 8, 7, 6), feed);
  }

  @Test
  @DisplayName("Self-follow is harmless and self-unfollow is ignored")
  void selfFollowAndSelfUnfollowBehavior() {
    DesignTwitter twitter = new DesignTwitter();

    twitter.postTweet(1, 101);
    twitter.follow(1, 1);    // no effect beyond the default self-follow
    twitter.unfollow(1, 1);  // ignored

    List<Integer> feed = twitter.getNewsFeed(1);
    // User should still see their own tweet.
    assertIterableEquals(List.of(101), feed);
  }
}
