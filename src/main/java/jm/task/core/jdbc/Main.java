package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.createUsersTable();
        userService.saveUser("Jungkook", "Jeon", (byte) 23);
        userService.saveUser("Taehyung", "Kim", (byte)25);
        userService.saveUser("Jimin", "Park", (byte)25);
        userService.saveUser("Yoongi", "Min", (byte)27);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
        userService.dropUsersTable();

    }
}
