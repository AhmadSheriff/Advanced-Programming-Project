package com.example.demo2;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserManagement {
    private static final String USER_DATA_FILE = "src/main/resources/com/example/demo2/usersData.txt";
    public static List<User> loadUserData(){ // load users from txt file and return them in array list <user>
        List<User> users = new ArrayList<>();// da what will be returned
        try {
            FileReader reader = new FileReader(USER_DATA_FILE);
            Scanner scanner = new Scanner(reader); //read file
            while (scanner.hasNextLine()) //loop on lines
            {
                String line = scanner.nextLine();//take next line
                User user = User.fromString(line);//function in user used here to get users object back from string
                if (user != null) //check on null
                {
                    users.add(user); //add user to the arraylist of the program
                }
            }

            }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return users;
    }
    public static void addUser(User user) { //add user to my txt file
        try
        {
            FileWriter writer = new FileWriter(USER_DATA_FILE, true); // true for append
            writer.write(user.toString() + "\n"); // matnsysh da kan sabab 2nak 3amlty override lel function
            writer.close(); // line 3lshan yprevent el error

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}




