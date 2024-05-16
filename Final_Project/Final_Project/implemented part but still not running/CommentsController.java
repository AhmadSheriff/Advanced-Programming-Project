package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.net.URL;
import java.util.ResourceBundle;

public class CommentsController {

    private ObservableList<Comment> comments = FXCollections.observableArrayList();
    private Stage primaryStage;
    private VBox root;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField commentField;

    @FXML
    private Label username;

    @FXML
    private ImageView profile;

    @FXML
    private Button postComment;

    @FXML
    private TextArea commentText;

    String comment;

    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the UI components
    }

    @FXML
    void initialize() {
        assert commentField != null : "fx:id=\"commentField\" was not injected: check your FXML file 'Comments.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'Comments.fxml'.";
        assert profile != null : "fx:id=\"profile\" was not injected: check your FXML file 'Comments.fxml'.";
        assert postComment != null : "fx:id=\"postComment\" was not injected: check your FXML file 'Comments.fxml'.";
        assert commentText != null : "fx:id=\"commentText\" was not injected: check your FXML file 'Comments.fxml'.";

    }

    @FXML
    void addComment(ActionEvent event) {
        try {


            Comment comment = new Comment(new User(), commentField.getText());
            comments.add(comment);
            commentText.setText("");
            commentField.clear();
        } catch (Exception e) {
            System.out.println("Error adding comment: " + e.getMessage());
        }

    }

    @FXML
    void post(ActionEvent event) {

        comment = commentField.getText();
        commentText.setText(comment);

    }
}


