package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by romansky on 1/14/16.
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(String message) {
        super(message);
    }
    public NormalTweet(Date date, String message) throws TweetTooLongException {

        super(message, date);
    }
    @Override
    public boolean isImportant() {
        return false;
    }

    public String getMessage() {
        return this.message;
    }
}
