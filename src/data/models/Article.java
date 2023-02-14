package data.models;

import java.time.LocalDateTime;

public class Article {

    private int id;

    private String title;

    private String body;

    private LocalDateTime timeCreated = LocalDateTime.now();

    private int authorId;

    public Article(String title, String body) {

        this.title = title;

        this.body = body;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
