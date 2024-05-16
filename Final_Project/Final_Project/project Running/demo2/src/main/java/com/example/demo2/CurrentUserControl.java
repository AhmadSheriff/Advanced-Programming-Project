package com.example.demo2;

public class CurrentUserControl {

//shared with all
        private static User currentUser;

        public static void setCurrentUser(User user) {
            currentUser = user;
        }

        public static User getCurrentUser() {
            return currentUser;
        }


}
