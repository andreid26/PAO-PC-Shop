package repository;

import config.DatabaseConnection;
import model.Case;
import model.GPU;
import model.Product;
import model.RAM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductRepository {
    private Connection connection;

    public ProductRepository() throws SQLException {
        this.connection = DatabaseConnection.getInstance();
    }

    // Case

    public List<Product> getCases(){
        List<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM case_";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String brand = resultSet.getString("brand");
                float price = resultSet.getFloat("price");
                int coolersNumber = resultSet.getInt("coolersNumber");
                boolean rgb = resultSet.getBoolean("rgb");
                String color = resultSet.getString("color");
                products.add(new Case(name, description, brand, price, coolersNumber, rgb, color, id));
            }
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
        return products;
    }

    public void saveCase(Case _case, boolean isUpdate){
        String query;

        if (isUpdate) {
            query =  "UPDATE case_ SET name=?, description=?, brand=?, price=?, coolersNumber=?, rgb=?, color=? WHERE id=?";
        } else {
            query = "INSERT INTO case_ VALUES (null,?,?,?,?,?,?,?)";
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, _case.getName());
            preparedStatement.setString(2, _case.getDescription());
            preparedStatement.setString(3, _case.getBrand());
            preparedStatement.setFloat(4, _case.getPrice());
            preparedStatement.setInt(5, _case.getCoolersNumber());
            preparedStatement.setBoolean(6, _case.isRgb());
            preparedStatement.setString(7, _case.getColor());

            if (isUpdate) {
                preparedStatement.setInt(8, _case.getId());
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
    }

    // GPU

    public List<Product> getGpus(){
        List<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM gpu";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String brand = resultSet.getString("brand");
                float price = resultSet.getFloat("price");
                int memory = resultSet.getInt("memory");
                int portsNumber = resultSet.getInt("portsNumber");
                products.add(new GPU(name, description, brand, price, memory, portsNumber, id));
            }
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
        return products;
    }

    public void saveGpu(GPU gpu, boolean isUpdate){
        String query;

        if (isUpdate) {
            query = "UPDATE gpu SET name=?, description=?, brand=?, price=?, memory=?, portsNumber=? WHERE id=?";
        } else {
            query = "INSERT INTO gpu VALUES (null,?,?,?,?,?,?)";
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, gpu.getName());
            preparedStatement.setString(2, gpu.getDescription());
            preparedStatement.setString(3, gpu.getBrand());
            preparedStatement.setFloat(4, gpu.getPrice());
            preparedStatement.setInt(5, gpu.getMemory());
            preparedStatement.setInt(6, gpu.getPortsNumber());

            if (isUpdate) {
                preparedStatement.setInt(7, gpu.getId());
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
    }

    // RAM

    public List<Product> getRams() {
        List<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM ram";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String brand = resultSet.getString("brand");
                float price = resultSet.getFloat("price");
                int capacity = resultSet.getInt("capacity");
                String latency = resultSet.getString("latency");
                products.add(new RAM(name, description, brand, price, latency, capacity, id));
            }
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
        return products;
    }

    public void saveRam(RAM ram, boolean isUpdate) {
        String query;

        if (isUpdate) {
            query = "UPDATE ram SET name=?, description=?, brand=?, price=?, capacity=?, latency=? WHERE id=?";
        } else {
            query = "INSERT INTO ram VALUES (null,?,?,?,?,?,?)";
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ram.getName());
            preparedStatement.setString(2, ram.getDescription());
            preparedStatement.setString(3, ram.getBrand());
            preparedStatement.setFloat(4, ram.getPrice());
            preparedStatement.setInt(5, ram.getCapacity());
            preparedStatement.setString(6, ram.getLatency());

            if (isUpdate) {
                preparedStatement.setInt(7, ram.getId());
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
    }

    // All

    public List<Product> getAll(){
        List<Product> cases = this.getCases();
        List<Product> gpus = this.getGpus();
        List<Product> rams = this.getRams();
        return Stream.of(cases, gpus, rams).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public void delete(String tableName, int id) {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception - " + e);
        }
    }
}
