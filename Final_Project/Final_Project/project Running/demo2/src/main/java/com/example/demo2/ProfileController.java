/**
 * Sample Skeleton for 'userProfile.fxml' Controller Class
 */
package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
public class ProfileController implements Initializable {
    @FXML // This method is called by the FXMLLoader when initialization is complete
   public void initialize(URL location, ResourceBundle resources) {
        if (CurrentUserControl.getCurrentUser() != null) {
            UserNameField.setText(CurrentUserControl.getCurrentUser().getUserName());

            bioField.setText(CurrentUserControl.getCurrentUser().getBio());

            FriendsNumber.setText(String.valueOf(CurrentUserControl.getCurrentUser().getFriendsCount()));

            PostsNumber.setText(String.valueOf(CurrentUserControl.getCurrentUser().getPostscount()));
            emailField.setText(CurrentUserControl.getCurrentUser().getEmail());

            if(CurrentUserControl.getCurrentUser().getPrivacy())
            {
                PrivacyField.setText("Public Account");
            }
            else
            {
                PrivacyField.setText("Private Account");
            }
        }

    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="FriendsNumber"
    private Label FriendsNumber; // Value injected by FXMLLoader

    @FXML // fx:id="PostsNumber"
    private Label PostsNumber; // Value injected by FXMLLoader

    @FXML // fx:id="PrivacyField"
    private Label PrivacyField; // Value injected by FXMLLoader

    @FXML // fx:id="UserNameField"
    private Label UserNameField; // Value injected by FXMLLoader

    @FXML // fx:id="bioField"
    private Label bioField; // Value injected by FXMLLoader

    @FXML // fx:id="emailField"
    private Label emailField; // Value injected by FXMLLoader

    @FXML
    private Label feedback;

    @FXML
    private void handleAddPost(ActionEvent event)
    {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("post.fxml"));
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Creat post");
            stage.setScene(scene);
            stage.show();
        }
        catch( Exception e)
        {
            feedback.setText("error occurred");

        }
    }

    @FXML
    private void AddFriendsButton(ActionEvent event)
    {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ExploringFriends.fxml"));
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Creat post");
            stage.setScene(scene);
            stage.show();
        }
        catch( Exception e)
        {
            feedback.setText("error occurred");

        }
    }

    @FXML
    private void Feedbutton(ActionEvent event)
    {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("feed.fxml"));
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Creat post");
            stage.setScene(scene);
            stage.show();
        }
        catch( Exception e)
        {
            feedback.setText("error occurred");

        }
    }

    @FXML
    private void Messagebutton(ActionEvent event)
    {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("messages.fxml"));
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Creat post");
            stage.setScene(scene);
            stage.show();
        }
        catch( Exception e)
        {
            feedback.setText("error occurred");

        }
    }

}
