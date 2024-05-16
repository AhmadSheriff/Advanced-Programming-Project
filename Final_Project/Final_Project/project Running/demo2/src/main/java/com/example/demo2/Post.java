package com.example.demo2;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;

public class Post {
    private User user;
    private String content;
    private ArrayList<Comment> CommentsList;
    private Date uploadTime;
    private List<Like> likes;


    public Post(User user, String content) {
        this.user = user;
        this.content = content;
        CommentsList =new ArrayList<Comment>();
        uploadTime=new Date();
    }
    public void displayPost(){
        System.out.println("User name:" + user.getUserName());
        System.out.println("Content:" + content);
        System.out.println("Uploaded time: " + uploadTime);
    }
    public void addComment(User user ,String content){

        Comment comment= new Comment(user,content);
        CommentsList.add(comment);


    }
    public void showAllComments() {
        if (CommentsList.isEmpty()) {
            System.out.println("No comments");
            return;
        }
        for (int i = 0; i < CommentsList.size(); i++) {
            System.out.println(CommentsList.get(i));
        }
    }
    public void addLike(User user) {
        Like like = new Like(user, true);
        likes.add(like);
    }

    public int getLikeCount() {
        return likes.size();
    }
    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return uploadTime;
    }

}
//old version--------------------------------------------------------------------------------
//import java.util.ArrayList;
//import java.util.*;
//import java.lang.*;
//
//public class Post {
//    private User user;
//    private String content;
//    private ArrayList<Comment> CommentsList;
//    private Date uploadTime;
//    private List<Like> likes;
//
//
//    public Post(User user, String content) {
//        this.user = user;
//        this.content = content;
//        CommentsList =new ArrayList<Comment>();
//        uploadTime=new Date();
//    }
//    public void displayPost(){
//        System.out.println("User name:" + user.getUserName());
//        System.out.println("Content:" + content);
//        System.out.println("Uploaded time: " + uploadTime);
//    }
//    public void addComment(User user ,String content){
//
//        Comment comment= new Comment(user,content);
//        CommentsList.add(comment);
//
//
//    }
//    public void showAllComments() {
//        if (CommentsList.isEmpty()) {
//            System.out.println("No comments");
//            return;
//        }
//        for (int i = 0; i < CommentsList.size(); i++) {
//            System.out.println(CommentsList.get(i));
//        }
//    }
//    public void addLike(User user) {
//        Like like = new Like(user, true);
//        likes.add(like);
//    }
//
//    public int getLikeCount() {
//        return likes.size();
//    }
//}

