package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface UserDao {

    User getUserByEmail(String loginEmail);

    User getUserByUsername(String username);

    User loginUser(String email, String password);

    void addUser(User user);

    void removeUser(User user);

    List<User> getAllUsers();

    User getUser(int userId);

    boolean userExists(int userId);

}
