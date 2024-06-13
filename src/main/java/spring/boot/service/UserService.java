package spring.boot.service;

import spring.boot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    void deleteUserById(Long id);

    User findUserById(Long id);

    void updateUser(User user);
}
