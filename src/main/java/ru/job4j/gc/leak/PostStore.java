package ru.job4j.gc.leak;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {

    private final Map<Integer, Post> postst = new HashMap<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public Post add(Post post) {
        int id = atomicInteger.getAndIncrement();
        post.setId(id);
        postst.put(id, post);
        return post;
    }

    public void removeAll() {
        postst.clear();
    }

    public Collection<Post> getPosts() {
        return postst.values();
    }
}