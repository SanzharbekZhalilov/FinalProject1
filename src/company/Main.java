package company;

import company.model.Gender;
import company.model.User;
import company.service.UserService;
import company.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Sanzhar", 28, Gender.MALE);
        User user2 = new User(2, "Kanykei", 20, Gender.FEMALE);
        User user3 = new User(3, "Maks", 23, Gender.MALE);

        UserService userService = new UserServiceImpl();
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        int getID = 1;
        int removeID = 2;

        try {
            System.out.println("Get by ID: " + userService.getById(getID));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("All users:" + userService.getAll());

        try {
            System.out.println("\nRemove by ID: " + userService.getById(removeID));
            userService.removeById(removeID);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("All users:" + userService.getAll());
    }
}