package pl.project.mapper;

import org.springframework.stereotype.Component;
import pl.project.model.TweetDto;
import twitter4j.Status;

@Component
public class TweetMapper {
    public TweetDto map(Status from) {
        return TweetDto.builder()
                .author(from.getUser().getName())
                .content(from.getText())
                .accountName(from.getUser().getScreenName())
                .build();
    }
}
