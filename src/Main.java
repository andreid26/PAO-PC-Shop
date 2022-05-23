import model.Case;
import model.User;
import service.ProductService;
import service.UserService;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        ProductService productService = new ProductService();
        UserService userService = new UserService();

        userService.addUser(new User("Victor", "Test", "victor@gmail.com", "victor's address", "12345678", 2001, 0));
        productService.addProduct(new Case("case name", "case description", "case brand", 250, 5, true, "red", 0));
    }
}
