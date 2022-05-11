import model.Case;
import model.User;
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

        User user = new User("Victor", "Test", "victor@gmail.com", "victor's address", "12345678", 2001);
        userService.addUser(user);

        Case _case = new Case("Carcasa", "Descriere carcasa", "Brand carcasa", 999, 8, true, "red");
        productService.addProduct(_case);
    }
}
