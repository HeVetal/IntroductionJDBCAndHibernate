package org.example;

import org.example.dao.UserDaoJDBCImpl;
import org.example.model.User;
import org.example.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUserTable();
    }
}
