package company.service.impl;

import company.MyException;
import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDao();

    @Override
    public void addUser(User user) {
        List<User> users = userDao.getUsers();
        users.add(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getUsers()
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new MyException("Exception: User with ID №" + id + " not found to get"));
    }

    @Override
    public void removeById(int id) {
        userDao.getUsers()
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new MyException("Exception: User with ID №" + id + " not found to remove"));
        userDao.getUsers().removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getUsers();
    }
}