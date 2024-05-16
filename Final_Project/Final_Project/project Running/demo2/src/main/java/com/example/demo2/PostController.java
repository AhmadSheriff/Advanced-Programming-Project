package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class PostController {

    private int postCount = 0;
    @FXML
    private TextArea caption;

    @FXML
    private ImageView postImg;

    @FXML
    private Button postBtn;

    @FXML
    private Scene previousScene;



    @FXML
    private void handlePostButtonAction(ActionEvent event) {

        String captionText = caption.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("postsData.txt", true))) {
            writer.write("Caption: " + captionText + "\n");

            if (postImg.getImage() != null) {
                writer.write("Image: " + postImg.getImage().getUrl() + "\n");
            }

            writer.write("\n"); // Separating posts

            // Clearing fields after posting
            caption.clear();
            writer.flush();
            postImg.setImage(null);
           // writer.flush();
            System.out.println("Post saved.");
        }
        catch (IOException e) {
            System.err.println("Error saving post: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(postBtn.getScene().getWindow());
        if (selectedFile != null) {

            Image image = new Image(selectedFile.toURI().toString());
            postImg.setImage(image);
        }
    }

    @FXML
    private void handleBackBtn(ActionEvent event){
        Button backButton = (Button) event.getSource();

        try{
            Parent root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Creat post");
            stage.setScene(scene);
            stage.show();
        }
        catch( Exception e)
        {
            System.out.println("error");
        }

    }


}