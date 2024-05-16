package com.example.demo2;

import java.lang.*;
import java.util.*;


public class Like {
    private User liker;
    private boolean isLiked ;
    public static int likeCount=0;

    public Like(User liker , boolean isLiked)throws IllegalArgumentException{
        if (liker==null){
            throw new IllegalArgumentException("user not found");
        }else{
            this.liker=liker;
            this.isLiked=isLiked;
            likeCount++;
        }
    }

    public User getLiker() {
        return liker;
    }

    public void setLiker(User liker) {
        this.liker = liker;
    }

    public boolean isIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public static int getLikeCount() {
        return likeCount;
    }

    public static void setLikeCount(int likeCount) {
        Like.likeCount = likeCount;
    }


}


