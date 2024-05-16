/**
 * Sample Skeleton for 'SignupPage.fxml' Controller Class
 */
package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class signupPageController implements Initializable {//implementing Initializable interface if u need the initialize function
    @Override
    public void initialize(URL location, ResourceBundle resources) { //implement the method that is executed at the start before showing up the gui
        privacy = new ToggleGroup(); //creat new toggle group
        privateAccount.setToggleGroup(privacy); //set radio button in toggle group
        PublicAccount.setToggleGroup(privacy); //set the other radio button in the toggle group

    }
    //signup check----------------------------------------------------------
    static boolean flagToGoToProfile = false;
    public static String signup(String username, String password, boolean privacy, String email, String bio)
    {
        if ((UserManagerControl.getUserByUsername(username)) != null) {
            return "Username is already taken. Please choose another one.";
        }
        else if(username.isEmpty()||password.isEmpty()||bio.isEmpty())
        {
            return "some data still missing";
        }
        User newUser = new User(username, password, privacy, email, bio);//creat new user
        UserManagement.addUser(newUser); //pass new user to be added in  user management class
        flagToGoToProfile = true;
        CurrentUserControl.setCurrentUser(newUser);
        return "User registered successfully.";

    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="EmailField"
    private TextField EmailField; // Value injected by FXMLLoader

    @FXML // fx:id="FeedBack"
    private Label FeedBack; // Value injected by FXMLLoader

    @FXML // fx:id="PasswordField"
    private TextField PasswordField; // Value injected by FXMLLoader

    @FXML // fx:id="PublicAccount"
    private RadioButton PublicAccount; // Value injected by FXMLLoader

    @FXML // fx:id="bioField"
    private TextField bioField; // Value injected by FXMLLoader

    @FXML // fx:id="privacy"
    private ToggleGroup privacy; // Value injected by FXMLLoader

    @FXML // fx:id="privateAccount"
    private RadioButton privateAccount; // Value injected by FXMLLoader

    @FXML // fx:id="setProfile"
    private Button setProfile; // Value injected by FXMLLoader

    @FXML // fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader

    @FXML

    void setUpProfileButtonAction(ActionEvent event)
    {
        String username = usernameField.getText();
        String password = PasswordField.getText();
        String email = EmailField.getText();
        String bio = bioField.getText();
        boolean isPrivate= privateAccount.isSelected();
        boolean isPublic= PublicAccount.isSelected();

        if (usernameField.getText().isEmpty() || PasswordField.getText().isEmpty() ||EmailField.getText().isEmpty()
        ||  bioField.getText().isEmpty()  )
        {

            FeedBack.setText("some information is still missing ,please fill all the data");

        }
        if ( (!isPublic ) && (! isPrivate) )
        {
            FeedBack.setText("Please select a privacy setting.");
            return;
        }
        if(!(email.contains("@"))){
            FeedBack.setText("your mail should contian '@'");
            return; //break out 3lshan maykamalsh
        }


        FeedBack.setText( signup(username,password,isPublic,email,bio)  );
        if(flagToGoToProfile)
        {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
            Stage stage = (Stage) setProfile.getScene().getWindow();
            stage.setScene(new Scene(root));

        }
        catch (IOException e)
        {
            FeedBack.setText("error occurred");
        }
        }

    }

}


