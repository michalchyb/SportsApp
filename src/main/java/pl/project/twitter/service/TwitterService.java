package pl.project.twitter.service;

import org.springframework.stereotype.Service;
import pl.project.twitter.mapper.TweetMapper;
import pl.project.twitter.model.TweetDto;
import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterService {

    private TweetMapper tweetMapper;

    public TwitterService(TweetMapper tweetMapper) {
        this.tweetMapper = tweetMapper;
    }

    public static Twitter getTwitterInstance() {
        return TwitterFactory.getSingleton();
    }

    public List<TweetDto> getLatestTweets() throws TwitterException {
        Twitter twitter = getTwitterInstance();
        Paging paging = new Paging(1, 10);
        List<Status> statuses = twitter.getHomeTimeline(paging);
        return statuses.stream()
                .map(tweetMapper::map)
                .collect(Collectors.toList());
    }
}
