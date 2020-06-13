package pl.project.twitter.model;

import lombok.Builder;

@Builder
public class TweetDto {

    private String author;
    private String content;
    private String accountName;

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getAccountName() {
        return accountName;
    }
}
