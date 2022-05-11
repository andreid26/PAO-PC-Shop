import service.ProductService;
import service.UserService;
import utils.FileService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        productService.initializeProducts();
        System.out.println(productService.getProducts().size());

        UserService userService = new UserService();
        userService.initializeUsers();
        System.out.println(userService.getUsers().size());
    }
}
