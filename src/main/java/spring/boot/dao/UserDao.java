package spring.boot.dao;

import spring.boot.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> listUsers();

    void deleteUser(User user);

    void deleteUserById(Long id);

    User findUserById(Long id);

    void updateUser(User user);

}
