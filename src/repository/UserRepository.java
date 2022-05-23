package repository;

import config.DatabaseConnection;
import model.Case;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class UserRepository {
    private Connection connection;

    public UserRepository () throws SQLException {
        this.connection = DatabaseConnection.getInstance();
    }

    // GET

    public TreeSet<User> getUsers(){
        TreeSet<User> users = new TreeSet<User>();
        String query = "SELECT * FROM user";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                int bornYear = resultSet.getInt("bornYear");
                users.add(new User(firstName, lastName, email, address, phoneNumber, bornYear, id));
            }
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
        return users;
    }

    // SAVE / UPDATE

    public void saveUser(User user, boolean isUpdate){
        String query;

        if (isUpdate) {
            query =  "UPDATE user SET firstName=?,lastName=?, email=?, address=?, phoneNumber=?, bornYear=? WHERE id=?";
        } else {
            query = "INSERT INTO user VALUES (null,?,?,?,?,?,?)";
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setInt(6, user.getBornYear());

            if (isUpdate) {
                preparedStatement.setInt(7, user.getId());
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
    }

    // DELETE

    public void delete(int id) {
        String query = "DELETE FROM user WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
    }
}
