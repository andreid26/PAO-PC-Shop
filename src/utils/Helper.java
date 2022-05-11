package utils;

import model.User;

import java.util.Map;

import java.util.TreeSet;

public class Helper {

    public boolean emailAlreadyExists(String email, TreeSet<User> users) {
        for(User user: users) {
            if (user.getEmail().toLowerCase().equals(email.toLowerCase())) return true;
        }
        return false;
    }

    public boolean areStringsSimilar(String first, String second) {
        return first.toLowerCase().contains(second.toLowerCase());
    }

    public boolean areStringsEqual(String first, String second) {
        return first.equalsIgnoreCase(second);
    }

}
