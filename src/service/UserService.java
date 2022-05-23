package service;

import model.*;
import repository.UserRepository;
import utils.FileService;
import utils.Helper;

import java.sql.SQLException;
import java.util.*;

public class UserService {
    private TreeSet<User> users;
    private Helper helper;
    private FileService fileService;
    private UserRepository userRepository;

    public UserService() throws SQLException {
        this.users = new TreeSet<User>();
        this.helper = new Helper();
        this.fileService = FileService.getFileService();
        this.userRepository = new UserRepository();
        this.initializeUsers();
    }

    public UserService(TreeSet<User> users) throws SQLException {
        this.users = users;
        this.helper = new Helper();
        this.fileService = FileService.getFileService();
        this.userRepository = new UserRepository();
        this.initializeUsers();
    }

    public TreeSet<User> getUsers() {
        return users;
    }

    public void setUsers(TreeSet<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "users=" + users +
                '}';
    }

    // ADD USERS FROM CSV

    public void initializeUsers() {
        this.fileService.logEvent("Reading from file user.csv");
        TreeSet<User> users = this.userRepository.getUsers();
        this.setUsers(users);
    }

    public void addUsersFromCsv(List<String> usersArray) {
        for(String userString: usersArray) {
            String[] userProps = userString.split(",");
            User user = new User(userProps[0], userProps[1], userProps[2], userProps[3], userProps[4], Integer.parseInt(userProps[5]), 0);
            this.users.add(user);
        }
    }

    private void writeUserToCsv(User user) {
        this.fileService.writeToFile("user.csv", user.getPropertiesString());
    }


    // ADD

    public void addUser(User user) {
        if (this.helper.emailAlreadyExists(user.getEmail(), this.users)) {
            System.out.println("This email already exists.");
        } else {
            this.users.add(user);
            this.fileService.logEvent("Writing to file user.csv");
            this.userRepository.saveUser(user, false);
            this.initializeUsers();
        }
    }

    public void createNewUser() {
        User newUser = new User();
        newUser.read();
        this.addUser(newUser);
    }

    public void addUsers(User... users) {
        for(User user: users) {
            if (this.helper.emailAlreadyExists(user.getEmail(), this.users)) {
                System.out.println("model.User with email " + user.getEmail() + " already exists.");
            } else {
                this.addUser(user);
            }
        }
    }

    // SEARCH

    public User searchUserByEmail(String email) {
        this.fileService.logEvent("Searched user by email");
        for(User user: this.users) {
            if (this.helper.areStringsEqual(user.getEmail(), email)) return user;
        }
        return null;
    }

    // UPDATE

    public void updateUser(User user) {
        this.userRepository.saveUser(user, true);
    }

    // DELETE

    public void deleteUser(User user) {
        this.userRepository.delete(user.getId());
    }

    public void deleteUser(int id) {
        this.userRepository.delete(id);
    }

}
