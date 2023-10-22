package ru.job4j.gc.leak;

import java.util.List;

public class Post {

    private Integer id;

    private final String text;

    private final List<Comment> comments;

    public Post(Integer id, String text, List<Comment> comments) {
        this.id = id;
        this.text = text;
        this.comments = comments;
    }

    public Post(String text, List<Comment> comments) {
        this.text = text;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}