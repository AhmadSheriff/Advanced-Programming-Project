package com.example.demo2;

import java.util.*;

public class feed {


    private List<Post> posts;

    // Constructor to initialize the list of posts
    public feed() {
        posts = new ArrayList<>();
    }

    // Add a new post to the feed
    public void addPost(Post post) {
        posts.add(post);
    }

    // Display the posts in the order of the newest post to the oldest
    public void displayFeed() {
        // Sort the posts based on the timestamp in descending order
        Collections.sort(posts, (p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));

        // Display the posts
        for (Post post : posts) {
            System.out.println(post.getContent());
        }
    }
}
