package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by linghou on 2017-02-16.
 */


public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {

        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {

        TweetList tweets = new TweetList();

        Tweet tweet = null;

        tweet = new NormalTweet("test tweet");

        tweets.add(tweet);
            assertTrue(tweets.hasTweet(tweet));

            boolean exceptionThrown = false;

            try {
                tweets.add(tweet);
            }

            catch (IllegalArgumentException e) {
                exceptionThrown = true;
            }

        assertTrue(exceptionThrown);
    }
    public void testGetTweet() {

        ArrayList<Tweet> sortedTweets;

        TweetList tweets = new TweetList();
        assertEquals(tweets.getTweets().size(), 0);

        Tweet tweet = null;

        try {
            tweet = new NormalTweet(new Date(2022, 1, 23), "test tweet");
        }

        catch (TweetTooLongException e) {
            e.printStackTrace();
        }

        tweets.add(tweet);
        sortedTweets = tweets.getTweets();
        assertEquals(sortedTweets.size(), 1);
        assertEquals(tweets.getTweet(0), sortedTweets.get(0));

        try {
            tweet = new NormalTweet(new Date(2030, 1, 23), "test tweet 2");
        }

        catch (TweetTooLongException e) {
            e.printStackTrace();
        }

        tweets.add(tweet);
        sortedTweets = tweets.getTweets();
        assertEquals(sortedTweets.size(), 2);
        assertEquals(sortedTweets.get(0).getDate().compareTo(sortedTweets.get(1).getDate()), -1);

        try {
            tweet = new NormalTweet(new Date(1994, 1, 23), "test tweet 3");
        }

        catch (TweetTooLongException e) {
            e.printStackTrace();
        }

        tweets.add(tweet);
        sortedTweets = tweets.getTweets();
        assertEquals(sortedTweets.size(), 3);
        assertEquals(sortedTweets.get(0).getDate().compareTo(sortedTweets.get(1).getDate()), -1);
        assertEquals(sortedTweets.get(1).getDate().compareTo(sortedTweets.get(2).getDate()), -1);
    }

    public void testHasTweet() {

        TweetList tweets = new TweetList();

        Tweet tweet = null;
        tweet = new NormalTweet("test tweet");

        assertFalse(tweets.hasTweet(tweet));

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

        tweet = new NormalTweet("test tweet 2");

        assertFalse(tweets.hasTweet(tweet));

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetCount() {

        TweetList tweets = new TweetList();
        assertEquals(tweets.getCount(), 0);

        Tweet tweet = null;

        tweet = new NormalTweet("test tweet");

        tweets.add(tweet);
        assertEquals(tweets.getCount(), 1);

        tweet = new NormalTweet("test tweet 2");

        tweets.add(tweet);
        assertEquals(tweets.getCount(), 2);
    }


    public void testDeleteTweet() {

            TweetList tweets = new TweetList();

            Tweet tweet = null;

            tweet = new NormalTweet("Last tweet");

            tweets.add(tweet);
            tweets.delete(tweet);

            assertFalse(tweets.hasTweet(tweet));
        }




}

