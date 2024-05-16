package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class fed {
    private Stage stage ;
    private Scene scene ;
    private Parent root ;

    @FXML
    private AnchorPane feedPane;

    @FXML
    private ObservableList<Post> postList = FXCollections.observableArrayList();

    @FXML
    private ImageView postImageView;

    @FXML
    private Label postUserNameLabel;

    @FXML
    private Label postTimestampLabel;

    @FXML
    private Label postTextLabel;


    public void posts() {

    }

    String filePath = "postsData.txt";
    File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file)) {
             while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Image: ")) {
                String imageLink = line.substring(line.indexOf("Image: ") + 7);
                System.out.println("First Image: " + imageLink);
                break;
          } catch (FileNotFoundException e ){
                System.out.println("File not found");
            }
            public void updateFeed (Post post){
                // Update the UI with the new post
                postImageView.setImage(new Image(imageLink));
                postUserNameLabel.setText(UserManagerControl.getUserByUsername(username));
                postTimestampLabel.setText(Post.getTimestamp());

            }

            public void like (ActionEvent event){
                // Find the post that was clicked
                post = post((Node) event.getSource());
                if (post != null) {
                    Like.setLikeCount(Like.getLikeCount() + 1);
                }
            }


            public void switchToComment (ActionEvent event) throws IOException {
                // Add your code to switch to the comment page
                Parent root = FXMLLoader.load(getClass().getResource("Comments.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            public void switchToProfile (ActionEvent event) throws IOException {
                // Add your code to switch to the profile page
                Parent root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }


        }
