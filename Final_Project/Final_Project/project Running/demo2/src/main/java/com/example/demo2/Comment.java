package com.example.demo2;

import java.lang.*;
import java.util.*;

public class Comment {
    private User user;
    private String content;
    public static int CommentCount=0;
    //constructor-------------------------------------------
    public Comment(User user, String content) throws IllegalArgumentException {
        if(user==null){
            throw new IllegalArgumentException("user not found");
        }
        else{
            this.user = user;
            this.content = content;

        }

    }
    //setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //getters

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws IllegalArgumentException {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Comment{" + "user=" + user + ", content=" + content + '}';
    }




}