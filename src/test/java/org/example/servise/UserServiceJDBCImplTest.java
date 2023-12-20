package org.example.servise;

import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceJDBCImplTest {
    private final String testName = "Jone";
    private final String testLastName = "Ivan";
    private final byte testAge = 35;
    private final UserService userService = new UserServiceJDBCImpl();

    @BeforeEach
    void testTuning() {
        userService.dropUserTable();
        userService.createUserTable();
        userService.saveUser(testName, testLastName, testAge);
    }

    @Test
    void createUserTable() {
        userService.dropUserTable();
        assertDoesNotThrow(userService::createUserTable, "При создании таблици произошла ошибка");
    }

    @Test
    void dropUserTable() {
        assertDoesNotThrow(userService::dropUserTable);
    }

    @Test
    void saveUser() {
        User user = new User(1, testName, testLastName, testAge);
        assertEquals(user, userService.getAllUsers().get(0));
    }

    @Test
    void removeUserById() {
        userService.removeUserById(1);
        assertTrue(userService.getAllUsers().isEmpty(), "Проверьте корректнеость метода удаления");
    }

    @Test
    void getAllUsers() {
        assertEquals(1, userService.getAllUsers().size(), "Проверьте корректность получения Юзеров");
    }

    @Test
    void clearUserTable() {
        userService.clearUserTable();
        assertTrue(userService.getAllUsers().isEmpty(), "Метод очистки работает некорректно");
    }
}