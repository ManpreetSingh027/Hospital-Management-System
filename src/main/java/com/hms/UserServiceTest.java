package com.hms;
import com.hms.user.model.User;
import com.hms.user.service.UserService;


public class UserServiceTest {
    public static void main(String[] args) {
        UserService userService = new UserService();

        // ➕ Add a new user
        User user = new User("admin", "admin123", "admin");
        userService.addUser(user);

        // 🔍 Get user by username
        User found = userService.getUserByUsername("admin");
        if (found != null) {
            System.out.println("Found user: " + found);
        } else {
            System.out.println("User not found.");
        }

        // 📋 List all users
        System.out.println("All users:");
        userService.getAllUsers().forEach(System.out::println);
    }
}
