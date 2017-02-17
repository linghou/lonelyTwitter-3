package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by linghou on 2017-02-16.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public int getCount() {

        return tweets.size();
    }
    public void add(Tweet tweet) {

        if (this.hasTweet(tweet))
            throw new IllegalArgumentException("Cannot add a Tweet that is already in the list");
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {

        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet) {

        tweets.remove(tweet);
    }

    public Tweet getTweet(int index) {

        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets() {

        ArrayList<Tweet> sortedTweets = (ArrayList<Tweet>) tweets.clone();


        Collections.sort(sortedTweets, new Comparator<Tweet>() {

                public int compare(Tweet tweet1, Tweet tweet2)
                {return tweet1.getDate().compareTo(tweet2.getDate());}
            });

        return sortedTweets;
    }
}

