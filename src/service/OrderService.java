package service;

import model.Order;
import model.Product;
import model.User;
import utils.FileService;
import utils.Helper;

import java.util.*;

public class OrderService {
    private List<Order> orders;
    private Helper helper;
    private FileService fileService;

    public OrderService() {
        this.orders = new ArrayList<Order>();
        this.helper = new Helper();
        this.fileService = FileService.getFileService();
    }

    public OrderService(List<Order> orders) {
        this.orders = orders;
        this.helper = new Helper();
        this.fileService = FileService.getFileService();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "orders=" + orders +
                '}';
    }

    // HELP

    private float getTotalFromOrder(Order order) {
        float total = 0;
        for(Product product: order.getShoppingCart().getProducts()) {
            total = total + product.getPrice();
        }
        return total;
    }

    // ADD

    public void addOrder(Order order) {
        this.fileService.logEvent("Added a new order");
        this.orders.add(order);
    }

    public void addOrders(Order... orders) {
        for(Order order: orders) {
            this.addOrder(order);
        }
    }

    // SEARCH

    public List<Order> searchOrdersByEmail(String email) {
        this.fileService.logEvent("Searched orders by email");
        List<Order> ordersFound = new ArrayList<Order>();
        TreeSet<User> users = new TreeSet<User>();

        for(Order order: this.orders) {
            users.add(order.getUser());
        }

        if (this.helper.emailAlreadyExists(email, users)) {
            for(Order order: this.orders) {
                if (this.helper.areStringsEqual(order.getUser().getEmail(), email)) {
                    ordersFound.add(order);
                }
            }
        }
        return ordersFound;
    }

    // GET

    public float getTotalFromOrderByEmail(String email) {
        this.fileService.logEvent("Got total from order by email");
        TreeSet<User> users = new TreeSet<User>();

        for(Order order: this.orders) {
            users.add(order.getUser());
        }

        if(this.helper.emailAlreadyExists(email, users)) {
            for(Order order: this.orders) {
                if (this.helper.areStringsEqual(order.getUser().getEmail(), email)) {
                    return this.getTotalFromOrder(order);
                }
            }
        }
        return 0;
    }
}
