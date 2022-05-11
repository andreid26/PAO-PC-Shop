package model;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class User implements Comparable<User> {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private int bornYear;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.address = "";
        this.phoneNumber = "";
        this.bornYear = 0;
    }

    public User(String firstName, String lastName, String email, String address, String phoneNumber, int bornYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bornYear = bornYear;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User first name: ");
        this.firstName = scanner.next();
        System.out.println("User last name: ");
        this.lastName = scanner.next();
        System.out.println("User email: ");
        this.email = scanner.next();
        System.out.println("User address: ");
        this.address = scanner.next();
        System.out.println("User phone number: ");
        this.phoneNumber = scanner.next();
        System.out.println("User born year: ");
        this.bornYear = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bornYear=" + bornYear +
                '}';
    }

    @Override
    public int compareTo(User user) {
        if (this.bornYear < user.getBornYear()) {
            return -1;
        }
        return 1;
    }

    public String getPropertiesString() {
        List<String> props = Arrays.asList(this.firstName, this.lastName, this.email, this.address, this.phoneNumber, String.valueOf(this.bornYear));
        return String.join(",", props);
    }
}
