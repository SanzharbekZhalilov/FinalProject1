package company.service;

import company.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User getById(int id);

    void removeById(int id);

    List<User> getAll();

}
