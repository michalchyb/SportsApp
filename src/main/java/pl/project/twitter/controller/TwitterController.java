package pl.project.twitter.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.twitter.model.TweetDto;
import pl.project.twitter.service.TwitterService;
import twitter4j.TwitterException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TwitterController {

    private TwitterService twitterService;

    public TwitterController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping(value = "tweets",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TweetDto> getTweetsTimeLine() throws TwitterException {
        return twitterService.getLatestTweets();
    }
}
