import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.address = "";
        this.phoneNumber = "";
    }

    public User(String firstName, String lastName, String email, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
