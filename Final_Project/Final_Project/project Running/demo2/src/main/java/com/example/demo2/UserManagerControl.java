/**
 * Sample Skeleton for 'entryPage.fxml' Controller Class
 */
package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserManagerControl implements Initializable {
    private static List<User> users;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        users = UserManagement.loadUserData(); //load data from file at the start bel function el kont 3amlaha before 3lshan kda 2slan
    }


//needed functions 3lshan 2a2al el event handeller code function
    //username check---------------------------------------------------
    public static User getUserByUsername(String username)
    {
        for (int i =0; i< users.size();i++)
        {
            if (users.get(i).getUserName().equals(username)) //remeber:kda kda toString implemented sa7 in string class
            {
                return users.get(i) ;
            }
        }
        return null;
    }
    //signup check----------------------------------------------------------
    public static String signup(String username, String password, boolean privacy, String email, String bio)
    {
        if (getUserByUsername(username) != null) {
            return "Username is already taken. Please choose another one.";
        }
        User newUser = new User(username, password, privacy, email, bio);//creat new user
        UserManagement.addUser(newUser); //pass new user to be added in  user management class
        return "User registered successfully.";
    }
    //login check----------------------------------------------------------

    public static User login(String username, String password) throws Exception
    {
        User user = getUserByUsername(username); //return user needed or null if not found
        if (user == null) {
            throw new Exception("User does not exist. Signup first .");//note:user 7ata law 7at el password sa7 bas username 8alat throw hatl3na bara
        }
        if (!user.getPassword().equals(password)) {
            throw new Exception("Incorrect password.");
        }
        return user;
    }
    //--------------------------------------------------------------------3lshan 2t3matt
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Login_Button"
    private Button Login_Button; // Value injected by FXMLLoader

    @FXML // fx:id="SignUp_button"
    private Button SignUp_button; // Value injected by FXMLLoader

    @FXML // fx:id="UserNameField"
    private TextField UserNameField; // Value injected by FXMLLoader

    @FXML // fx:id="feedbackLabel"
    private Label feedbackLabel; // Value injected by FXMLLoader

    @FXML // fx:id="passFiled"
    private TextField passFiled; // Value injected by FXMLLoader

    @FXML
    public void LoginButtonAction(ActionEvent event) {
        //test of buttons functionallity
       // System.out.println("button login is clicked");
       // System.out.println("username is: " + UserNameField.getText());
       // System.out.println("password is: " + passFiled.getText() );

            try {
                String userName = UserNameField.getText();
                String password = passFiled.getText();

               User user= login(userName,password);//use login function to return user or throws exception
               CurrentUserControl.setCurrentUser(user);//law gah hena means mafysh so kda tmm
                if (UserNameField.getText().isEmpty() || passFiled.getText().isEmpty()) {
                    //if any field fady fa2nta user mo2raff
                    feedbackLabel.setText("Username and password cannot be empty");
                    return;
                }

                feedbackLabel.setText("Login successful: Welcome, " + userName + "!");
                Parent root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("Profile page");
                stage.setScene(scene);
                stage.show();
            }
            catch (Exception e)
            {
                feedbackLabel.setText(e.getMessage());


            }
    }

    @FXML
    void SignUpButtonAction(ActionEvent event) {//5alyh 27san yro7 l seen tany
        //test the button
       // System.out.println("signup action triggered");
        try
        {
        Parent root = FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Set Up Account");
            stage.setScene(scene);
            stage.show();
             }
            catch( Exception e)
            {
                feedbackLabel.setText("error occurred ,please try again");
            }
        }

    }


