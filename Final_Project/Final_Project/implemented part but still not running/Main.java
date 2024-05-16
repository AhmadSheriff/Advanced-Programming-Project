package advancedprogrammingproject;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;
import java.util.UUID;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		 primaryStage.setTitle("Direct Messages");

	        
	        GridPane grid = new GridPane();
	        grid.setPadding(new Insets(10, 10, 10, 10));
	        grid.setVgap(8);
	        grid.setHgap(10);

	        
	        Label senderLabel = new Label("Sender:");
	        GridPane.setConstraints(senderLabel, 0, 0);
	        TextField senderInput = new TextField();
	        GridPane.setConstraints(senderInput, 1, 0);

	        
	        Label recipientLabel = new Label("Recipient:");
	        GridPane.setConstraints(recipientLabel, 0, 1);
	        TextField recipientInput = new TextField();
	        GridPane.setConstraints(recipientInput, 1, 1);

	        
	        Label contentLabel = new Label("Content:");
	        GridPane.setConstraints(contentLabel, 0, 2);
	        TextArea contentInput = new TextArea();
	        GridPane.setConstraints(contentInput, 1, 2);

	        
	        Label messageTypeLabel = new Label("Message Type:");
	        GridPane.setConstraints(messageTypeLabel, 0, 3);
	        TextField messageTypeInput = new TextField();
	        GridPane.setConstraints(messageTypeInput, 1, 3);

	        
	        Button submitButton = new Button("Send Message");
	        GridPane.setConstraints(submitButton, 1, 4);
	        submitButton.setOnAction(e -> {
	            primaryStage.close();
	        });
	        grid.getChildren().addAll(senderLabel, senderInput, recipientLabel, recipientInput, contentLabel, contentInput, messageTypeLabel, messageTypeInput, submitButton);
	Scene scene = new Scene(grid, 600, 400);
    primaryStage.setScene(scene);
    
    submitButton.setOnAction(e -> {
        
        String sender = senderInput.getText();
        String recipient = recipientInput.getText();
        String content = contentInput.getText();
        String messageType = messageTypeInput.getText();

 
        User senderUser = new User(sender, "password", true, "sender@example.com");
        User recipientUser = new User(recipient, "password", true, "recipient@example.com");

      
        DirectMessages message = new DirectMessages(senderUser, recipientUser, content, messageType);

        
        try {
            
            senderUser.addPost(sender, content);
            
            message.addCommentInPost("This is a comment on the message.");
            
        } catch (IllegalArgumentException ex) {
            System.out.println("Failed to perform action: " + ex.getMessage());
        }

     
        primaryStage.close();
    });

   

    
    primaryStage.show();}

	      
	public static void main(String[] args) {
		launch(args);
	}
}
