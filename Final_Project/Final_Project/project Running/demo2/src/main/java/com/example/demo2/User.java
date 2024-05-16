package com.example.demo2;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;
public class User {
    private String userName;
    private String password;
    private String email;
    private boolean LoginState ;
    private String bio;
    private boolean privacy =true; //default is public=true
    private String profilePicturePath;
    ArrayList<User> FriendsList;
    ArrayList<Post>MyPosts;
    private int postscount;
    private int friendscount;


    //constructors----------------------------------------

    public User(String username,String password,boolean privacy,String email,String bio){
        this(username,password,privacy,email);
        this.bio=bio;
    }
    public User(String username,String password,boolean privacy,String email){
        this(username,password,privacy);
        this.email=email;
    }
    public User(String username,String password,boolean privacy) {
        this(username,password);
        this.privacy=privacy;

    }
    public User(String userName,String password){
        this.userName=userName;
        this.password=password;
        FriendsList=new ArrayList<User>(); //creat friend list when object user is created
        MyPosts= new ArrayList<Post>();
        postscount=0;
        friendscount=0;

    }

    //getters----------------------------------------------

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    public int getFriendsCount() {return friendscount;}

    public int getPostscount() {return postscount;}

    public boolean isLoginState() {
        return LoginState;
    }

    public String getBio() {
        return bio;
    }

    public boolean getPrivacy() {
        return privacy;
    }
    public String getprofilePicture(){
        return profilePicturePath;
    }
    public String getEmail(){
        return email;
    }

//------------------------------------------------------
    @Override
    public String toString() {
        return userName + "," + password + "," + email + "," + bio + "," + privacy + "," + friendscount + "," + postscount;
    }
    //static bec mortabta bel users kolohom
// 3aks el toString 3lshan lma 2kra2 men el file strings 2rg3hom tany user object
    public static User fromString(String userString) {
        String[] parts = userString.split(",");
        if (parts.length == 7) {
            User user = new User(parts[0], parts[1], Boolean.parseBoolean(parts[4]), parts[2], parts[3]);

            user.setFriendsCount(Integer.parseInt(parts[5]));
            user.setPostsCount(Integer.parseInt(parts[6]));
            return user;
        }
        return null;
    }

    //setters-----------------------------------------------------------------
    public void setFriendsCount(int friendscount)
    {
        this.friendscount = friendscount;
    }

    public void setPostsCount(int postscount)
    {
        this.postscount = postscount;
    }

    public void setUserName(String userName)throws IllegalArgumentException {
        this.userName = userName;
    }

    public void setPassword(String password)throws IllegalArgumentException {
        this.password = password;
    }

    public void setLoginState(boolean LoginState) throws IllegalArgumentException{
        this.LoginState = LoginState;
    }

    public void setBio(String bio) throws IllegalArgumentException{
        this.bio = bio;
    }

    public void setPrivacy(boolean privacy) throws IllegalArgumentException{
        this.privacy = privacy;
    }
    public void setprofilePicture(String profilePicturePath){
        this.profilePicturePath=profilePicturePath;
    }
    public void setEmail(String email) throws IllegalArgumentException{
        if(!(email.contains("@"))) throw new IllegalArgumentException("'@' appers to be missing in your email format") ;
        this.email=email;
    }

    //------using array list to add/remove friends ,get number of friends ,search for a friend

    public void addFriend(User friend) throws IllegalArgumentException {
        if (FriendsList.contains(friend)) {
            throw new IllegalStateException("Friend already added");
        }
        if (friend == null) {
            throw new IllegalArgumentException("Cannot add a null friend");
        }

        FriendsList.add(friend);
    }

    public void removeFriend(User friend) throws IllegalArgumentException {
        if (!(FriendsList.contains(friend))) {
            throw new IllegalStateException("Friend already not added");
        }
        if (friend == null) {
            throw new IllegalArgumentException("Cannot remove a null friend");
        }

        FriendsList.remove(friend);
    }
    public int  getNumberOfFriends(){
        return FriendsList.size();
    }
    public User searchInMyFriends(String username) throws Exception{
        for(int i =0;i< FriendsList.size();i++){
            if(FriendsList.get(i).getUserName().equals(username))
                return FriendsList.get(i);
        }
        throw new Exception ("user not found");
    }
    public List<User> getFriends() {//return array object
        return FriendsList;
    }
   // return user object
    public User getuser(){ return this;} //important for gui

    //use post class--------------------

    public void addPost(String content) throws IllegalArgumentException {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        Post newPost = new Post(this, content);
        MyPosts.add(newPost);
    }


    //use comment class----------------

    public void addCommentInPost(String content){
        try{
            Comment comment =new Comment(this,content);
        }
        catch(IllegalArgumentException ex){
            System.out.println("failed to add comment");
        }

    }


}
