/**
 * Sample Skeleton for 'ExploringFriends.fxml' Controller Class
 */
package com.example.demo2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExploreFriends implements Initializable {
    public void initialize() {
            // Call the loadUserData() method to get the user data
            ObservableList<User> userList = loadUserData();

    @FXML // fx:id="username1"
    private Label Username1;
        str.replace(“Rawan Hany”, arr[0]);

    @FXML // fx:id="username2"
    private Label Username2;
        str.replace(“Somaya Ahmed”, arr[1]);

    @FXML // fx:id="username3"
    private Label Username3;
        str.replace(“Habiba Sherif”, arr[2]);

    @FXML // fx:id="username4"
    private Label Username2;
        str.replace(“Rowaida Emad”, arr[3]);

    @FXML// fx:id="username1"
    void addFriendButton1(ActionEvent event) {
        if (privateAccount.isSelected()) {
            FeedBack.setText("This account is private, Request is sent");
        } else {
            FriendList.getItems().add(new User(selectedUsername.getText()));
            FeedBack.setText("This account is added to the friend list");
        }
    }


    @FXML// fx:id="username2"
    void addFriendButton2(ActionEvent event) {
        if (privateAccount.isSelected()) {
            FeedBack.setText("This account is private, Request is sent");
        } else {
            FriendList.getItems().add(new User(selectedUsername.getText()));
            FeedBack.setText("This account is added to the friend list");
        }
    }


    @FXML// fx:id="username3"
    void addFriendButton3(ActionEvent event) {
        if (privateAccount.isSelected()) {
            FeedBack.setText("This account is private, Request is sent");
        } else {
            FriendList.getItems().add(new User(selectedUsername.getText()));
            FeedBack.setText("This account is added to the friend list");
        }
    }

    @FXML// fx:id="username4"
    void addFriendButton4(ActionEvent event) {
        if (privateAccount.isSelected()) {
            FeedBack.setText("This account is private, Request is sent");
        } else {
            FriendList.getItems().add(new User(selectedUsername.getText()));
            FeedBack.setText("This account is added to the friend list");
        }
    }



    @FXML // fx:id="BackToHomePage"
            void BackToHomePage(ActionEvent.event){
        main.changeScene(fxmlpath:"userProfile.fxml")
    }
}
}