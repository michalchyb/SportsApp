package pl.project.twitter.service;

import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterService {

    public static Twitter getTwitterinstance() {
        return TwitterFactory.getSingleton();
    }

    public List<String> getLatestTweets() throws TwitterException {
        Twitter twitter = getTwitterinstance();

        List<Status> statuses = twitter.getHomeTimeline();
        return statuses.stream()
                .map(Status::getText)
                .collect(Collectors.toList());
    }
}
