package org.example;

import org.example.dao.UserDaoJDBCImpl;
import org.example.model.User;
import org.example.servise.UserService;
import org.example.servise.UserServiceHibernateImpl;
import org.example.servise.UserServiceJDBCImpl;
import org.example.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        script(new UserServiceJDBCImpl());
        script(new UserServiceHibernateImpl());

    }

    private static void script(UserService userService) {
        userService.createUserTable();
        userService.saveUser("Ivan", "Petrov", (byte) 37);
        userService.saveUser("Petr", "Sidorov", (byte) 47);
        userService.saveUser("Ivan", "Petrov", (byte) 37);

        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);

        userService.clearUserTable();

        userService.dropUserTable();
    }
}
